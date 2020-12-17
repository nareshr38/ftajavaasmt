package com.fta.javaasmt.primitiveinterfacetests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;

public class PrimitiveInterfaceAllTests {

    @DataProvider(name = "prime")
    public Object[][] primeTestData() {
        return new Object[][]{
                {2, true},
                {3, true}

        };
    }

    @Test(dataProvider = "prime")
    public void testPrime(int num, boolean flag) {
        IntPredicate intPredicate = n -> {
            int temp = 2;
            while (temp < n / 2) {
                if (n % temp == 0)
                    return false;
            }
            return true;
        };
        Assert.assertEquals(intPredicate.test(num), flag);
    }

    @DataProvider(name = "sqr")
    public Object[][] sqrTestData() {
        return new Object[][]{
                {2, 4},
                {3, 9},
                {4, 16}
        };
    }

    @Test(dataProvider = "sqr")
    public void testPrintnTestSqr(int num, int sqrVal) {
        IntConsumer intConsumer = n -> System.out.println(n * n);
        intConsumer.accept(num);

    }

    @Test
    public void testGenerateRandombelow500() {
        IntSupplier intSupplier = () -> new Random().nextInt(500);
        System.out.println("Random Number" + intSupplier.getAsInt());

    }
}


