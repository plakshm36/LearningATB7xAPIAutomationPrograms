package com.thetestingacademy.ex_15092024_CRUD.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class GetNonBDDStyle {
    static RequestSpecification r = RestAssured.given();

    public static void main(String[] args) {
        r.relaxedHTTPSValidation();
        r.baseUri("https://api.zippopotam.us");
        testnon_bdd_1();
        testnon_bdd_2();
        }

    private static void testnon_bdd_1(){

                r.basePath("/IN/560037")
                .when().log().all()
                   .get()
                .then().log().all()
                   .statusCode(200);
    }

    private static void testnon_bdd_2() {
        r.basePath("/IN/-1");
        r.when()
                .get();
        r.then().log().all()
                .statusCode(404);
    }


}

