package com.security.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import com.security.model.Client;
import com.security.model.User;
@Service
public class ClientDetailServiceImpl implements ClientDetailsService{
	private static final Integer THIRTY_DAYS = 60 * 60 * 24 * 30;
	
	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		 Client client = this.existeUsuario(clientId);
        if (client == null) {
            throw new ClientRegistrationException("Client not found with clientId: " + clientId);
        }
        BaseClientDetails baseClient= new BaseClientDetails();
        
        baseClient.setClientId(client.getClient());
        baseClient.setClientSecret(client.getSecret());
        baseClient.setAuthorizedGrantTypes(client.getGrantTypes());
        baseClient.setScope(client.getScope());
        Collection<GrantedAuthority> authorities= new HashSet<>();
        for(String auth:client.getAuthorities()) {
	        GrantedAuthority e = new SimpleGrantedAuthority(auth);
	        authorities.add(e);
        }
		baseClient.setAuthorities(authorities);
        baseClient.setAccessTokenValiditySeconds(client.getAccessSecond());
        baseClient.setRefreshTokenValiditySeconds(client.getRefreshSecond());
        return baseClient;
	}
	
	private Client existeUsuario(String username) {
		Client client=null;
		switch (username) {
			case "exampleClient":
				System.out.print("entre a buscar client");
				client=new Client();
				List<String>  grantTypes=new ArrayList<String>();
				grantTypes.add("password");
				grantTypes.add("refresh_token");
				grantTypes.add("client_credentials");
				List<String>  authorities=new ArrayList<String>();
				authorities.add("ROLE_CLIENT");
				authorities.add("ROLE_TRUSTED_CLIENT");
				List<String> scope=new ArrayList<String>();
				scope.add("read");
				scope.add("write");
				scope.add("trust");
				client.setClient("exampleClient");
				client.setSecret("{noop}exampleSecret");
				client.setGrantTypes(grantTypes);
				client.setAuthorities(authorities);
				client.setScope(scope);
				client.setRefreshSecond(THIRTY_DAYS);
				client.setAccessSecond(300);
			break;
			default:
			break;
		}
		return client;
	}

}
