package com.fta.javaasmt.consumersuppliertests;

import com.fta.javaasmt.predicates.Product;
import com.fta.javaasmt.predicates.ProductCategory;
import com.fta.javaasmt.predicates.ProductGrade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class ConsumerSupplierAllTests {
    private static final Logger logger = LogManager.getLogger(ConsumerSupplierAllTests.class.getName());

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
    public void printProds(Product[] products) {
        Consumer<String> stringConsumer = (string) -> {
            if (string.equalsIgnoreCase("file")) {
                File file = new File("Consumer.txt");
                try {
                    FileWriter fileWriter = new FileWriter(file);
                    for (Product p :
                            products) {
                        fileWriter.append(p.getProdName());
                    }
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                for (Product p :
                        products) {
                    logger.info(p.getProdName());
                }
            }
        };
        stringConsumer.accept("");

    }

    @Test(dataProvider = "Products")
    public void updateProds(Product[] products) {
        Consumer<Product[]> consumer = products1 -> {
            for (Product p :
                    products1) {
                if (p.getProdPrice() > 1000) {
                    p.setProdGrade(ProductGrade.PREMIUM);
                    logger.info(p.getProdName() + "  " + p.getProdGrade());
                }
            }
        };
        consumer.accept(products);
    }

    @Test(dataProvider = "Products")
    public void updateProdsGrt3000(Product[] products) {
        Consumer<Product[]> consumer = products1 -> {
            for (Product p :
                    products1) {
                if (p.getProdPrice() > 3000) {
                    p.setProdName(p.getProdName() + "*");
                    logger.info(p.getProdName() + "  " + p.getProdGrade());
                }
            }
        };
        consumer.accept(products);
    }

    @Test(dataProvider = "Products")
    public void printPremiumSuffixed(Product[] products) {
        Consumer<Product[]> consumer = products1 -> {
            for (Product p :
                    products1) {
                if (p.getProdGrade().equals(ProductGrade.PREMIUM) && p.getProdName().endsWith("*")) {
                    logger.info(p.getProdName() + "  " + p.getProdGrade());
                }
            }
        };
        consumer.accept(products);
    }

    @Test
    public void produceProduct() {
        Supplier<Product> productSupplier = () -> {
            return new Product("newProd", ProductCategory.OTHERS, ProductGrade.A, 100);
        };
        logger.info(productSupplier.get().getProdName());
    }

    @Test
    public void generateOTP() {
        IntSupplier otpSupplier = () -> {
            return new Random().nextInt(9000000) + 10000;
        };
        logger.info(otpSupplier.getAsInt());
    }

}
