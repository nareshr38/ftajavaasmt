package com.fta.javaasmt.FunctionTests;

import com.fta.javaasmt.predicates.Product;
import com.fta.javaasmt.predicates.ProductCategory;
import com.fta.javaasmt.predicates.ProductGrade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.function.Function;

public class FunctionAllTests {
    private static final Logger logger = LogManager.getLogger(FunctionAllTests.class.getName());
    FunctionAllTests functionTests;

    @BeforeTest
    void setUp() {
        functionTests = new FunctionAllTests();
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

    @Test(dataProvider = "Products")
    public void testTotalCost(Product[] product) {

        Function<Product[], Double> doubleFunction = products -> {
            double totalSum = 0;
            for (Product p : products) {
                totalSum = totalSum + p.getProdPrice();
            }
            return totalSum;
        };

        logger.info("Total Price::" + doubleFunction.apply(product));
    }

    @Test(dataProvider = "Products")
    public void testTotalCostGrt1000(Product[] product) {
        Function<Product[], Double> doubleFunction = products -> {
            double totalSum = 0;
            for (Product p : products) {
                if (p.getProdPrice() > 1000)
                    totalSum = totalSum + p.getProdPrice();
            }
            return totalSum;
        };

        logger.info("Total Price::" + doubleFunction.apply(product));
    }

    @Test(dataProvider = "Products")
    public void testTotalCostOfEle(Product[] product) {
        Function<Product[], Double> doubleFunction = products -> {
            double totalSum = 0;
            for (Product p : products) {
                if (p.getProdCategory().equals(ProductCategory.ELECTRONICS))
                    totalSum = totalSum + p.getProdPrice();
            }
            return totalSum;
        };

        logger.info("Total Price::" + doubleFunction.apply(product));
    }

    @Test(dataProvider = "Products")
    public void testTotalCostOfEleGrt1000(Product[] product) {
        Function<Product[], Double> doubleFunction = products -> {
            double totalSum = 0;
            for (Product p : products) {
                if (p.getProdCategory().equals(ProductCategory.ELECTRONICS) && p.getProdPrice() > 1000)
                    totalSum = totalSum + p.getProdPrice();
            }
            return totalSum;
        };

        logger.info("Total Price::" + doubleFunction.apply(product));
    }

}
