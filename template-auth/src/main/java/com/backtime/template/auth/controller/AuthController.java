package com.backtime.template.auth.controller;

import com.alibaba.fastjson.JSONObject;
import com.backtime.template.common.constant.Constants;
import com.backtime.template.common.enums.Code;
import com.backtime.template.common.response.BaseResult;
import io.swagger.annotations.ApiResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.Principal;
import java.util.*;

/**
 * @author backtime
 * @date 2021/10/6 22:12
 * @description: TODO
 */
@RestController
@RequestMapping("/oauth")
public class AuthController {

    @Autowired
    private TokenEndpoint tokenEndpoint;

    @Autowired
    private RedisTokenStore redisTokenStore;

    @PostMapping("/token")
    public BaseResult postAccessToken(Principal principal,
                                      @RequestParam Map parameters) throws HttpRequestMethodNotSupportedException {
        try {
            ResponseEntity<OAuth2AccessToken> responseEntity = tokenEndpoint.postAccessToken(principal, parameters);
            OAuth2AccessToken token = responseEntity.getBody();
            if (isBaseResult(token.getAdditionalInformation())) {
                return JSONObject.parseObject(JSONObject.toJSONString(token.getAdditionalInformation()), BaseResult.class);
            }
            return BaseResult.newSuccess(token);
        } catch (Exception e){
            return BaseResult.newFailure(Code.UNAUTHORIZED.getCode(), e.getMessage());
        }
    }

    @PostMapping("/logout")
    public BaseResult logout(HttpServletRequest request, HttpServletResponse response) {
        String accessToken = request.getHeader("Authorization").replace(Constants.TOKEN_PREFIX, "");
        if(StringUtils.isNotBlank(accessToken)){
            OAuth2AccessToken oAuth2AccessToken = redisTokenStore.readAccessToken(accessToken);
            if(oAuth2AccessToken != null){
                System.out.println("----access_token是："+oAuth2AccessToken.getValue());
                redisTokenStore.removeAccessToken(oAuth2AccessToken);
                OAuth2RefreshToken oAuth2RefreshToken = oAuth2AccessToken.getRefreshToken();
                redisTokenStore.removeRefreshToken(oAuth2RefreshToken);
                redisTokenStore.removeAccessTokenUsingRefreshToken(oAuth2RefreshToken);
            }
        }
        return BaseResult.newSuccess();
    }

    private boolean isBaseResult(Map obj) {
        Set<String> objSet = obj.keySet();
        if (Objects.isNull(obj) || objSet.size() == 0) {
            return false;
        }
        List<Field> apiResponseFields = new ArrayList<>();
        for (Field field : BaseResult.class.getDeclaredFields()) {
            //排除静态字段
            if (!Modifier.isStatic(field.getModifiers())) {
                apiResponseFields.add(field);
            }
        }

        boolean result = true;
        for (Field field : apiResponseFields) {
            if (!objSet.contains(field.getName())) {
                result = false;
                break;
            }
        }
        return result;
    }
}
