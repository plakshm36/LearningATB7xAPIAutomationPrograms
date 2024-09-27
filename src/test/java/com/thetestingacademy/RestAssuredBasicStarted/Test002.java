package com.thetestingacademy.RestAssuredBasicStarted;

import io.restassured.RestAssured;
// Gherkins Syntax
//        given() - url, headers, body or paylaod
//        when() - http methods - get, post, patch, put, delete
//        then() - verify the response - er == ar
public class Test002 {
    public static void main(String[] args) {
       RestAssured
               .given().log().all()
                 .baseUri("https://restful-booker.herokuapp.com/")
                 .basePath("/booking/628")
               .when().log().all()
                 .get()
               .then().log().all()
                .statusCode(200);
    }
}
