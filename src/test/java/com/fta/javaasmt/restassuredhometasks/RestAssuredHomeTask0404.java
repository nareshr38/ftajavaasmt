package com.fta.javaasmt.restassuredhometasks;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class RestAssuredHomeTask0404 {


    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = "http://dummy.restapiexample.com/";
        RestAssured.basePath = "api/v1";
        RestAssured.requestSpecification = new RequestSpecBuilder().
                setContentType("application/json").build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(200)
                .expectStatusLine("HTTP/1.1 200 OK")
                //.expectHeader("Content-Encoding",equalTo("gzip"))
                .build();

    }


    @Test(priority = 1)
    public void testCaseGet() {

                get("/employees").
       then()
                        .assertThat().statusCode(200)
                        .body("data.findAll{it.id}.size()",equalTo(24));


    }


    @Test(priority = 4)
    public void testCaseDelete(){

     given().
                  delete("/delete/5").
     then()
                .assertThat().statusCode(200);

          get("employees").
     then()
                 .assertThat().statusCode(200)
                 .body("data.findAll{it.id}.size()",equalTo(24));



    }

    @Test(priority = 2)
    public void testCasePost(){

        EmployeeDomain EmpDom = new EmployeeDomain(50,"Hima",23,20000);

         given()
              .body(EmpDom)
         .when()
              .post("/create")
         .then()
               .assertThat().statusCode(200);

         get("employees")
         .then()
               .assertThat()
               .statusCode(200)
               .body("data.findAll{it.id}.size()",equalTo(24));
               /*.body("data.findAll{it.id}",equalTo(50))
               .body("data.findAll{it.empoyee_name,}",equalTo("Hima"))
               .body("data.findAll{it.empoyee_age,}",equalTo(23))
               .body("data.findAll{it.empoyee_salary,}",equalTo(20000));*/
    }

    @Test(priority = 3)
    public void testCasePut(){

        EmployeeDomain EmpDom = new EmployeeDomain(3,"Himas",23,10000);

        given()
               .body(EmpDom)
        .when()
               .put("/update/id")
        .then()
               .assertThat().statusCode(200);

        get("employees")
        .then()
               .assertThat()
               .statusCode(200)
               .body("data.findAll{it.id}.size()",equalTo(24));
          /*     .body("data.findAll{it.id}",equalTo(50))
               .body("data.findAll{it.empoyee_name,}",equalTo("Himas"))
               .body("data.findAll{it.empoyee_age,}",equalTo(23))
               .body("data.findAll{it.empoyee_salary,}",equalTo(10000));*/
    }


}
