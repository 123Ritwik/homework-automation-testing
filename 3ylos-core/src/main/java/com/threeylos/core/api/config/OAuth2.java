package com.threeylos.core.api.config;

import com.threeylos.core.api.model.OAuth2Credentials;
import com.threeylos.core.api.model.TokenResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.time.Instant;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public final class OAuth2 {

    private final OAuth2Credentials creds;

    private final boolean isCredentialsInBody;

    private TokenResponse tokenResponse;

    public OAuth2(final OAuth2Credentials creds, final boolean isCredentialsInBody) {
        this.creds = creds;
        this.isCredentialsInBody = isCredentialsInBody;
        tokenResponse = getTokenResponse(creds);
    }

    private TokenResponse getTokenResponse(final OAuth2Credentials creds) {
        try {
            final var requestSpec = RestAssured.given()
                    .contentType(ContentType.URLENC)
                    .param("grant_type", "client_credentials");
            if (isCredentialsInBody) {
                requestSpec.param("client_id", creds.getClientId())
                        .param("client_secret", creds.getClientSecret());
            } else {
                requestSpec.auth()
                        .preemptive()
                        .basic(creds.getClientId(), creds.getClientSecret());
            }
            if (isNotBlank(creds.getScope())) {
                requestSpec.param("scope", creds.getScope());
            }
            final var response = requestSpec.post(creds.getTokenIssuerURL())
                    .as(TokenResponse.class);
            response.setRefreshTime(Instant.now()
                    .getEpochSecond() + response.getTokenLifetime() - 20);
            return response;
        } catch (Exception ex) {
            throw new RuntimeException(ex);

        }
    }

    public String getToken() {
        refreshTokenResponse();
        return tokenResponse.getAccessToken();
    }

    public synchronized void refreshTokenResponse() {
        if (!isActual(tokenResponse)) {
            tokenResponse = getTokenResponse(creds);
        }
    }

    private boolean isActual(final TokenResponse tokenResponse) {
        return tokenResponse.getRefreshTime() > Instant.now()
                .getEpochSecond();
    }
}
