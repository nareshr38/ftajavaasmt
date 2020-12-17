package com.fta.javaasmt.restassuredpracticecw;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.OrderingComparison.greaterThan;

public class RestAssuredTests2 {
    @Test
    public void getStatusCode() {
       given().
                baseUri("https://jsonplaceholder.typicode.com/").
        when().
                get("users").
        then().
                assertThat().statusCode(200).
                body("size()",greaterThan(3)).
                body("name.any{'Ervin Howell'}",is(true));



    }
}
