package com.thetestingacademy.ex_22092024.PayloadasPojoClasses;

import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GsonSerializationDeserialization {
    RequestSpecification requestSpecification = RestAssured .given();
    Response response;
    ValidatableResponse validatableResponse;

    @Description("TC#1 - Verify that create booking is working with valid payload")
    @Test
    public void testNonBDDStylePOSTPositive() {

        //object created for Booking class to access all request need to be sent
        Booking booking = new Booking();
        booking.setFirstname("James");
        booking.setLastname("Brown");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);


        //object created for BookingDates class to access all request need to be sent
        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");

        //passed the above bookingdates requestdata to Bookingdates present in booking class
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);
        // Java Object -> JSON String (byteStream) - Serlization
        Gson gson = new Gson();
        String jsonStringpayload = gson.toJson(booking);
        System.out.println("The gdon to json string is"+jsonStringpayload);


        String BASE_URL = "https://restful-booker.herokuapp.com";
        String BASE_PATH = "/booking";

        requestSpecification.baseUri(BASE_URL);
        requestSpecification.basePath(BASE_PATH);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonStringpayload);

        response = requestSpecification.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);


        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // Parse - DeSerilization
        BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
        System.out.println(bookingResponse.getBookingid());
        System.out.println();

        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("James").isNotEmpty().isNotNull();






    }
}
