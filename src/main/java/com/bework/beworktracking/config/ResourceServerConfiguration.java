package com.bework.beworktracking.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Map;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/test").permitAll()
                .antMatchers("/api/tracking").permitAll()
                .and()
                .authorizeRequests()
                .anyRequest().authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        resources.authenticationEntryPoint(new AuthExceptionEntryPoint());
        resources.tokenServices(tokenService());
    }

    @Value("${token.clientId:beeduClient}")
    private String tokenClientId;

    @Value("${token.clientSecret:beeduSecret}")
    private String tokenClientSecret;

    @Value("${token.checkEndpoint:http://localhost:9001/oauth/check_token}")
    private String tokenCheckEndpoint;

    @Bean
    public RemoteTokenServices tokenService() {
        RemoteTokenServices tokenServices = new RemoteTokenServices();
        tokenServices.setClientId(tokenClientId);
        tokenServices.setClientSecret(tokenClientSecret);
        tokenServices.setCheckTokenEndpointUrl(tokenCheckEndpoint);
        tokenServices.setAccessTokenConverter(becrmAccessTokenConverter());
        return tokenServices;
    }

    @Bean
    public JwtAccessTokenConverter becrmAccessTokenConverter() {
        return new BeworkccessTokenConverter();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList(
                "Accept", "Origin", "Content-Type", "Depth", "User-Agent", "If-Modified-Since,",
                "Cache-Control", "Authorization", "X-Req", "X-File-Size", "X-Requested-With", "X-File-Name"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    class BeworkccessTokenConverter extends JwtAccessTokenConverter {
        @Override
        public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
            OAuth2Authentication authen = super.extractAuthentication(map);
            authen.setDetails(map);
            return authen;
        }
    }

}
