package com.threeylos.core.api.config;

import com.threeylos.core.config.ApplicationProperties;
import com.threeylos.core.util.api.RestAssuredRequestFilter;
import io.restassured.RestAssured;
import lombok.extern.log4j.Log4j2;

/**
 * @author AbhinitKumar
 */

@Log4j2
public final class ApiConfig {

    private ApiConfig() {

    }

    private static final String ROOT_API_URL;

    static {
        String systemURL = System.getenv("API_BASE_URL");
        ROOT_API_URL = systemURL == null ? ApplicationProperties.getValue("API_BASE_URL") : systemURL;

    }

    public static void setApiConfig() {
        RestAssured.baseURI = ROOT_API_URL;
        RestAssured.filters(new RestAssuredRequestFilter());
        // RestAssured.basePath = "/api";
        // RestAssured.port=8080

    }

}
