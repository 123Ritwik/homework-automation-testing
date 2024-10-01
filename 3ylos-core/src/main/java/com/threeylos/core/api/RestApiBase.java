package com.threeylos.core.api;

import com.threeylos.core.api.config.RestAssuredConfig;
import com.threeylos.core.util.assertion.RestAssert;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.Map;

import static com.threeylos.core.util.api.RestAssuredUtils.loadContext;

/**
 * Allows the http request with all parameter.
 *
 * @author AbhinitKumar
 */
@Log4j2
public abstract class RestApiBase extends RestAssert {

    private RestAssuredConfig restAssuredConfig;

    public void init(RestAssuredConfig restAssuredConfig) {
        this.restAssuredConfig = restAssuredConfig;
        log.debug("The current configuration:{}", restAssuredConfig);
    }

    public void init() {
        this.restAssuredConfig = new RestAssuredConfig();
        log.debug("Default configuration:{}", restAssuredConfig);
    }

    /**
     * Perform a GET request to a <code>url</code>. Normally the path doesn't have
     * to be fully-qualified e.g. you don't need to specify the path as
     * <tt><a href="http://localhost:8080/url">...</a></tt>. In this case it's enough to use
     * <tt>/url</tt>.
     *
     * @param url        The path to send the request to.
     * @param pathParams The path parameters.
     * @return The response of the request.
     */
    protected Response getByPathParams(final String url, final Map<String, ?> pathParams) {
        log.debug("Get request by url: {} and path params: {}", url, pathParams);
        return loadContext(restAssuredConfig).pathParams(pathParams)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .get(url)
                .thenReturn();
    }

    /**
     * Perform a GET request to a <code>url</code>. Normally the path doesn't have
     * to be fully-qualified e.g. you don't need to specify the path as
     * <tt><a href="http://localhost:8080/url">...</a></tt>. In this case it's enough to use
     * <tt>/url</tt>.
     *
     * @param url        The path to send the request to.
     * @param pathParams The path parameters.
     * @param headers    The request headers as Accept and content type
     * @return The response of the request.
     */
    protected Response getByPathParams(final String url, final Map<String, ?> pathParams, final Map<String, ?> headers) {
        log.debug("Get request by url: {} and path params: {}", url, pathParams);
        return loadContext(restAssuredConfig).pathParams(pathParams)
                .headers(headers)
                .get(url)
                .thenReturn();
    }

    /***
     * Perform simple get request with no param
     * @param  url The path to send the request to.
     * @param headers    The request headers as Accept and content type
     * @return The response of the request.
     */

    public Response getRequest(final String url, final Map<String, ?> headers) {
        log.debug("Get request by url: {} ", url);
        return loadContext(restAssuredConfig).when()
                .headers(headers)
                .get(url)
                .thenReturn();
    }

    /***
     * Perform simple get request with no param
     * @param  url The path to send the request to.
     * @return The response of the request.
     */

    public Response getRequest(final String url) {
        log.debug("Get request by url: {} ", url);
        return loadContext(restAssuredConfig).when()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .get(url)
                .thenReturn();
    }

    /**
     * Perform a GET request to a <code>url</code>. Normally the path doesn't have
     * to be fully-qualified e.g. you don't need to specify the path as
     * <tt><a href="http://localhost:8080/url">...</a></tt>. In this case it's enough to use
     * <tt>/url</tt>.
     *
     * @param url        The path to send the request to.
     * @param headers    The request headers as Accept and content type.
     * @param pathParams The path parameters. E.g. if path is
     *                   "/book/{hotelId}/{roomNumber}" you can do
     *                   <code>get("/book/{hotelName}/{roomNumber}", "Hotels R Us", 22);</code>.
     * @return The response of the request.
     */
    protected Response getByPathParams(final String url, final Map<String, ?> headers, final Object... pathParams) {
        log.debug("Get request by url: {} and object params: {}", url, pathParams);
        return loadContext(restAssuredConfig)
                .headers(headers)
                .get(url, pathParams)
                .thenReturn();
    }

    /**
     * Perform a GET request to a <code>url</code>. Normally the path doesn't have
     * to be fully-qualified e.g. you don't need to specify the path as
     * <tt><a href="http://localhost:8080/url">...</a></tt>. In this case it's enough to use
     * <tt>/url</tt>.
     *
     * @param url        The path to send the request to.
     * @param pathParams The path parameters. E.g. if path is
     *                   "/book/{hotelId}/{roomNumber}" you can do
     *                   <code>get("/book/{hotelName}/{roomNumber}", "Hotels R Us", 22);</code>.
     * @return The response of the request.
     */
    protected Response getByPathParams(final String url, final Object... pathParams) {
        log.debug("Get request by url: {} and object params: {}", url, pathParams);
        return loadContext(restAssuredConfig)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .get(url, pathParams)
                .thenReturn();
    }

    /**
     * Perform a GET request to a <code>url</code>. Normally the path doesn't have
     * to be fully-qualified e.g. you don't need to specify the path as
     * <tt><a href="http://localhost:8080/?rest=restAssured">...</a></tt>. In this case it's enough to
     * use <tt>/url</tt>.
     *
     * @param url         The path to send the request to.
     * @param headers     The request headers as Accept and content type.
     * @param queryParams The Map containing the parameter names and their values
     *                    to send with the request.
     * @return The response of the request.
     */
    protected Response getByQueryParams(final String url, Map<String, ?> queryParams, Map<String, ?> headers) {
        log.debug("Get request by url: {} and query params: {}", url, queryParams);
        return loadContext(restAssuredConfig).queryParams(queryParams)
                .headers(headers)
                .get(url)
                .thenReturn();
    }

    /**
     * Perform a GET request to a <code>url</code>. Normally the path doesn't have
     * to be fully-qualified e.g. you don't need to specify the path as
     * <tt><a href="http://localhost:8080/?rest=restAssured">...</a></tt>. In this case it's enough to
     * use <tt>/url</tt>.
     *
     * @param url         The path to send the request to.
     * @param queryParams The Map containing the parameter names and their values
     *                    to send with the request.
     * @return The response of the request.
     */
    protected Response getByQueryParams(final String url, Map<String, ?> queryParams) {
        log.debug("Get request by url: {} and query params: {}", url, queryParams);
        return loadContext(restAssuredConfig).queryParams(queryParams)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .get(url)
                .thenReturn();
    }

    /***
     * Perform Get Request using both path params and query params
     *
     * @param  url         The path to send the request to
     * @param  pathParams  The Map containing the path parameter names and their
     *                     values
     * @param  queryParams The Map containing the query parameter names and their
     *                     values
     * @return The response of the request.
     */

    protected Response getByPathQueryParams(final String url, final Map<String, ?> pathParams,
                                            final Map<String, ?> queryParams) {
        log.debug("Get request by url: {}, path params:{},  query params: {}", url, pathParams, queryParams);
        return loadContext(restAssuredConfig).pathParams(pathParams)
                .queryParams(queryParams)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .get(url)
                .thenReturn();
    }

    /***
     * Perform Get Request using both path params and query params
     *
     * @param  url         The path to send the request to
     * @param  pathParams  The Map containing the path parameter names and their
     *                     values
     * @param  queryParams The Map containing the query parameter names and their
     *                     values
     * @param headers     The request headers as Accept and content type.
     * @return The response of the request.
     */

    protected Response getByPathQueryParams(final String url, final Map<String, ?> pathParams,
                                            final Map<String, ?> queryParams, final Map<String, ?> headers) {
        log.debug("Get request by url: {}, path params:{},  query params: {}", url, pathParams, queryParams);
        return loadContext(restAssuredConfig).pathParams(pathParams)
                .queryParams(queryParams)
                .headers(headers)
                .get(url)
                .thenReturn();
    }

    /***
     * Perform Get Request using both path params and query params
     *
     * @param  url         The path to send the request to
     * @param  pathParams  The path parameters. E.g. if path is *
     *                     "/book/{hotelId}/{roomNumber}" you can do *
     *                     <code>get("/book/{hotelName}/{roomNumber}", "Hotels R Us", 22);</code>.
     * @param  queryParams The Map containing the query parameter names and their
     *                     values
     * @param headers     The request headers as Accept and content type.
     * @return The response of the request.
     */
    protected Response getByPathQueryParams(final String url, final Map<String, ?> queryParams,
                                            final Map<String, ?> headers, final Object... pathParams) {
        log.debug("Get request by url: {}, object path params:{},  object query params: {}", url, pathParams,
                queryParams);
        return loadContext(restAssuredConfig).queryParams(queryParams)
                .headers(headers)
                .get(url, pathParams)
                .thenReturn();
    }

    /***
     * Perform Get Request using both path params and query params
     *
     * @param  url         The path to send the request to
     * @param  pathParams  The path parameters. E.g. if path is *
     *                     "/book/{hotelId}/{roomNumber}" you can do *
     *                     <code>get("/book/{hotelName}/{roomNumber}", "Hotels R Us", 22);</code>.
     * @param  queryParams The Map containing the query parameter names and their
     *                     values
     * @return The response of the request.
     */
    protected Response getByPathQueryParams(final String url, final Map<String, ?> queryParams,
                                            final Object... pathParams) {
        log.debug("Get request by url: {}, object path params:{},  object query params: {}", url, pathParams,
                queryParams);
        return loadContext(restAssuredConfig).queryParams(queryParams)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .get(url, pathParams)
                .thenReturn();
    }

    /**
     * Perform a GET request to the statically configured path (by default
     * <code><a href="http://localhost:8080">...</a></code>).
     *
     * @param headers The request headers as Accept and content type.
     * @return The response of the GET request.
     */
    protected Response getRequest(final Map<String, ?> headers) {
        log.debug("Get request");
        return loadContext(restAssuredConfig).
                headers(headers)
                .get()
                .thenReturn();
    }

    /**
     * Perform a GET request to the statically configured path (by default
     * <code><a href="http://localhost:8080">...</a></code>).
     *
     * @return The response of the GET request.
     */
    protected Response getRequest() {
        log.debug("Get request");
        return loadContext(restAssuredConfig).
                contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .get()
                .thenReturn();
    }

    /**
     * Perform a POST request to the statically configured path (by default
     * <code><a href="http://localhost:8080">...</a></code>).
     *
     * @param headers The request headers as Accept and content type.
     * @return The response of the request.
     */
    protected Response post(final Map<String, ?> headers) {
        log.debug("Post request");
        return loadContext(restAssuredConfig)
                .headers(headers)
                .post();
    }

    /**
     * Perform a POST request to the statically configured path (by default
     * <code><a href="http://localhost:8080">...</a></code>).
     *
     * @return The response of the request.
     */
    protected Response post() {
        log.debug("Post request");
        return loadContext(restAssuredConfig)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .post();
    }


    /**
     * Specify a String request body (such as e.g. JSON ) that'll be sent with the
     * request. This works for the POST and PUT methods only. Trying to do this for
     * the other http methods will cause an exception to be thrown.
     * <p>
     * Example of use:
     *
     * <pre>
     * given().body("{ \"message\" : \"hello world\"}")
     *         .when()
     *         .post("/json")
     *         .then()
     *         .assertThat()
     *         .body(equalTo("hello world"));
     * </pre>
     * <p>
     * This will POST a request containing JSON to "/json" and expect that the
     * response body equals to "hello world".
     * </p>
     * <p/>
     * <p>
     *
     * @param url     The path to send the request to
     * @param body    The body to send.
     * @param headers The request headers as Accept and content type.
     * @return The request specification
     */
    protected Response postByMapBody(final String url, HashMap<String, String> body, final Map<String, ?> headers) {
        log.debug("Post request by url: {} and body: {}", url, body);
        return loadContext(restAssuredConfig).body(body)
                .headers(headers)
                .when()
                .post(url)
                .thenReturn();
    }

    /**
     * Specify a String request body (such as e.g. JSON ) that'll be sent with the
     * request. This works for the POST and PUT methods only. Trying to do this for
     * the other http methods will cause an exception to be thrown.
     * <p>
     * Example of use:
     *
     * <pre>
     * given().body("{ \"message\" : \"hello world\"}")
     *         .when()
     *         .post("/json")
     *         .then()
     *         .assertThat()
     *         .body(equalTo("hello world"));
     * </pre>
     * <p>
     * This will POST a request containing JSON to "/json" and expect that the
     * response body equals to "hello world".
     * </p>
     * <p/>
     * <p>
     *
     * @param url  : endpoint of the patch url
     * @param body The body to send.
     * @return The request specification
     */
    protected Response postByMapBody(final String url, HashMap<String, String> body) {
        log.debug("Post request by url: {} and body: {}", url, body);
        return loadContext(restAssuredConfig).body(body)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .post(url)
                .thenReturn();
    }


    /**
     * Specify a String request body (such as e.g. JSON ) that'll be sent with the
     * request. This works for the POST and PUT methods only. Trying to do this for
     * the other http methods will cause an exception to be thrown.
     * <p>
     * Example of use:
     *
     * <pre>
     * given().body("{ \"message\" : \"hello world\"}")
     *         .when()
     *         .post("/json")
     *         .then()
     *         .assertThat()
     *         .body(equalTo("hello world"));
     * </pre>
     * <p>
     * This will POST a request containing JSON to "/json" and expect that the
     * response body equals to "hello world".
     * </p>
     * <p/>
     * <p>
     *
     * @param url  : endpoint of the patch url
     * @param body The body to send.
     * @return The request specification
     */
    protected Response postByFormParam(final String url, HashMap<String, String> body,
                                       HashMap<String, String> form) {
        log.debug("Post request by url: {} and body: {}", url, body);
        return loadContext(restAssuredConfig)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(body)
                .when()
                .formParams(form)
                .post(url)
                .thenReturn();
    }


    /**
     * Specify a String request body (such as e.g. JSON ) that'll be sent with the
     * request. This works for the POST and PUT methods only. Trying to do this for
     * the other http methods will cause an exception to be thrown.
     * <p>
     * Example of use:
     *
     * <pre>
     * given().body("{ \"message\" : \"hello world\"}")
     *         .when()
     *         .post("/json")
     *         .then()
     *         .assertThat()
     *         .body(equalTo("hello world"));
     * </pre>
     * <p>
     * This will POST a request containing JSON to "/json" and expect that the
     * response body equals to "hello world".
     * </p>
     * <p/>
     * <p>
     *
     * @param url     : endpoint of the patch url
     * @param body    The body to send.
     * @param headers The request headers as Accept and content type.
     * @return The request specification
     */
    protected Response postByFormParam(final String url, HashMap<String, String> body,
                                       HashMap<String, String> form, final Map<String, ?> headers) {
        log.debug("Post request by url: {} and body: {}", url, body);
        return loadContext(restAssuredConfig)
                .headers(headers)
                .body(body)
                .when()
                .formParams(form)
                .post(url)
                .thenReturn();
    }


    /**
     * Specify a String request body (such as e.g. JSON ) that'll be sent with the
     * request. This works for the POST and PUT methods only. Trying to do this for
     * the other http methods will cause an exception to be thrown.
     * <p>
     * Example of use:
     *
     * <pre>
     * given().body("{ \"message\" : \"hello world\"}")
     *         .when()
     *         .post("/json")
     *         .then()
     *         .assertThat()
     *         .body(equalTo("hello world"));
     * </pre>
     * <p>
     * This will POST a request containing JSON to "/json" and expect that the
     * response body equals to "hello world".
     * </p>
     * <p/>
     * <p>
     *
     * @param url     : endpoint of the patch url
     * @param body    The body to send.
     * @param headers The request headers as Accept and content type.
     * @return The request specification
     */
    protected Response postByBody(String url, String body, final Map<String, ?> headers) {
        log.debug("Post request by url: {} and body: {}", url, body);
        return loadContext(restAssuredConfig)
                .headers(headers)
                .body(body)
                .when()
                .post(url)
                .thenReturn();
    }

    /**
     * Specify a String request body (such as e.g. JSON ) that'll be sent with the
     * request. This works for the POST and PUT methods only. Trying to do this for
     * the other http methods will cause an exception to be thrown.
     * <p>
     * Example of use:
     *
     * <pre>
     * given().body("{ \"message\" : \"hello world\"}")
     *         .when()
     *         .post("/json")
     *         .then()
     *         .assertThat()
     *         .body(equalTo("hello world"));
     * </pre>
     * <p>
     * This will POST a request containing JSON to "/json" and expect that the
     * response body equals to "hello world".
     * </p>
     * <p/>
     * <p>
     *
     * @param url  : endpoint of the patch url
     * @param body The body to send.
     * @return The request specification
     */
    protected Response postByBody(String url, String body) {
        log.debug("Post request by url: {} and body: {}", url, body);
        return loadContext(restAssuredConfig)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(body)
                .when()
                .post(url)
                .thenReturn();
    }


    /**
     * Specify a String request body (such as e.g. JSON ) that'll be sent with the
     * request. This works for the POST and PUT methods only. Trying to do this for
     * the other http methods will cause an exception to be thrown.
     * <p>
     * Example of use:
     *
     * <pre>
     * given().body("{ \"message\" : \"hello world\"}")
     *         .when()
     *         .post("/json")
     *         .then()
     *         .assertThat()
     *         .body(equalTo("hello world"));
     * </pre>
     * <p>
     * This will POST a request containing JSON to "/json" and expect that the
     * response body equals to "hello world".
     * </p>
     * <p/>
     * <p>
     *
     * @param url        : endpoint of the patch url
     * @param body:      payload of the request
     * @param pathParams : path parameters passed
     * @param headers    The request headers as Accept and content type.
     * @return response generated
     */
    protected Response patchByPathParams(String url, String body, Map<String, ?> pathParams, final Map<String, ?> headers) {
        log.debug("patch request by url: {} and body: {}", url, body);
        return loadContext(restAssuredConfig)
                .headers(headers)
                .body(body)
                .when()
                .pathParams(pathParams)
                .patch(url)
                .thenReturn();
    }

    /**
     * Specify a String request body (such as e.g. JSON ) that'll be sent with the
     * request. This works for the POST and PUT methods only. Trying to do this for
     * the other http methods will cause an exception to be thrown.
     * <p>
     * Example of use:
     *
     * <pre>
     * given().body("{ \"message\" : \"hello world\"}")
     *         .when()
     *         .post("/json")
     *         .then()
     *         .assertThat()
     *         .body(equalTo("hello world"));
     * </pre>
     * <p>
     * This will POST a request containing JSON to "/json" and expect that the
     * response body equals to "hello world".
     * </p>
     * <p/>
     * <p>
     *
     * @param url        : endpoint of the patch url
     * @param body:      payload of the request
     * @param pathParams : path parameters passed
     * @return response generated
     */
    protected Response patchByPathParams(String url, String body, Map<String, ?> pathParams) {
        log.debug("patch request by url: {} and body: {}", url, body);
        return loadContext(restAssuredConfig)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(body)
                .when()
                .pathParams(pathParams)
                .patch(url)
                .thenReturn();
    }

    /**
     * Specify a String request body (such as e.g. JSON ) that'll be sent with the
     * request. This works for the POST and PUT methods only. Trying to do this for
     * the other http methods will cause an exception to be thrown.
     * <p>
     * Example of use:
     *
     * <pre>
     * given().body("{ \"message\" : \"hello world\"}")
     *         .when()
     *         .post("/json")
     *         .then()
     *         .assertThat()
     *         .body(equalTo("hello world"));
     * </pre>
     * <p>
     * This will POST a request containing JSON to "/json" and expect that the
     * response body equals to "hello world".
     * </p>
     * <p/>
     * <p>
     *
     * @param url        : endpoint of the patch url
     * @param body:      payload of the request
     * @param headers    The request headers as Accept and content type.
     * @param pathParams : path parameters passed
     * @return response generated
     */
    protected Response patchByPathParams(String url, String body, final Map<String, ?> headers, Object... pathParams) {
        log.debug("patch request by url: {} and body: {}", url, body);
        return loadContext(restAssuredConfig)
                .headers(headers)
                .body(body)
                .when()
                .patch(url, pathParams)
                .thenReturn();
    }


    /**
     * Specify a String request body (such as e.g. JSON ) that'll be sent with the
     * request. This works for the POST and PUT methods only. Trying to do this for
     * the other http methods will cause an exception to be thrown.
     * <p>
     * Example of use:
     *
     * <pre>
     * given().body("{ \"message\" : \"hello world\"}")
     *         .when()
     *         .post("/json")
     *         .then()
     *         .assertThat()
     *         .body(equalTo("hello world"));
     * </pre>
     * <p>
     * This will POST a request containing JSON to "/json" and expect that the
     * response body equals to "hello world".
     * </p>
     * <p/>
     * <p>
     *
     * @param url        : endpoint of the patch url
     * @param body:      payload of the request
     * @param pathParams : path parameters passed
     * @return response generated
     */
    protected Response patchByPathParams(String url, String body, Object... pathParams) {
        log.debug("patch request by url: {} and body: {}", url, body);
        return loadContext(restAssuredConfig)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(body)
                .when()
                .patch(url, pathParams)
                .thenReturn();
    }

    /**
     * Specify a String request body (such as e.g. JSON ) that'll be sent with the
     * request. This works for the POST and PUT methods only. Trying to do this for
     * the other http methods will cause an exception to be thrown.
     * <p>
     * Example of use:
     *
     * <pre>
     * given().body("{ \"message\" : \"hello world\"}")
     *         .when()
     *         .post("/json")
     *         .then()
     *         .assertThat()
     *         .body(equalTo("hello world"));
     * </pre>
     * <p>
     * This will POST a request containing JSON to "/json" and expect that the
     * response body equals to "hello world".
     * </p>
     * <p/>
     * <p>
     *
     * @param url        : endpoint of the patch url
     * @param body:      payload of the request
     * @param headers    The request headers as Accept and content type.
     * @param pathParams : path parameters passed
     * @return response generated
     */
    protected Response patchByPathQueryParams(String url, Map<String, ?> pathParams, final Map<String, ?> headers, Map<String, ?> queryParams,
                                              String body) {
        log.debug("patch request by url: {} and body: {}", url, body);
        return loadContext(restAssuredConfig)
                .headers(headers)
                .body(body)
                .when()
                .params(queryParams)
                .patch(url, pathParams)
                .thenReturn();
    }

    /**
     * Specify a String request body (such as e.g. JSON ) that'll be sent with the
     * request. This works for the POST and PUT methods only. Trying to do this for
     * the other http methods will cause an exception to be thrown.
     * <p>
     * Example of use:
     *
     * <pre>
     * given().body("{ \"message\" : \"hello world\"}")
     *         .when()
     *         .post("/json")
     *         .then()
     *         .assertThat()
     *         .body(equalTo("hello world"));
     * </pre>
     * <p>
     * This will POST a request containing JSON to "/json" and expect that the
     * response body equals to "hello world".
     * </p>
     * <p/>
     * <p>
     *
     * @param url        : endpoint of the patch url
     * @param body:      payload of the request
     * @param headers    The request headers as Accept and content type.
     * @param pathParams : path parameters passed
     * @return response generated
     */
    protected Response putByBody(String url, String body, Map<String, ?> pathParams, final Map<String, ?> headers) {
        log.debug("put request by url: {} and body: {}", url, body);
        return loadContext(restAssuredConfig)
                .headers(headers)
                .body(body)
                .when()
                .pathParams(pathParams)
                .put(url)
                .thenReturn();
    }

    /**
     * Specify a String request body (such as e.g. JSON ) that'll be sent with the
     * request. This works for the POST and PUT methods only. Trying to do this for
     * the other http methods will cause an exception to be thrown.
     * <p>
     * Example of use:
     *
     * <pre>
     * given().body("{ \"message\" : \"hello world\"}")
     *         .when()
     *         .post("/json")
     *         .then()
     *         .assertThat()
     *         .body(equalTo("hello world"));
     * </pre>
     * <p>
     * This will POST a request containing JSON to "/json" and expect that the
     * response body equals to "hello world".
     * </p>
     * <p/>
     * <p>
     *
     * @param url        : endpoint of the patch url
     * @param body:      payload of the request
     * @param pathParams : path parameters passed
     * @return response generated
     */
    protected Response putByBody(String url, String body, Map<String, ?> pathParams) {
        log.debug("put request by url: {} and body: {}", url, body);
        return loadContext(restAssuredConfig)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(body)
                .when()
                .pathParams(pathParams)
                .put(url)
                .thenReturn();
    }

    /**
     * Specify a String request body (such as e.g. JSON ) that'll be sent with the
     * request. This works for the POST and PUT methods only. Trying to do this for
     * the other http methods will cause an exception to be thrown.
     * <p>
     * Example of use:
     *
     * <pre>
     * given().body("{ \"message\" : \"hello world\"}")
     *         .when()
     *         .post("/json")
     *         .then()
     *         .assertThat()
     *         .body(equalTo("hello world"));
     * </pre>
     * <p>
     * This will POST a request containing JSON to "/json" and expect that the
     * response body equals to "hello world".
     * </p>
     * <p/>
     * <p>
     *
     * @param url        : endpoint of the patch url
     * @param body:      payload of the request
     * @param headers    The request headers as Accept and content type.
     * @param pathParams : path parameters passed
     * @return response generated
     */
    protected Response putByBody(String url, String body, final Map<String, ?> headers, Object... pathParams) {
        log.debug("put request by url: {} and body: {}", url, body);
        return loadContext(restAssuredConfig)
                .headers(headers)
                .body(body)
                .when()
                .put(url, pathParams)
                .thenReturn();
    }


    /**
     * Specify a String request body (such as e.g. JSON ) that'll be sent with the
     * request. This works for the POST and PUT methods only. Trying to do this for
     * the other http methods will cause an exception to be thrown.
     * <p>
     * Example of use:
     *
     * <pre>
     * given().body("{ \"message\" : \"hello world\"}")
     *         .when()
     *         .post("/json")
     *         .then()
     *         .assertThat()
     *         .body(equalTo("hello world"));
     * </pre>
     * <p>
     * This will POST a request containing JSON to "/json" and expect that the
     * response body equals to "hello world".
     * </p>
     * <p/>
     * <p>
     *
     * @param url        : endpoint of the patch url
     * @param body:      payload of the request
     * @param pathParams : path parameters passed
     * @return response generated
     */
    protected Response putByBody(String url, String body, Object... pathParams) {
        log.debug("put request by url: {} and body: {}", url, body);
        return loadContext(restAssuredConfig)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(body)
                .when()
                .put(url, pathParams)
                .thenReturn();
    }

    /***
     * Delete Request methods
     *
     * @param  url    endpoint of the put url
     * @param  params path parameters passed
     * @param headers    The request headers as Accept and content type.
     * @return response generated
     */
    protected Response deleteByParams(String url, Map<String, String> params, final Map<String, ?> headers) {
        log.debug("Delete request by url: {} and path params: {}", url, params);
        return loadContext(restAssuredConfig)
                .params(params)
                .delete(url, params)
                .thenReturn();
    }

    /***
     * Delete Request methods
     *
     * @param  url    endpoint of the put url
     * @param  params path parameters passed
     * @return response generated
     */
    protected Response deleteByParams(String url, Map<String, String> params) {
        log.debug("Delete request by url: {} and path params: {}", url, params);
        return loadContext(restAssuredConfig)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .delete(url, params)
                .thenReturn();
    }

    /***
     * Delete Request methods
     *
     * @param  url    endpoint of the put url
     * @param headers The request headers as Accept and content type.
     * @param  params path parameters passed
     * @return response generated
     */
    protected Response deleteByParams(String url, final Map<String, ?> headers, Object... params) {
        log.debug("Delete request by url: {} and path params: {}", url, params);
        return loadContext(restAssuredConfig)
                .headers(headers)
                .delete(url, params)
                .thenReturn();
    }

    /***
     * Delete Request methods
     *
     * @param  url    endpoint of the put url
     * @param  params path parameters passed
     * @return response generated
     */
    protected Response deleteByParams(String url, Object... params) {
        log.debug("Delete request by url: {} and path params: {}", url, params);
        return loadContext(restAssuredConfig)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .delete(url, params)
                .thenReturn();
    }

    /***
     * Delete Request methods
     *
     * @param url     endpoint of the put url
     * @param headers The request headers as Accept and content type.
     * @param params  path parameters passed
     * @return response generated
     */
    protected Response deleteByQueryParams(String url, Map<String, String> params, final Map<String, ?> headers) {
        log.debug("Delete request by url: {} and path params: {}", url, params);
        return loadContext(restAssuredConfig)
                .headers(params)
                .params(params)
                .delete(url)
                .thenReturn();
    }

    /***
     * Delete Request methods
     *
     * @param url     endpoint of the put url
     * @param params  path parameters passed
     * @return response generated
     */
    protected Response deleteByQueryParams(String url, Map<String, String> params) {
        log.debug("Delete request by url: {} and path params: {}", url, params);
        return loadContext(restAssuredConfig)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .params(params)
                .delete(url)
                .thenReturn();
    }

    /***
     * Delete Request methods
     *
     * @param url     endpoint of the put url
     * @param params  path parameters passed
     * @return response generated
     */
    protected Response deleteByQueryParams(String url, Object... params) {
        log.debug("Delete request by url: {} and path params: {}", url, params);
        return loadContext(restAssuredConfig)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParam(String.valueOf(params))
                .delete(url, params)
                .thenReturn();
    }

    /***
     * Delete Request methods
     *
     * @param url     endpoint of the put url
     * @param headers The request headers as Accept and content type.
     * @param params  path parameters passed
     * @return response generated
     */
    protected Response deleteByQueryParams(String url, final Map<String, ?> headers, Object... params) {
        log.debug("Delete request by url: {} and path params: {}", url, params);
        return loadContext(restAssuredConfig)
                .headers(headers)
                .queryParam(String.valueOf(params))
                .delete(url, params)
                .thenReturn();
    }

    /***
     * Delete Request methods
     *
     * @param url     endpoint of the put url
     * @param headers The request headers as Accept and content type.
     * @param body  path parameters passed
     * @return response generated
     */
    protected Response deleteByBody(String url, final Map<String, ?> headers, String body) {
        log.debug("Delete request by url: {} and path body: {}", url, body);
        return loadContext(restAssuredConfig)
                .headers(headers)
                .body(body)
                .delete(url)
                .thenReturn();
    }


}

