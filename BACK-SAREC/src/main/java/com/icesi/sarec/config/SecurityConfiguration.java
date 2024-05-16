package com.icesi.sarec.config;

import com.nimbusds.jose.jwk.source.ImmutableSecret;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authorization.AuthorityAuthorizationManager;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.security.web.access.intercept.RequestMatcherDelegatingAuthorizationManager;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;


import javax.crypto.spec.SecretKeySpec;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfiguration {
    public final String secret = "longenoughsecrettotestjwtencrypt";

    private final SarecAuthenticationManager authenticationManager;

    @Bean
    public AuthenticationManager authenticationManager(){
        return new ProviderManager(authenticationManager);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthorizationManager<RequestAuthorizationContext> access) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .cors().and()
                .authorizeHttpRequests(auth -> auth.anyRequest().access(access))
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    @Bean
    public JwtDecoder jwtDecoder(){
        byte[] bytes = secret.getBytes();
        SecretKeySpec key = new SecretKeySpec(bytes,0, bytes.length,"RSA");
        return NimbusJwtDecoder.withSecretKey(key).macAlgorithm(MacAlgorithm.HS256).build();
    }

    @Bean
    public JwtEncoder jwtEncoder(){
        return new NimbusJwtEncoder(new ImmutableSecret<>(secret.getBytes()));
    }

    @Bean
    public AuthorizationManager<RequestAuthorizationContext> requestAuthorizationContextAuthorizationManager(HandlerMappingIntrospector introspector) {

        // PUBLIC ENDPOINTS
        RequestMatcher permitAll = new OrRequestMatcher(
                new MvcRequestMatcher(introspector, "/auth/login"),
                new MvcRequestMatcher(introspector, "/swagger-ui/**"),
                new MvcRequestMatcher(introspector, "/documentation/**"),
                new MvcRequestMatcher(introspector, "/user/**"),
                new MvcRequestMatcher(introspector, "/record/**"),
                new MvcRequestMatcher(introspector, "/role/**"),
                new MvcRequestMatcher(introspector, "/transaction/**"),
                new MvcRequestMatcher(introspector, "/transaction-confirmation/**"),
                new MvcRequestMatcher(introspector, "/vehicle/**"),
                new MvcRequestMatcher(introspector, "/record/**"),
                new MvcRequestMatcher(introspector, "/toll/**")
        );

        // PRIVATE ENDPOINTS
        RequestMatcherDelegatingAuthorizationManager.Builder managerBuilder =
                RequestMatcherDelegatingAuthorizationManager.builder().add(permitAll, (context, other) -> new AuthorizationDecision(true))
                        //.add(new MvcRequestMatcher(introspector, "/role"), AuthorityAuthorizationManager.hasAnyAuthority("SCOPE_ADMIN"))
                        .add(new MvcRequestMatcher(introspector, "/account"), AuthorityAuthorizationManager.hasAnyAuthority("SCOPE_NORMAL", "SCOPE_BANK", "SCOPE_ADMIN"))
                        .add(new MvcRequestMatcher(introspector, "/account/**"), AuthorityAuthorizationManager.hasAnyAuthority("SCOPE_NORMAL", "SCOPE_ADMIN"));

        AuthorizationManager<HttpServletRequest> manager = managerBuilder.build();
        return (authentication, object) -> manager.check(authentication, object.getRequest());
    }



}