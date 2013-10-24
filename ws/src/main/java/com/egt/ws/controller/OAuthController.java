package com.egt.ws.controller;

import com.egt.ws.security.ProviderUserApprovalHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: sakuracute
 * Date: 10/20/13
 * Time: 7:36 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class OAuthController {

    private ConsumerTokenServices tokenServices;

    private TokenStore tokenStore;

    private ProviderUserApprovalHandler providerUserApprovalHandler;

    @RequestMapping("/oauth/cache_approvals")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void startCaching() throws Exception {
        providerUserApprovalHandler.setUseApprovalStore(true);
    }

    @RequestMapping("/oauth/uncache_approvals")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void stopCaching() throws Exception {
        providerUserApprovalHandler.setUseApprovalStore(false);
    }

    @RequestMapping("/oauth/users/{user}/tokens")
    @ResponseBody
    public Collection<OAuth2AccessToken> listTokensForUser(@PathVariable String user, Principal principal)
            throws Exception {
        checkResourceOwner(user, principal);
        return tokenStore.findTokensByUserName(user);
    }

    @RequestMapping(value = "/oauth/users/{user}/tokens/{token}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> revokeToken(@PathVariable String user, @PathVariable String token, Principal principal)
            throws Exception {
        checkResourceOwner(user, principal);
        if (tokenServices.revokeToken(token)) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping("/oauth/clients/{client}/tokens")
    @ResponseBody
    public Collection<OAuth2AccessToken> listTokensForClient(@PathVariable String client) throws Exception {
        return tokenStore.findTokensByClientId(client);
    }

    private void checkResourceOwner(String user, Principal principal) {
        if (principal instanceof OAuth2Authentication) {
            OAuth2Authentication authentication = (OAuth2Authentication) principal;
            if (!authentication.isClientOnly() && !user.equals(principal.getName())) {
                throw new AccessDeniedException(String.format("User '%s' cannot obtain tokens for user '%s'",
                        principal.getName(), user));
            }
        }
    }

    public ProviderUserApprovalHandler getProviderUserApprovalHandler() {
        return providerUserApprovalHandler;
    }

    public void setProviderUserApprovalHandler(ProviderUserApprovalHandler providerUserApprovalHandler) {
        this.providerUserApprovalHandler = providerUserApprovalHandler;
    }

    /**
     * @param tokenServices the consumerTokenServices to set
     */
    public void setTokenServices(ConsumerTokenServices tokenServices) {
        this.tokenServices = tokenServices;
    }

    /**
     * @param tokenStore the tokenStore to set
     */
    public void setTokenStore(TokenStore tokenStore) {
        this.tokenStore = tokenStore;
    }

}
