package com.fta.javaasmt.apisampletest;

import com.fta.javaasmt.domain.Category;
import com.fta.javaasmt.domain.Pet;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PetTests {

    Category category = new Category(1, "dog");
    Pet pet = new Pet(345, category, "Jacky", "pending");

    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "/v2";

        RestAssured.requestSpecification = new RequestSpecBuilder().
                setContentType("application/json").build();
    }

    @Test(priority = 2)
    public void testCaseGet(){
        given().
                body(pet).
                when().
        get("/pet/345").
                then().
                assertThat().statusCode(200);
    }

    @Test
    public void testCaseDelete(){
        delete("/pet/345").
                then().
                assertThat().statusCode(200);
    }

    @Test(priority = 1)
    public void testCasePost(){


        given().
                body(pet).
                when().
                post("/pet").
                then().
                assertThat().statusCode(200);
    }

    @Test(priority = 1)
    public void testCasePut(){

        Category category = new Category(1, "dog");
        Pet pet = new Pet(345, category, "Jacky", "available");

        given().
                body(pet).
                when().
                put("/pet").
                then().
                assertThat().statusCode(200);
    }


}
