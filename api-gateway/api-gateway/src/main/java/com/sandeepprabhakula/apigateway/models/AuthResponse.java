package com.sandeepprabhakula.apigateway.models;

import lombok.*;

import java.util.Collection;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

    private String userId;
    private String accessToken;
    private String refreshToken;
    private long expiresAt;
    private Collection<String> authorities;
}
