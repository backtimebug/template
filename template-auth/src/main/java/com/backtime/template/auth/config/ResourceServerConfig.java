package com.backtime.template.auth.config;

import com.backtime.template.common.enums.Code;
import com.backtime.template.common.response.BaseResult;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author backtime
 * @date 2021/10/6 21:55
 * @description: TODO
 */
@DependsOn(value = "objectMapper")
@Configuration
@EnableResourceServer
// 激活preAuthorize注解
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        //        resources.tokenServices(remoteTokenServices());
        // 自定义未认证返回数据格式
        // 并不是登录接口认证失败
        // 当拒绝访问时返回消息
        resources.accessDeniedHandler((request, response, e) -> {
            BaseResult result = BaseResult.newFailure(Code.FORBIDDEN);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding("utf-8");
            response.getWriter()
                    .write(objectMapper.writeValueAsString(result));
        });
        // 当认证失败时返回消息
        resources.authenticationEntryPoint((request, response, e) -> {
            BaseResult result = BaseResult.newFailure(Code.UNAUTHORIZED);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding("utf-8");
            response.getWriter()
                    .write(objectMapper.writeValueAsString(result));
        });
    }

    /**
     *
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity security) throws Exception {
        // 所有请求都需要认证
        security.authorizeRequests()
                //下边的路径放行
                .antMatchers("/swagger*//**",
                        "/webjars*//**", "**/favicon.ico").permitAll();
    }

}
