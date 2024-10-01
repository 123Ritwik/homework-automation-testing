package com.threeylos.core.api.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author AbhinitKumar
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenResponse {

    @JsonAlias("access_token")
    private String accessToken;

    @JsonAlias("expires_in")
    private long tokenLifetime;

    @JsonIgnore
    private long refreshTime;
}
