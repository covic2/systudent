package com.security.principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import com.security.config.AuthServerConfig;
import com.security.config.SecurityConfig;

@SpringBootApplication
@ComponentScan({"com.security.service"})
@Import({AuthServerConfig.class,SecurityConfig.class})
public class SsoSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsoSecurityApplication.class, args);
	}
	
	private String signingKey="as466gf";
	@Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(signingKey);  // Clave secreta para firmar el token
        return converter;
    }
	
	
	/*@Bean
    public JwtTokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }*/
	
	
	@Bean
    public TokenStore tokenStore(RedisConnectionFactory redisConnectionFactory) {
		
        return new RedisTokenStore(redisConnectionFactory);
    }

}
