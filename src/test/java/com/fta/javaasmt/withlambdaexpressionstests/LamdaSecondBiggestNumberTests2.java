package com.fta.javaasmt.withlambdaexpressionstests;

import com.fta.javaasmt.withlambdaexpressions.LamdaSecondBiggestNumberClass2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LamdaSecondBiggestNumberTests2 {
    private static final Logger logger = LogManager.getLogger(LamdaSecondBiggestNumberTests2.class.getName());

    LamdaSecondBiggestNumberClass2 secondBigNumberW = new LamdaSecondBiggestNumberClass2();

    @DataProvider(name = "testDataW")
    public Object[][] testDataW() {
        return new Object[][]{
                {new int[]{4, 3, 2, 6}, 4},
                {new int[]{14, 34, 63, 44}, 44},
                {new int[]{1}, -1}


        };
    }

    @Test(dataProvider = "testDataW")
    public void allTests(int[] arr, int expectedResult) {

        int actualResult = secondBigNumberW.secondBigNumber.print2largest(arr);
        Assert.assertEquals(actualResult, expectedResult);


    }
}
