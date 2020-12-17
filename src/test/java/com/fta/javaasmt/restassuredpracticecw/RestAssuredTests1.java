package com.fta.javaasmt.restassuredpracticecw;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class RestAssuredTests1 {

    @Test

    public void getCountry() {
        given().
                baseUri("http://api.zippopotam.us/").
                when().
                get("us/12345").

                then().
                assertThat().body("country", equalTo("United States")).
                body("'post code'", equalTo("12345")).
                body("'country abbreviation'", equalTo("US"));

    }

    @Test
    public void getplace() {
        given().
                baseUri("http://api.zippopotam.us/").
        when().
                get("us/12345").
        then().
                assertThat().body("places[0].'place name'", equalTo("Schenectady")).
                             body("places[0].longitude", equalTo("-74.058")).
                             body("places[0].state", equalTo("New York")).
                             body("places[0].'state abbreviation'", equalTo("NY")).
                             body("places[0].latitude", equalTo("42.8333"));



    }

    /*public static class RestAssuredTests2 {
        @Test

        public void swaggerTests() {
            given().
                    baseUri("https://petstore.swagger.io/v2/").
            when().
                    get("pet/12345").
             then().
                    assertThat().statusCode(200).
                    contentType("application/json").
                    body("category.name", equalTo("dog")).
                    body("name",equalTo("snoopie")).
                    body("status",equalTo("pending"));

        }
    }*/
}
