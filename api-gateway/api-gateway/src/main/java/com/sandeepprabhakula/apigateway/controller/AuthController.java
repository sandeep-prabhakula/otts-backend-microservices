package com.sandeepprabhakula.apigateway.controller;

import com.sandeepprabhakula.apigateway.models.AuthResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public ResponseEntity<AuthResponse> login(@RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client, @AuthenticationPrincipal OidcUser user){
        AuthResponse response = new AuthResponse();
        response.setUserId(user.getEmail());
        response.setAccessToken(client.getAccessToken().getTokenValue());
        response.setRefreshToken(client.getRefreshToken().getTokenValue());
        response.setExpiresAt(client.getAccessToken().getExpiresAt().getEpochSecond());
        List<String> authorities = user
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        response.setAuthorities(authorities);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
