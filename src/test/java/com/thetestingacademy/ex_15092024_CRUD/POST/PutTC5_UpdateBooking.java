package com.thetestingacademy.ex_15092024_CRUD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.Test;


@Test
public class PutTC5_UpdateBooking {


    // 628
    // Token -  Token?
    // Payload - {
    //    "firstname" : "James",
    //    "lastname" : "Brown",
    //    "totalprice" : 90000,
    //    "depositpaid" : true,
    //    "bookingdates" : {
    //        "checkin" : "2024-10-01",
    //        "checkout" : "2025-10-01"
    //    },
    //    "additionalneeds" : "Breakfast"
    //}


    // POST - Auth - token
    // POST - Booking ID
    // PUT - token and BookingID
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;


    public void test_updatebooking() {
    String token = "65959f449e6c623";
     // String Username = "admin";
      //String Password = "password123";
        String bookingid = "741";
        String payload = "{\n" +
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
        requestSpecification= RestAssured.given().log().all();
                              requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
                              requestSpecification.basePath("/booking/"+bookingid);
                             requestSpecification.cookie("token",token);
                             //requestSpecification.auth().basic(Username,Password);
                              requestSpecification.contentType(ContentType.JSON);
                              requestSpecification.body(payload);

        response=requestSpecification.when().log().all().put();

        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

    }


}
