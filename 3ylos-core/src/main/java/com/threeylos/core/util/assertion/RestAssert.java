package com.threeylos.core.util.assertion;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URI;
import java.net.URL;

import static org.hamcrest.Matchers.*;

/**
 * @author AbhinitKumar
 *
 */
@Log4j2
public class RestAssert extends Assertions {

    public RestAssert() {
    }

    public void statusCode(Response response, int status) {
        response.then().statusCode(status);

    }

    public void contains(Response response, String data) {
        response.asString().contains(data);
    }

    public void contentType(Response response, ContentType contentType) {
        response.then().contentType(contentType);
    }

    public JsonPath JosnPath(Response response) {
        return response.jsonPath();
    }

    public void equalToRes(Response response, String jsonPath, Object obj) {
        response.then().body(jsonPath, equalTo(obj));
    }

    public String getResonseValue(Response response, String path) {
        return response.jsonPath().get(path);
    }

    public void notRes(Response response, String jsonPath, Object obj) {
        response.then().body(jsonPath, not(obj));
    }

    public void notNullValueRes(Response response, String jsonPath) {
        response.then().body(jsonPath, notNullValue());
    }

    public void nullValueRes(Response response, String jsonPath) {
        response.then().body(jsonPath, nullValue());
    }

    /**
     * Creates a Hamcrest matcher that validates that a JSON document conforms to the JSON schema provided to this method.
     *
     * @param schema The string defining the JSON schema
     * @return A Hamcrest matcher
     */
    public JsonSchemaValidator matchesJsonSchema(String schema) {
        return io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema(schema);
    }

    /**
     * Creates a Hamcrest matcher that validates that a JSON document conforms to the JSON schema provided to this method.
     *
     * @param pathToSchemaInClasspath The string that points to a JSON schema in classpath.
     * @return A Hamcrest matcher
     */
    public JsonSchemaValidator matchesJsonSchemaInClasspath(String pathToSchemaInClasspath) {
        return io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath(pathToSchemaInClasspath);
    }

    /**
     * Creates a Hamcrest matcher that validates that a JSON document conforms to the JSON schema provided to this method.
     *
     * @param schema The input stream that points to a JSON schema
     * @return A Hamcrest matcher
     */
    public JsonSchemaValidator matchesJsonSchema(InputStream schema) {
        return io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema(schema);
    }

    /**
     * Creates a Hamcrest matcher that validates that a JSON document conforms to the JSON schema provided to this method.
     *
     * @param schema The reader that points to a JSON schema
     * @return A Hamcrest matcher
     */
    public JsonSchemaValidator matchesJsonSchema(Reader schema) {
        return io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema(schema);
    }

    /**
     * Creates a Hamcrest matcher that validates that a JSON document conforms to the JSON schema provided to this method.
     *
     * @param file The file that points to a JSON schema
     * @return A Hamcrest matcher
     */
    public JsonSchemaValidator matchesJsonSchema(File file) {
        return io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema(file);
    }

    public JsonSchemaValidator matchesJsonSchema(URL url) {
        return io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema(url);
    }

    /**
     * Creates a Hamcrest matcher that validates that a JSON document conforms to the JSON schema loaded by the supplied URI.
     * <p>
     * Note: Converts the URI to a URL and loads this URL.
     * </p>
     *
     * @param uri The URI that points to a JSON schema
     * @return A Hamcrest matcher
     */
    public JsonSchemaValidator matchesJsonSchema(URI uri) {
        return io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema(uri);
    }

    public void matchesFaultCode(Response response,String faultCode){
        assertEquals(response.getBody().jsonPath().get("faultCode"),faultCode);
    }

}
