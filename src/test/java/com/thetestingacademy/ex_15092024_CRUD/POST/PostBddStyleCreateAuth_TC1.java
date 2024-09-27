package com.thetestingacademy.ex_15092024_CRUD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class PostBddStyleCreateAuth_TC1 {
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
        RestAssured
                .given().log().all()
                  .baseUri("https://restful-booker.herokuapp.com/")
                  .basePath("/auth")
                  .contentType(ContentType.JSON).log().all()
                  .body(payload)
                .when().log().all()
                  .post()
                .then().log().all()
                  .statusCode(200);
    }
}
