package com.fta.javaasmt.streamtests;

import com.fta.javaasmt.predicates.Product;
import com.fta.javaasmt.predicates.ProductCategory;
import com.fta.javaasmt.predicates.ProductGrade;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamAllTests {

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

    @Test(dataProvider = "Products")
    public void getProdsGrt1000(Product[] products) {
        List<Product> productList = Arrays.stream(products).filter(product -> product.getProdPrice() > 1000).collect(Collectors.toList());
        System.out.println("Products with Price > 1000");
        for (Product p : productList) {
            System.out.println(p.getProdName() + " " + p.getProdPrice());
        }
        System.out.println(productList);
    }

    @Test(dataProvider = "Products")
    public void getElecProds(Product[] products) {
        List<Product> productList = Arrays.stream(products).filter(product -> product.getProdCategory().equals(ProductCategory.ELECTRONICS)).collect(Collectors.toList());
        System.out.println("Products with category ELECTRONICS");
        for (Product p : productList) {
            System.out.println(p.getProdName() + " " + p.getProdPrice());
        }
        System.out.println(productList);
    }

    @Test(dataProvider = "Products")
    public void getElecProdsGRt1000(Product[] products) {
        Predicate<Product> p1 = prod -> prod.getProdCategory().equals(ProductCategory.ELECTRONICS);
        Predicate<Product> p2 = prod -> prod.getProdPrice() > 1000;
        List<Product> productList = Arrays.stream(products).filter(p1.and(p2)).collect(Collectors.toList());
        System.out.println("Products with category ELECTRONICS and price >1000");
        for (Product p : productList) {
            System.out.println(p.getProdName() + " " + p.getProdPrice());
        }
        System.out.println(productList);
    }


    @Test(dataProvider = "Products")
    public void getTotalOfEleProds(Product[] products) {
        Predicate<Product> p1 = prod -> prod.getProdCategory().equals(ProductCategory.ELECTRONICS);
        System.out.println("Total Price of all ELECTRONICS products");
        System.out.println(Arrays.stream(products).filter(p1).mapToDouble(p -> p.getProdPrice()).sum());
    }
}
