package com.thetestingacademy.ex_22092024;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PayloadasStrings {

        public static void main(String[] args) {

//Here Payload is passed as string
            String payload  = "{\n" +
                    "                    \"username\" : \"admin\",\n" +
                    "                    \"password\" : \"password123\"\n" +
                    "                }";

            RestAssured.given().baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/auth")
                    .contentType(ContentType.JSON).log()
                    .all().body(payload).when()
                    .post().then().log()
                    .all().statusCode(200);




        }

    }
