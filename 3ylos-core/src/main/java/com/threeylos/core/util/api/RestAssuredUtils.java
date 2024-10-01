package com.threeylos.core.util.api;

import com.threeylos.core.api.config.RestAssuredConfig;
import com.threeylos.core.api.config.RestAssuredContext;
import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.log4j.Log4j2;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;


/**
 * @author AbhinitKumar
 */
@Log4j2
public final class RestAssuredUtils {

    private RestAssuredUtils() {
    }

    /**
     * Load and Build RequestSpecBuilder using RestAssuredConfig
     *
     * @param restAssuredConfig {@link RestAssuredConfig} the current rest-assured
     *                          request configuration.
     * @return {@link RequestSpecification} The assembled request
     * specification.
     */
    public static RequestSpecification loadContext(RestAssuredConfig restAssuredConfig) {
        log.debug("Rest-Assured configuration: {}", restAssuredConfig);
        return new RestAssuredContext(restAssuredConfig).build();

    }

    public static Map<String, String> getHeaders(DataTable dataTable) {
        Map<String, String> headers = new HashMap<>(dataTable.asMap(String.class, String.class));
        headers.remove("headersKey");
        return headers;
    }

    public static void logEndpointWithHeaders(String endpoint, Map<String, String> headers) {
        log.debug("Request endpoint: {}", endpoint);
        log.debug("Request headers: {}", headers);
    }

    @SuppressWarnings("unchecked")
    public static HashMap<String, String> castHeaders(Map<String, Object> session, String key) {
        return (HashMap<String, String>) session.get(key);
    }

    public static String castEndpoint(Map<String, Object> session, String key) {
        return (String) session.get(key);
    }

    public static Response castResponse(Map<String, Object> session, String key) {
        return (Response) session.get(key);
    }

    public static String readFileAsString(String fileName) throws Exception {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }


}
