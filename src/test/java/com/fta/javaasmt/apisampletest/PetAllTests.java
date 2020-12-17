package com.fta.javaasmt.apisampletest;

import com.fta.javaasmt.domain.Category;
import com.fta.javaasmt.domain.Pet;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PetAllTests {
    private static Category category = new Category(1, "dog");
    private static Pet pet = new Pet(345, category, "Jacky", "pending");


    private static RequestSpecification request;

    private static ResponseSpecification response;

    @BeforeTest
    public void setReqAndResSpecification() {

    /*    Response allPetDetails = given()
                .when()
                .get("/pet");*/


        request = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io")
                .setBasePath("/v2")
                .setContentType(ContentType.JSON)
                .build();

        response = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(200)
                .build();
    }


    @Test
    public void addNewPet() {
        int petsId = given()
                .spec(request)
                .body(pet)
                .when()
                .post("/pet")
                .then()
                .spec(response)
                .assertThat()
                .statusCode(200)
                .body("id", equalTo(pet.getId()))
                .extract()
                .path("id");
        pet.setId(petsId);
        System.out.println(pet.getId() + " " + pet.getName() + " " + pet.getStatus());

    }


    @Test(dependsOnMethods = {"addNewPet"})
    public void testGetEmployees() {
        /* pet.setStatus("pending");*/
        given()
                .spec(request)
                .body(pet)
                .when()
                .get("/pet/findByStatus?status = pending")
                .then()
                .spec(response)
                .log().all();

    }

    @Test(dependsOnMethods = {"addNewPet"})
    public void updatePet() {
        pet.setName("Joe");
        pet.setStatus("pending");

        given()
                .spec(request)
                .body(pet)
                .when()
                .put("/pet")
                .then()
                .spec(response)
                .log().all()
                .assertThat()
                .body("id", equalTo(pet.getId()), "name", equalTo(pet.getName()));
    }

    @Test(dependsOnMethods = {"addNewPet"})
    public void testAddEmployee() {
        pet.setName("Tom");
        pet.setStatus("available");

        given()
                .spec(request)
                .body(pet)
                .when()
                .post("/pet/" + pet.getId())
                .then()
                .spec(response)
                .log().all()
                .assertThat()
                .body("id", equalTo(pet.getId()), "name", equalTo(pet.getName()));
    }


    @Test(dependsOnMethods = {"testUpdatedEmployee"})
    public void deleteEmployee() {
        given()
                .spec(request)
                .when()
                .delete("/delete/" + pet.getId())
                .then()
                .body("message", equalTo("pet "));
    }
}



