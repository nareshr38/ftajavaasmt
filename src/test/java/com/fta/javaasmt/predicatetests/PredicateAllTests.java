package com.fta.javaasmt.predicatetests;

import com.fta.javaasmt.predicates.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateAllTests {
    private static final Logger logger = LogManager.getLogger(PredicateAllTests.class.getName());

    PredicateAllTests predicateTests;

    @BeforeTest
    public void setUp() {
        predicateTests = new PredicateAllTests();
    }

    @DataProvider(name = "Products")
    public Object[] dataProducts() {
        return new Object[]{
                new Product[]{
                        new Product("P1", ProductCategory.ELECTRONICS, ProductGrade.A, 5000.22),
                        new Product("P2", ProductCategory.ELECTRONICS, ProductGrade.A, 52.12),

                        new Product("P3", ProductCategory.ELECTRONICS, ProductGrade.B, 90.02),
                        new Product("P4", ProductCategory.ELECTRONICS, ProductGrade.B, 9909.99),


                        new Product("P5", ProductCategory.OTHERS, ProductGrade.A, 50.00),
                        new Product("P6", ProductCategory.OTHERS, ProductGrade.B, 5200.00),

                        new Product("P7", ProductCategory.OTHERS, ProductGrade.B, 900.00),
                        new Product("P8", ProductCategory.OTHERS, ProductGrade.B, 99.99)
                }
        };
    }

    
    
    private List<String> getProducts(Predicate<Product> predicate, Product[] products) {

        List<String> productList = new ArrayList<>();
        
        for (Product product : products) {
                if (predicate.test(product))
                productList.add(product.getProdName());
        }
        return productList;
    }

    @Test(dataProvider = "Products")
    public void printProds(Product[] products) {
        Predicate<Product> predicate = product -> (product.getProdPrice() > 1000);
        logger.info(predicateTests.getProducts(predicate, products));

    }

    @Test(dataProvider = "Products")
    public void printEleProducts(Product[] products) {
        Predicate<Product> predicate = product -> product.getProdCategory().equals(ProductCategory.ELECTRONICS);
        logger.info(predicateTests.getProducts(predicate, products));
    }

    @Test(dataProvider = "Products")
    public void printEleProductsOfRange(Product[] products) {
        Predicate<Product> predicate = product -> product.getProdCategory().equals(ProductCategory.ELECTRONICS);
        Predicate<Product> predicate1 = product -> product.getProdPrice() > 100;
        logger.info(predicateTests.getProducts(predicate1.and(predicate), products));
    }

    @Test(dataProvider = "Products")
    public void printProductsOfRange(Product[] products) {
        Predicate<Product> predicate = product -> product.getProdCategory().equals(ProductCategory.ELECTRONICS);
        Predicate<Product> predicate1 = product -> product.getProdPrice() > 100;
        logger.info(predicateTests.getProducts(predicate1.or(predicate), products));
    }

    @Test(dataProvider = "Products")
    public void printProductsOfRange2(Product[] products) {
        Predicate<Product> predicate = product -> product.getProdCategory().equals(ProductCategory.ELECTRONICS);
        Predicate<Product> predicate1 = product -> product.getProdPrice() < 100;
        logger.info(predicateTests.getProducts(predicate1.and(predicate), products));
    }

    @DataProvider(name = "Responses")
    public Object[] dataResponses() {
        return new Object[]{
                new Response[]{
                        new Response("R1", ResponseStatusCode.STATUS_CODE_200, ResponseType.HTML),
                        new Response("R2", ResponseStatusCode.STATUS_CODE_400, ResponseType.JSON),

                        new Response("R3", ResponseStatusCode.STATUS_CODE_500, ResponseType.XML),
                        new Response("R4", ResponseStatusCode.STATUS_CODE_500, ResponseType.JSON),


                        new Response("R5", ResponseStatusCode.STATUS_CODE_400, ResponseType.TXT),
                        new Response("R6", ResponseStatusCode.STATUS_CODE_200, ResponseType.TXT),

                        new Response("R7", ResponseStatusCode.STATUS_CODE_200, ResponseType.HTML),
                        new Response("R8", ResponseStatusCode.STATUS_CODE_400, ResponseType.HTML)
                }
        };
    }

    private List<String> getResponses(Predicate<Response> predicate, Response[] responses) {
        List<String> responseList = new ArrayList<>();
        for (Response response : responses) {
            if (predicate.test(response))
                responseList.add(response.getResponseBody());
        }
        return responseList;
    }

    @Test(dataProvider = "Responses")
    public void get400Responses(Response[] responses) {
        Predicate<Response> predicate = response -> response.getResponseStatusCode().equals(ResponseStatusCode.STATUS_CODE_400);
        logger.info(predicateTests.getResponses(predicate, responses));
    }

    @Test(dataProvider = "Responses")
    public void getJSONresponses(Response[] responses) {
        Predicate<Response> predicate = response -> response.getResponseType().equals(ResponseType.JSON);
        logger.info(predicateTests.getResponses(predicate, responses));
    }

    @Test(dataProvider = "Responses")
    public void get400JSONResponses(Response[] responses) {
        Predicate<Response> predicate = response -> response.getResponseStatusCode().equals(ResponseStatusCode.STATUS_CODE_400);
        Predicate<Response> predicate1 = response -> response.getResponseType().equals(ResponseType.JSON);
        logger.info(predicateTests.getResponses(predicate.and(predicate1), responses));
    }

    @Test(dataProvider = "Responses")
    public void get400orJSONResponses(Response[] responses) {
        Predicate<Response> predicate = response -> response.getResponseStatusCode().equals(ResponseStatusCode.STATUS_CODE_400);
        Predicate<Response> predicate1 = response -> response.getResponseType().equals(ResponseType.JSON);
        System.out.println(predicateTests.getResponses(predicate.or(predicate1), responses));
    }

    @Test(dataProvider = "Responses")
    public void getNot400JSONResponses(Response[] responses) {
        Predicate<Response> predicate = response -> response.getResponseStatusCode().equals(ResponseStatusCode.STATUS_CODE_400);
        Predicate<Response> predicate1 = response -> response.getResponseType().equals(ResponseType.JSON);
        logger.info(predicateTests.getResponses(predicate.negate().and(predicate1), responses));
    }

   /* @Test(dataProvider = "Products")
    public void getTotalCostOfProds(Product[] products){
        Function<Product,Double> function = product -> product.getProdPrice();
    }*/

}
