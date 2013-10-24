package com.egt.ws.security;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: sakuracute
 * Date: 10/19/13
 * Time: 1:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProviderTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        DefaultOAuth2AccessToken result = new DefaultOAuth2AccessToken(accessToken);
        result.setAdditionalInformation(Collections.singletonMap("client_id", (Object) authentication.getOAuth2Request().getClientId()));
        return result;
    }
}
