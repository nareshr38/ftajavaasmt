package com.fta.javaasmt.question4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MinimumRopeCostTests {
    private static final Logger logger = LogManager.getLogger(MinimumRopeCostTests.class.getName());

    @DataProvider(name = "testData")
    public Object[][] testData() {
        return new Object[][]{
                {new int[]{4,3,2,6}, 26},
                {new int []{-5,8,3,4},10},
                {new int[]{}, 0},
                {new int[]{15, 35, -6, 102}, 199},

        };
    }

    @Test(dataProvider = "testData")
    public void allTests(int[] ropes, int expectedResult) {

        int actualResult = MinimumRopeCost.toFindMinimumCost(ropes);
        Assert.assertEquals(actualResult, expectedResult);
        logger.info("Actual result :{}", actualResult);
        logger.info("Expected Result :{}" , expectedResult);


    }
}
