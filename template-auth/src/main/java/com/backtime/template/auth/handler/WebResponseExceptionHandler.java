package com.backtime.template.auth.handler;

import com.backtime.template.common.response.BaseResult;
import io.swagger.annotations.ApiResponse;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.stereotype.Component;

/**
 * @author backtime
 * @date 2021/10/6 21:59
 * @description: 认证异常返回格式
 */
@Component
public class WebResponseExceptionHandler implements WebResponseExceptionTranslator {
    @Override
    public ResponseEntity translate(Exception e) throws Exception {
        OAuth2Exception oAuth2Exception = (OAuth2Exception) e;
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(BaseResult.newFailure(oAuth2Exception.getHttpErrorCode(), e.getMessage()));
    }
}
