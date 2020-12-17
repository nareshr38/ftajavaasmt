package com.fta.javaasmt.withlambdaexpressionstests;

import com.fta.javaasmt.withlambdaexpressions.LamdaPalindromeClass1;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LamdaPalindromeTests1 {

    LamdaPalindromeClass1 p = new LamdaPalindromeClass1();

    @DataProvider(name = "testDataForPalindrome")
    public Object[][] testDataPalindrome() {
        return new Object[][]{
                {"BOB", true},
                {"Hima", false}


        };
    }


    @Test(dataProvider = "testDataForPalindrome")
    public void palindromeTest(String string, boolean expectedResult) {

        boolean actualResult = p.pc.isPalindrome(string);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
