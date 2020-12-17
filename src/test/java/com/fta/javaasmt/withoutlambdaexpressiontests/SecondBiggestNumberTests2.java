package com.fta.javaasmt.withoutlambdaexpressiontests;

import com.fta.javaasmt.withoutlambdaexpression.SecondBiggestNumberClass2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SecondBiggestNumberTests2 {
    private static final Logger logger = LogManager.getLogger(SecondBiggestNumberTests2.class.getName());
    SecondBiggestNumberClass2 secondBiggestNumber = new SecondBiggestNumberClass2();

    @DataProvider(name = "testData")
    public Object[][] testData() {
        return new Object[][]{
                {new int[]{4, 3, 2, 6}, 4},
                {new int[]{14, 34, 63, 44}, 44},
                {new int[]{1}, -1}


        };
    }

    @Test(dataProvider = "testData")
    public void allTests(int[] arr, int expectedResult) {

        int actualResult = secondBiggestNumber.secondLargest(arr);
        Assert.assertEquals(actualResult, expectedResult);

    }
}
