package com.threeylos.core.api.config;

import com.threeylos.core.api.model.OAuth2Credentials;
import com.threeylos.core.constant.AuthType;
import com.threeylos.core.util.common.StringUtil;
import io.restassured.RestAssured;
import io.restassured.authentication.OAuthSignature;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.HttpClientConfig;
import io.restassured.specification.RequestSpecification;
import lombok.extern.log4j.Log4j2;

import static com.threeylos.core.api.config.ApiConfig.setApiConfig;

/**
 * Load and Build rest-assured configuration.
 *
 * @author AbhinitKumar
 */
@Log4j2
public class RestAssuredContext {

    private static final String CONNECTION_MANAGER_TIMEOUT = "CONNECTION_MANAGER_TIMEOUT";
    private final RestAssuredConfig restAssuredConfig;

    public RestAssuredContext(RestAssuredConfig restAssuredConfig) {
        this.restAssuredConfig = restAssuredConfig;
    }

    /**
     * Load and Build RequestSpecBuilder using RestAssuredConfig
     *
     * @return {@link RequestSpecification} The assembled request specification.
     */
    public RequestSpecification build() {
        setApiConfig();
        RestAssured.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam(CONNECTION_MANAGER_TIMEOUT, restAssuredConfig.getConnectionTimeout()));
        log.debug("Http-Request time-out: {}", restAssuredConfig.getConnectionTimeout());

        final RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        final RequestSpecification requestSpecification = RestAssured.given();
        auth(requestSpecification, requestSpecBuilder);

        return requestSpecification;
    }

    /**
     * Specify authentication type when performing a rest-assured request.
     *
     * @param requestSpecification Allows to specify how the request will look like.
     * @param requestSpecBuilder   Builder to construct a request specification.
     */
    private void auth(RequestSpecification requestSpecification, RequestSpecBuilder requestSpecBuilder) {

        if (restAssuredConfig.isAuth()) {

            String authType = restAssuredConfig.getAuthType();
            if (authType != null && !StringUtil.isEmpty(authType)) {
                ApiAuthContext apiAuthUtil = new ApiAuthContext(requestSpecification, requestSpecBuilder);

                switch (authType) {
                    case AuthType.HEADER_AUTH -> {
                        apiAuthUtil.headerAuth(restAssuredConfig.getHeaderAuthName(), restAssuredConfig.getHeaderAuthType(),
                                restAssuredConfig.getHeaderAuthToken());
                        log.trace("Header auth by headerName: {} and headerValue: {}",
                                restAssuredConfig.getHeaderAuthType(), restAssuredConfig.getHeaderAuthToken());
                    }
                    case AuthType.BASIC_AUTH -> {
                        apiAuthUtil.basicAuth(restAssuredConfig.getBasicAuthUser(),
                                restAssuredConfig.getBasicAuthPassword());
                        log.trace("Base auth by userName: {} and password: {}", restAssuredConfig.getBasicAuthUser(),
                                restAssuredConfig.getBasicAuthPassword());
                    }
                    case AuthType.PREEMPTIVE_AUTH -> {
                        apiAuthUtil.preemptiveAuth(restAssuredConfig.getPreemptiveAuthUser(),
                                restAssuredConfig.getPreemptiveAuthUser());
                        log.trace("Preemptive auth by userName: {} and password: {}",
                                restAssuredConfig.getPreemptiveAuthUser(), restAssuredConfig.getPreemptiveAuthPassword());
                    }
                    case AuthType.OAUTH1 -> {
                        apiAuthUtil.oAuth1(restAssuredConfig.getOAuth1Key(), restAssuredConfig.getOauth1Secret(),
                                restAssuredConfig.getOAuth1AccessToken(), restAssuredConfig.getOAuth1SecretToken(),
                                OAuthSignature.HEADER);
                        log.trace("OAuth1 key: {} secret:{} accessToken:{} secretToken:{} and oAuthSignature:{}",
                                restAssuredConfig.getOAuth1Key(), restAssuredConfig.getOauth1Secret(),
                                restAssuredConfig.getOAuth1AccessToken(), restAssuredConfig.getOAuth1SecretToken(),
                                OAuthSignature.HEADER);
                    }
                    case AuthType.OAUTH2 -> {
                        OAuth2 auth = new OAuth2(new OAuth2Credentials(), true);
                        apiAuthUtil.oAuth2(auth.getToken());
                    }
                    default -> log.info("Authentication is skipping due authType: {} is not supporting", authType);
                }
            }

        } else {
            log.warn("Authentication is skipping due to auth flag is false");
        }
    }

}
