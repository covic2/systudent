package com.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.security.service.impl.ClientDetailServiceImpl;
import com.security.service.impl.UserDetailServiceImpl;

@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {
	
	private static String REALM="CRM_REALM";

	private static final int THIRTY_DAYS = 60 * 60 * 24 * 30; 
	
	@Autowired
	private TokenStore tokenStore;
	
	@Autowired
	private UserApprovalHandler userApprovalHandler;
 
	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;
	
	@Autowired
    private ClientDetailServiceImpl clientDetailServiceImpl;
	
	@Autowired
	private JwtAccessTokenConverter jwtAccessTokenConverter;
	
	
 
    
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
	    /*clients.inMemory()
	    .withClient("exampleClient")
            .secret("{noop}exampleSecret")
            .authorizedGrantTypes("password", "refresh_token","client_credentials")
            .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
            .scopes("read", "write", "trust")
            .accessTokenValiditySeconds(300)
            .refreshTokenValiditySeconds(THIRTY_DAYS);*/
	    
		clients.withClientDetails(clientDetailServiceImpl);
		
	}
 
	@Bean
    ResourceOwnerPasswordTokenGranterConfig ResourceOwnerPasswordTokenGranter() {
        return new ResourceOwnerPasswordTokenGranterConfig(authenticationManager, authorizationServerTokenServices(), clientDetailServiceImpl, oAuth2RequestFactory());
    }
	
	@Bean
    @Primary
    AuthorizationServerTokenServices authorizationServerTokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore);
        defaultTokenServices.setClientDetailsService(clientDetailServiceImpl);
        defaultTokenServices.setTokenEnhancer(jwtAccessTokenConverter);
        return defaultTokenServices;
    }
	
	@Bean
    OAuth2RequestFactory oAuth2RequestFactory() {
        return new DefaultOAuth2RequestFactory(clientDetailServiceImpl);
    }
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		//endpoints.tokenStore(tokenStore)
		//.userApprovalHandler(userApprovalHandler)
		//.authenticationManager(authenticationManager);
		endpoints.tokenStore(tokenStore)
		.tokenGranter(ResourceOwnerPasswordTokenGranter())
		.authenticationManager(authenticationManager)
		.tokenEnhancer(jwtAccessTokenConverter);
		

	}
 
	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer.realm(REALM);
		oauthServer.checkTokenAccess("permitAll()"); 
	}

}