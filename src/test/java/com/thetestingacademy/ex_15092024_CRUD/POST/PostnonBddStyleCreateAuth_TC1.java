package com.thetestingacademy.ex_15092024_CRUD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PostnonBddStyleCreateAuth_TC1 {
    // POST Request
    // URL - https://restful-booker.herokuapp.com/auth
    // BODY - PAYLOAD - JSON
    // {
    //    "username" : "admin",
    //    "password" : "password123"
    //}
    // HEADER - Content Type -> application/json
    @Test
    public void test_post() {

        //  Payload  - String(1%), Hashmap(4%), Classes( 95%)
        String payload = "{\n" +
                "                    \"username\" : \"admin\",\n" +
                "                    \"password\" : \"password123\"\n" +
                "                }";
        // Given - Request Spec
        RequestSpecification request = RestAssured.given();
                request.baseUri("https://restful-booker.herokuapp.com");
                request.basePath("/auth");
                request.contentType(ContentType.JSON).log().all();
                request.body(payload);

        // when - Response
        Response response = request.when().log().all().post();

        // Then - ValidatableResponse
        // Validation
        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
    }
}
