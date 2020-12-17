package com.fta.javaasmt.bifunctionaltests;

import com.fta.javaasmt.predicates.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.function.BiFunction;

public class BiFunctionalAllTests {
    private static final Logger logger = LogManager.getLogger(BiFunctionalAllTests.class.getName());

    @DataProvider(name = "newProd")
    public Object[][] newProdData() {
        return new Object[][]{
                {"Prod1", 2000}
        };
    }

    @Test(dataProvider = "newProd")
    public void generateProduct(String prodName, double prodPrice) {
        BiFunction<String, Double, Product> stringDoubleProductBiFunction = (s, aDouble) -> new Product(s, aDouble);
        Product p = stringDoubleProductBiFunction.apply(prodName, prodPrice);
        logger.info(p.getProdName() + " " + p.getProdGrade() + " " + p.getProdPrice() + " " + p.getProdCategory());
    }

}
