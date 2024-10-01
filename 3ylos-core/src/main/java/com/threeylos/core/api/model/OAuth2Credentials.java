package com.threeylos.core.api.model;

import com.threeylos.core.config.ApplicationProperties;
import lombok.Data;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

/**
 * @author AbhinitKumar
 */

@Getter
@Log4j2
@Data
public class OAuth2Credentials {

    private static final String OAUTH2_CLIENT_ID = "OAUTH2_CLIENT_ID";
    private static final String OAUTH2_CLIENT_SECRET = "OAUTH2_CLIENT_SECRET";
    private static final String OAUTH2_TOKEN_URL = "OAUTH2_TOKEN_URL";
    private static final String OAUTH2_SCOPE = "OAUTH2_SCOPE";

    private String clientId;

    private String clientSecret;

    private String tokenIssuerURL;

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public void setTokenIssuerURL(String tokenIssuerURL) {
        this.tokenIssuerURL = tokenIssuerURL;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    private String scope;

    public OAuth2Credentials() {
        this.clientId = System.getenv(OAUTH2_CLIENT_ID) == null ? ApplicationProperties.getValue(OAUTH2_CLIENT_ID)
                : System.getenv(OAUTH2_CLIENT_ID);
        this.clientSecret = System.getenv(OAUTH2_CLIENT_SECRET) == null ? ApplicationProperties.getValue(OAUTH2_CLIENT_SECRET)
                : System.getenv(OAUTH2_CLIENT_SECRET);
        this.tokenIssuerURL = System.getenv(OAUTH2_TOKEN_URL) == null ? ApplicationProperties.getValue(OAUTH2_TOKEN_URL)
                : System.getenv(OAUTH2_TOKEN_URL);
        this.scope =
                System.getenv(OAUTH2_SCOPE) == null ? ApplicationProperties.getValue(OAUTH2_SCOPE) : System.getenv(OAUTH2_SCOPE);

    }

}
