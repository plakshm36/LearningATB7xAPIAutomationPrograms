package com.thetestingacademy.ex_21092024.Assertions02;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class Test011_AssertionsTestNGandHamcrestandAssertJ {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    String bookingId;
    String firstname;

    //  Create a method for createToken-return the token as its needed for PUT request


    @Test
    public void createBooking() {
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

        // 1.Rest Assured Default - Hamcrest
        // import org.hamcrest.Matchers;
//        validatableResponse.body("booking.firstname",Matchers.equalTo("Pramod"));
//        validatableResponse.body("booking.lastname",Matchers.equalTo("Dutta"));
//        validatableResponse.body("booking.depositpaid",Matchers.equalTo(false));
//        validatableResponse.body("bookingid",Matchers.notNullValue());


        // 2.TestNG Assertion
        // SoftAssert vs
        // HardAssert - This means that if any assertion fails, the remaining statements in
        // that test method will not be executed.

        //Below is a way1 to extract the response results recieved and get it as string from jsonstring.

       /* bookingId = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");*/

        ////Below is a way2(jsonpath extraction) to extract the response results
        // recieved and get it as string from jsonstring.More explained on this program
        //C:\Users\padma\IdeaProjects\LearningATB7xAPIAutomationPrograms\src\test\java\com\thetestingacademy\ex_21092024\VerificationofJsonResponseUsingAssertJ04\Test013_VerificationofJsonResponseUsingJsonPath.java

       JsonPath jsonPath = new JsonPath(response.asString());
       bookingId = jsonPath.getString("bookingid");
       firstname = jsonPath.getString("booking.firstname");


//        Assert.assertNotNull(bookingId);
//        Assert.assertEquals(firstname,"Pramod");

        // 3.AssertJ Assertion

        assertThat(bookingId).isNotNull().isNotBlank().isGreaterThan("0");
        assertThat(firstname).isEqualTo("James").isNotEmpty().isNotBlank();
        String s = ""; //Empty
        String s2 = " "; //Blank


//        bookingId = response.jsonPath().getString("bookingid");


    }





}