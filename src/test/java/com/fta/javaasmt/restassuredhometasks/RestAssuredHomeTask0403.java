package com.fta.javaasmt.restassuredhometasks;

import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsIn.*;
import static org.hamcrest.number.OrderingComparison.greaterThan;

public class RestAssuredHomeTask0403 {

    /*@Test

    public void getEventNamesInEnglish() {
        given().
                baseUri("https://events.epam.com/api/").
        when().
                get("v2/events").

        then().
                 assertThat().
                 body("events.findAll{it.language=='En'}.title",hasItems("EPAM IT Nights presents Java Zurich","The Rolling Scopes #61.Krakow"));



    }*/
    @Test

    public void getWeatherData() {

        given().
                baseUri("http://api.openweathermap.org/data/2.5/").
         when().
                get("weather?lat=17.38&lon=78.47&appid=39ab31b13be0923b87ce7752664abeed").

         then().

                assertThat().
                body("name" ,equalTo("Hyderabad")).
                body("sys.country",equalTo("IN")).
                body("main.temp_min.toDouble()",greaterThan(0.0)).
                body("main.temp.toDouble()",greaterThan(0.0));





    }
}
