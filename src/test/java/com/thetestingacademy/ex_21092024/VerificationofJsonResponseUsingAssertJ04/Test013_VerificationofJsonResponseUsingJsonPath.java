package com.thetestingacademy.ex_21092024.VerificationofJsonResponseUsingAssertJ04;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class Test013_VerificationofJsonResponseUsingJsonPath {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String bookingId;
    String firstname;
    String checkout;

    // Note :Here we are verifying the response recieved for create booking by using jsonpath.Note this way will help
    //only if 500 trst cases are there if more pojoclasses-gson method will come into picture.refer sept22 programs.


    @Test
    public void createBooking() {
        //  POST - Create -> Verify the Response
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
        System.out.println(response.asString());
        //Below is a way1 to extract the response results recieved and get it as string from jsonstring.

       /* bookingId = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");*/

        ////Below is a way2(jsonpath extraction) to extract the response results
        // recieved and get it as string from jsonstring.

        JsonPath jsonPath = new JsonPath(response.asString());
        bookingId  = jsonPath.getString("bookingid");
        firstname  = jsonPath.getString("booking.firstname");
        checkout  = jsonPath.getString("booking.bookingdates.checkout");
        System.out.println(bookingId);
        System.out.println(firstname);
        System.out.println(checkout);

        // 3.Verify the extracted data using AssertJ Assertion
        assertThat(bookingId).isNotNull().isNotBlank().isGreaterThan("0");
        assertThat(firstname).isNotNull().isNotBlank().isEqualTo("Pramod");
        assertThat(checkout).isNotNull().isNotBlank();




    }





}
