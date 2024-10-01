package com.threeylos.test.homework.api.homework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.threeylos.core.api.RestApiBase;
import com.threeylos.core.util.api.RestAssuredUtils;
import com.threeylos.homework.constant.APIConstant;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import com.threeylos.api.model.HomeworkModel;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Log4j2
public class HomeWorkApiStepDef extends RestApiBase {
    public final Map<String, Object> session;
    public final ObjectMapper objectMapper;
    public static final String REQ_BASE_PATH = "src/main/resources/data/homework/";
    public static final String SCHEMAS_BASE_PATH = "schemas/homework/schemaHomework.json";

    public HomeWorkApiStepDef() {
        this.session = new HashMap<>();
        this.objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

    }

    @Given("Request to homework {string}")
    public void requestToHomework(String endpoint, DataTable dataTable) {
        Map<String, String> headers = RestAssuredUtils.getHeaders(dataTable);
        session.put(APIConstant.ENDPOINT, endpoint);
        session.put(APIConstant.HEADERS, headers);
        RestAssuredUtils.logEndpointWithHeaders(endpoint, headers);
    }

    @When("Creates a new homework {string}")
    public void createsANewHomework(String filePath, DataTable dataTable) throws Exception {
        Map<String, String> bookingData = dataTable.asMaps().get(0);
        log.info("Request data: {} and filePath: {}", bookingData, filePath);
        String fullPath = REQ_BASE_PATH + filePath;
        HomeworkModel homeworkModel = objectMapper.readValue(RestAssuredUtils.readFileAsString(fullPath), HomeworkModel.class);
        homeworkModel.setAssignedBy(UUID.fromString(""));
        String requestBody = objectMapper.writeValueAsString(homeworkModel);
        String endpoint = RestAssuredUtils.castEndpoint(session, APIConstant.ENDPOINT);
        HashMap<String, String> headers = RestAssuredUtils.castHeaders(session, APIConstant.HEADERS);
        Response response = postByBody(endpoint, requestBody, headers);
        response.prettyPrint();
        session.put(APIConstant.RESPONSE, response);
    }



    @When("pass a valid filter parameters")
    public void passAValidFilterParameters(DataTable dataTable) {
        Map<String, String> bookingData = dataTable.asMaps().get(0);
        String endpoint = RestAssuredUtils.castEndpoint(session, APIConstant.ENDPOINT);
        HashMap<String, String> headers = RestAssuredUtils.castHeaders(session, APIConstant.HEADERS);
        Response response = getByQueryParams(endpoint, bookingData);
        session.put(APIConstant.RESPONSE, response);
    }

    @When("update a valid filter parameters {string}")
    public void updateAValidFilterParameters(DataTable dataTable) throws Exception {
        Map<String, String> homeworkId = dataTable.asMaps().get(0);
        String endpoint = RestAssuredUtils.castEndpoint(session, APIConstant.ENDPOINT);
        HashMap<String, String> headers = RestAssuredUtils.castHeaders(session, APIConstant.HEADERS);
        Response response = getByPathParams(endpoint, homeworkId);
        response.prettyPrint();
        session.put(APIConstant.RESPONSE, response);
    }

    @When("pass a valid filter homework id {string}")
    public void passAValidFilterHomeworkId(DataTable dataTable) throws Exception{
        String endpoint = RestAssuredUtils.castEndpoint(session, APIConstant.ENDPOINT);
        Map<String, String> bookingData = dataTable.asMaps().get(0);
        HashMap<String, String> headers = RestAssuredUtils.castHeaders(session, APIConstant.HEADERS);
        Response response = getByPathParams(endpoint, bookingData);
        session.put(APIConstant.RESPONSE, response);
    }

    @When("Delete parameter in homework id {string}")
    public void deleteParameterInHomeworkId(DataTable dataTable) throws Exception {
        Map<String, String> homeworkId = dataTable.asMaps().get(0);
        String endpoint = RestAssuredUtils.castEndpoint(session, APIConstant.ENDPOINT);
        HashMap<String, String> headers = RestAssuredUtils.castHeaders(session, APIConstant.HEADERS);
        Response response = deleteByParams(endpoint, homeworkId);
        session.put(APIConstant.RESPONSE, response);
    }


    @Then("Validates the response code {int}")
    public void validatesResponse(int code) {
        Response response = RestAssuredUtils.castResponse(session, APIConstant.RESPONSE);
        statusCode(response, code);
    }

    @And("Validates the response with JSON schema {string}")
    public void validatesJSONSchema(String schemaPath) {
        matchesJsonSchemaInClasspath(SCHEMAS_BASE_PATH+schemaPath);

    }

}


