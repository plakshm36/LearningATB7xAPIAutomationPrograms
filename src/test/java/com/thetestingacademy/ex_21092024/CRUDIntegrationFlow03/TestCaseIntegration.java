package com.thetestingacademy.ex_21092024.CRUDIntegrationFlow03;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TestCaseIntegration {
//  Create a Token-return the token as its needed for PUT request
// Create a Booking-return the booking id as its needed for PUT request
//  Perform  a PUT request - pass the token and booking to do an update
//  Verify that PUT is success by GET Request
// Delete the ID
// Verify it doesn't exist GET Request

  /*  Note:If you run this test case everytime it will run after delete test case first ie it wont follow the order.To overcom that we have
    multiple way to fix below are few mentioned.System

    1.We can set priority to run the cases in order.
    2.Else add dependsonMethods in all @test
    3.Else we can rename the testcase name ie method as test01,test02 so that it will maintain order
    4 .Else you can pass in testng xml file one by one in methods section
     */

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    String token;
    String bookingId;

    //  Create a method for createToken-return the token as its needed for PUT request

    public String getToken() {
        String payload = "{\n" +
                "                    \"username\" : \"admin\",\n" +
                "                    \"password\" : \"password123\"\n" +
                "                }";

        // Given - Request Spec
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
        requestSpecification.contentType(ContentType.JSON).log().all();
        requestSpecification.body(payload);

        // When -     Response
        response = requestSpecification.when().log().all().post();

        // Then - ValidatableResponse
        // Validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // Extract the token
        token = response.jsonPath().getString("token");
        System.out.println(token);
        return token;


    }

//Method for createBooking
    public String createBooking() {
        String Payload_Post = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 90000,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-10-01\",\n" +
                "        \"checkout\" : \"2024-10-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(Payload_Post).log().all();

        // When -     Response
        response = requestSpecification.when().log().all().post();


        // Then - ValidatableResponse
        // Validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        //Extract the bookingID.Extracting more explained here in this program
        //
        bookingId = response.jsonPath().getString("bookingid");
        System.out.println(bookingId);
        return bookingId;
}

    //Perform  a PUT request - pass the token and booking to do an update
    @Test
    public void test_update_request_put() {

        token = getToken();
        bookingId= createBooking();

        String payloadPUT= "{\n" +
                "    \"firstname\" : \"Anshul\",\n" +
                "    \"lastname\" : \"Ji\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking/"+bookingId);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(payloadPUT).log().all();

        Response response = requestSpecification.when().put();


        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
    }

//below are dummy code how to write a testcaseflow(booking,update,delete) in one code was shown
    @Test(dependsOnMethods = "test_update_request_put")
    public void test_update_request_get() {
        System.out.println(bookingId);
    }

    @Test(dependsOnMethods = "test_update_request_get")
    public void test_delete_booking() {
        System.out.println(bookingId);
        System.out.println(token);

    }


    @Test(dependsOnMethods = "test_delete_booking")
    public void test_after_delete_request_get() {
        System.out.println(bookingId);
    }














}
