package com.thetestingacademy.ex_15092024_CRUD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PostTC3_CreateBooking {

    // POST Request
    // URL - https://restful-booker.herokuapp.com/booking
    // BODY - PAYLOAD - JSON
    // {
    //
    //    \"firstname\" : \"Papri\",
    //    \"lastname\" : \"Lak\",
    //    \"totalprice\" :10000,
    //    \"depositpaid\" : true,
    //    \"bookingdates\" : {
    //        \"checkin\" : \"2024-09-05\",
    //        \"checkout\" : \"2024-09-05\"
    //    },
    //    \"additionalneeds\" : \"Breakfast\"
    //
    //}
    // HEADER - Content Type -> application/json
    @Test
    public void test_createBooking(){

        RequestSpecification requestSpecification;
        Response response;
        ValidatableResponse validatableResponse;

        String payload =
                "{\n" +
                        "    \"firstname\" : \"Padma\",\n" +
                        "    \"lastname\" : \"Priya\",\n" +
                        "    \"totalprice\" : 50000,\n" +
                        "    \"depositpaid\" : false,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2024-01-01\",\n" +
                        "        \"checkout\" : \"2024-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Lunch\"\n" +
                        "}";
        requestSpecification = RestAssured.given().log().all();
                               requestSpecification.relaxedHTTPSValidation();
                               requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
                               requestSpecification.basePath("booking");
                               requestSpecification.contentType(ContentType.JSON);
                               requestSpecification.body(payload);
         response = requestSpecification.when().post();

         validatableResponse = response.then().log().all();
                               validatableResponse.statusCode(200);







    }
}
