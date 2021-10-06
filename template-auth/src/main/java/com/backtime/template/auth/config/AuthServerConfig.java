package com.backtime.template.auth.config;

import com.backtime.template.auth.enhancer.AuthTokenEnhancer;
import com.backtime.template.auth.handler.AuthInfoHandler;
import com.backtime.template.auth.handler.WebResponseExceptionHandler;
import com.backtime.template.auth.service.UserService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;

import java.util.Arrays;

/**
 * @author backtime
 * @date 2021/10/6 21:40
 * @description: 认证服务配置
 */
@Configuration
@EnableAuthorizationServer
@DependsOn("objectMapper")
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {
    @Value("${application.clientId}")
    private String clientId;

    @Value("${application.clientSecret}")
    private String clientSecret;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenStore redisTokenStore;

    @Autowired
    private WebResponseExceptionHandler webResponseExceptionHandler;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // ①自定义令牌增强器
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(new AuthTokenEnhancer()));
        endpoints.tokenEnhancer(tokenEnhancerChain);
        // 集成websecurity认证
        endpoints.authenticationManager(authenticationManager);
        // 注册redis令牌仓库
        endpoints.tokenStore(redisTokenStore);
        endpoints.exceptionTranslator(webResponseExceptionHandler);

        // ①自定义token接口 返回格式
        DefaultAccessTokenConverter converter = new DefaultAccessTokenConverter();
        DefaultUserAuthenticationConverter userAuthenticationConverter
                = new AuthInfoHandler();
        userAuthenticationConverter.setUserDetailsService(userService);
        converter.setUserTokenConverter(userAuthenticationConverter);
        endpoints.accessTokenConverter(converter);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // 允许通过form提交客户端认证信息(client_id,client_secret),默认为basic方式认证
        security.allowFormAuthenticationForClients();
        // "/oauth/check_token"端点默认不允许访问
        security.checkTokenAccess("isAuthenticated()");
        // "/oauth/token_key"断点默认不允许访问
        security.tokenKeyAccess("isAuthenticated()");
        // 配置密码编码器
        security.passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 注册自定义客户端信息服务
        clients.inMemory().withClient(clientId)
                .authorizedGrantTypes("password", "refresh_token")
                .secret(passwordEncoder.encode(clientSecret))
                .scopes("all");
    }

}
