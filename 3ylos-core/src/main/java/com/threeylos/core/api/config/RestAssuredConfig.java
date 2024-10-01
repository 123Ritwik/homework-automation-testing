package com.threeylos.core.api.config;

import com.threeylos.core.config.ApplicationProperties;
import com.threeylos.core.constant.AuthType;
import io.restassured.http.ContentType;
import lombok.ToString;

/**
 * This class loaded all the rest-assured configuration
 *
 * @author AbhinitKumar
 */
@ToString
public final class RestAssuredConfig {
    private static final String IS_AUTH = "IS_AUTH";
    private static final String CONNECTION_TIMEOUT = "CONNECTION_TIMEOUT";
    private static final String AUTH_TYPE = "AUTH_TYPE";
    private static final String HEADER_AUTH_TOKEN = "HEADER_AUTH_TOKEN";
    private static final String HEADER_AUTH_NAME = "HEADER_AUTH_NAME";
    private static final String HEADER_AUTH_TYPE = "HEADER_AUTH_TYPE";
    private static final String BASIC_AUTH_USER = "BASIC_AUTH_USER";

    private static final String BASIC_AUTH_PASSWORD = "BASIC_AUTH_PASSWORD";
    private static final String PREEMPTIVE_AUTH_USER = "PREEMPTIVE_AUTH_USER";
    private static final String PREEMPTIVE_AUTH_PASSWORD = "PREEMPTIVE_AUTH_PASSWORD";
    private static final String OAUTH1_KEY = "OAUTH1_KEY";
    private static final String OAUTH1_SECRET = "OAUTH1_SECRET";
    private static final String OAUTH1_SECRET_TOKEN = "OAUTH1_SECRET_TOKEN";
    private static final String OAUTH1_ACCESS_TOKEN = "OAUTH1_ACCESS_TOKEN";

    private boolean isAuth = false;
    private int connectionTimeout = 9000;
    private String authType;
    private String headerAuthToken;
    private String headerAuthName;
    private String headerAuthType;
    private String basicAuthUser;
    private String basicAuthPassword;
    private String preemptiveAuthUser;
    private String preemptiveAuthPassword;
    private String oAuth1Key;
    private String oAuth1Secret;
    private String oAuth1SecretToken;
    private String oAuth1AccessToken;

    public boolean isAuth() {
        String isAuth = System.getenv(IS_AUTH) == null ? ApplicationProperties.getValue(IS_AUTH) : System.getenv(IS_AUTH);
        return isAuth == null ? this.isAuth : Boolean.parseBoolean(isAuth);
    }

    public void setAuth(Boolean isAuth) {
        this.isAuth = isAuth;
    }

    public int getConnectionTimeout() {
        int connectionTimeout = System.getenv(CONNECTION_TIMEOUT) == null
                ? ApplicationProperties.getValue(CONNECTION_TIMEOUT) == null ? 9000
                : Integer.parseInt(ApplicationProperties.getValue(CONNECTION_TIMEOUT))
                : Integer.parseInt(System.getenv(CONNECTION_TIMEOUT));
        return connectionTimeout==0?this.connectionTimeout:connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public String getAuthType() {
        String authType = System.getenv(AUTH_TYPE) == null
                ? ApplicationProperties.getValue(AUTH_TYPE) == null ? AuthType.BASIC_AUTH : ApplicationProperties.getValue(AUTH_TYPE)
                : System.getenv(AUTH_TYPE);
        if (this.authType == null) {
            this.authType = authType;
        }
        return this.authType;

    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getHeaderAuthToken() {
        String headerAuthToken = System.getenv(HEADER_AUTH_TOKEN) == null ? ApplicationProperties.getValue(HEADER_AUTH_TOKEN)
                : System.getenv(HEADER_AUTH_TOKEN);
        if (this.headerAuthToken == null) {
            this.headerAuthToken = headerAuthToken;
        }
        return this.headerAuthToken;
    }

    public void setHeaderAuthToken(String headerAuthToken) {
        this.headerAuthToken = headerAuthToken;
    }

    public String getHeaderAuthName() {
        String headerAuthName = System.getenv(HEADER_AUTH_NAME) == null ? ApplicationProperties.getValue(HEADER_AUTH_NAME)
                : System.getenv(HEADER_AUTH_NAME);
        if (this.headerAuthName == null) {
            this.headerAuthName = headerAuthName;
        }
        return this.headerAuthName;

    }

    public void setHeaderAuthName(String headerAuthName) {
        this.headerAuthName = headerAuthName;
    }

    public String getHeaderAuthType() {
        String headerAuthName = System.getenv(HEADER_AUTH_TYPE) == null ? ApplicationProperties.getValue(HEADER_AUTH_TYPE)
                : System.getenv(HEADER_AUTH_TYPE);
        if (this.headerAuthType == null) {
            this.headerAuthType = headerAuthName;
        }
        return this.headerAuthType;
    }

    public void setHeaderAuthType(String headerAuthName) {
        this.headerAuthName = headerAuthName;
    }

    public String getBasicAuthUser() {
        String basicAuthUser = System.getenv(BASIC_AUTH_USER) == null ? ApplicationProperties.getValue(BASIC_AUTH_USER)
                : System.getenv(BASIC_AUTH_USER);
        if (this.basicAuthUser == null) {
            this.basicAuthUser = basicAuthUser;
        }
        return this.basicAuthUser;
    }

    public void setBasicAuthUser(String basicAuthUser) {
        this.basicAuthUser = basicAuthUser;
    }

    public String getBasicAuthPassword() {
        String basicAuthPassword = System.getenv(BASIC_AUTH_PASSWORD) == null ? ApplicationProperties.getValue(BASIC_AUTH_PASSWORD)
                : System.getenv(BASIC_AUTH_PASSWORD);
        if (this.basicAuthPassword == null) {
            this.basicAuthPassword = basicAuthPassword;
        }
        return this.basicAuthPassword;
    }

    public void setBasicAuthPassword(String basicAuthPassword) {
        this.basicAuthPassword = basicAuthPassword;
    }

    public String getPreemptiveAuthUser() {
        String preemptiveAuthUser =
                System.getenv(PREEMPTIVE_AUTH_USER) == null ? ApplicationProperties.getValue(PREEMPTIVE_AUTH_USER)
                        : System.getenv(PREEMPTIVE_AUTH_USER);
        if (this.preemptiveAuthUser == null) {
            this.preemptiveAuthUser = preemptiveAuthUser;
        }
        return this.preemptiveAuthUser;
    }

    public void setPreemptiveAuthUser(String preemptiveAuthUser) {
        this.preemptiveAuthUser = preemptiveAuthUser;
    }

    public String getPreemptiveAuthPassword() {
        String preemptiveAuthPassword =
                System.getenv(PREEMPTIVE_AUTH_PASSWORD) == null ? ApplicationProperties.getValue(PREEMPTIVE_AUTH_PASSWORD)
                        : System.getenv(PREEMPTIVE_AUTH_PASSWORD);
        if (this.preemptiveAuthPassword == null) {
            this.preemptiveAuthPassword = preemptiveAuthPassword;
        }

        return this.preemptiveAuthPassword;
    }

    public void setPreemptiveAuthPassword(String preemptiveAuthPassword) {
        this.preemptiveAuthPassword = preemptiveAuthPassword;
    }

    public String getOAuth1Key() {
        String oAuth1Key =
                System.getenv(OAUTH1_KEY) == null ? ApplicationProperties.getValue(OAUTH1_KEY) : System.getenv(OAUTH1_KEY);
        if (this.oAuth1Key == null) {
            this.oAuth1Key = oAuth1Key;
        }

        return this.oAuth1Key;
    }

    public void setOAUTH1_KEY(String oAuth1Key) {
        this.oAuth1Key = oAuth1Key;
    }

    public String getOauth1Secret() {

        String oAuth1Secret = System.getenv(OAUTH1_SECRET) == null ? ApplicationProperties.getValue(OAUTH1_SECRET)
                : System.getenv(OAUTH1_SECRET);
        if (this.oAuth1Secret == null) {
            this.oAuth1Secret = oAuth1Secret;
        }

        return this.oAuth1Secret;
    }

    public void setOauth1Secret(String oAuth1Secret) {
        this.oAuth1Secret = oAuth1Secret;
    }

    public String getOAuth1SecretToken() {
        String oAuth1SecretToken = System.getenv(OAUTH1_SECRET_TOKEN) == null ? ApplicationProperties.getValue(OAUTH1_SECRET_TOKEN)
                : System.getenv(OAUTH1_SECRET_TOKEN);
        if (this.oAuth1SecretToken == null) {
            this.oAuth1SecretToken = oAuth1SecretToken;
        }

        return this.oAuth1SecretToken;

    }

    public void setOAuth1SecretToken(String oAuth1SecretToken) {
        this.oAuth1SecretToken = oAuth1SecretToken;
    }

    public String getOAuth1AccessToken() {
        String oAuth1AccessToken = System.getenv(OAUTH1_ACCESS_TOKEN) == null ? ApplicationProperties.getValue(OAUTH1_ACCESS_TOKEN)
                : System.getenv(OAUTH1_ACCESS_TOKEN);
        if (this.oAuth1AccessToken == null) {
            this.oAuth1AccessToken = oAuth1AccessToken;
        }

        return this.oAuth1AccessToken;
    }

    public void setOAuth1AccessToken(String oAuth1AccessToken) {
        this.oAuth1AccessToken = oAuth1AccessToken;
    }

}
