package com.fta.javaasmt.withoutlambdaexpressiontests;

import com.fta.javaasmt.withoutlambdaexpression.PalindromeClass1;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PalindromeTests1 {

    PalindromeClass1 p = new PalindromeClass1();

    @DataProvider(name = "testDataForPalindrome")
    public Object[][] testDataPalindrome() {
        return new Object[][]{
                {"BOB", true},
                {"Hima", false}


        };
    }


    @Test(dataProvider = "testDataForPalindrome")
    public void palindromeTest(String string, boolean expectedResult) {

        boolean actualResult = p.isPalindromeW(string);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
