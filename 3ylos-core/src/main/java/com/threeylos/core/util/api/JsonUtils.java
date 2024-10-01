package com.threeylos.core.util.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.threeylos.core.util.common.FileUtil;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import com.fasterxml.jackson.core.type.TypeReference;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author AbhinitKumar
 *
 */
public final class JsonUtils {

    private JsonUtils() {

    }

    public static String getJsonPath(Response response, String key) {
        String resp = response.asString();
        JsonPath jsp = new JsonPath(resp);
        return jsp.get(key).toString();
    }

}
