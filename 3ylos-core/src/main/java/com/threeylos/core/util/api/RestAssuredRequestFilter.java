package com.threeylos.core.util.api;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import lombok.extern.log4j.Log4j2;

/**
 * @author AbhinitKumar
 */
@Log4j2
public class RestAssuredRequestFilter implements Filter {
    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
        Response response = ctx.next(requestSpec, responseSpec);
        System.out.println();
        System.out.println("Request details -------------------------------------------------------------");
        System.out.println(
                "Request Method     => " + requestSpec.getMethod() +
                        "\nRequest URI        => " + requestSpec.getURI() +
                        "\nRequest Headers:\n" + requestSpec.getHeaders() +
                        "\nRequest Body:\n " + requestSpec.getBody() +
                        "\n\nResponse details -------------------------------------------------------------" +
                        "\nResponse Status    => " + response.getStatusLine() +
                        "\nResponse Header:\n" + response.getHeaders() +
                        "\nResponse Body:\n" + response.getBody().asString());
        return response;
    }
}
