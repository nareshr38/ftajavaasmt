package com.fta.javaasmt.withoutlambdaexpressiontests;

import com.fta.javaasmt.withoutlambdaexpression.StringRotationClass3;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StringRotationTests3 {
    StringRotationClass3 stringRotation = new StringRotationClass3();


    @DataProvider(name = "testDataForPalindrome")
    public Object[][] testDataPalindrome() {
        return new Object[][]{
                {"AACD", "ACDA", true},
                {"BOB", "ROB", false}


        };
    }


    @Test(dataProvider = "testDataForPalindrome")
    public void palindromeTest(String string1, String string2, boolean expectedResult) {

        boolean actualResult = stringRotation.areRotations(string1, string2);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
