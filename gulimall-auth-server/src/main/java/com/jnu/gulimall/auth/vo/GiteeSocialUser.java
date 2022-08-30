package com.jnu.gulimall.auth.vo;

import lombok.Data;


@Data
public class GiteeSocialUser {
    private String accessToken;

    private String tokenType;

    private Long expiresIn;

    private String refreshToken;

    private String scope;

    private String createdAt;

}
