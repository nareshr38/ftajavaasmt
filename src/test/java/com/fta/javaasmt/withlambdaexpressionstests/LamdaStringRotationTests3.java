package com.fta.javaasmt.withlambdaexpressionstests;

import com.fta.javaasmt.withlambdaexpressions.LamdaStringRotationClass3;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LamdaStringRotationTests3 {
    LamdaStringRotationClass3 stringRotationClassW = new LamdaStringRotationClass3();


    @DataProvider(name = "testDataForStringRotationW")
    public Object[][] testDataStringRoatation() {
        return new Object[][]{
                {"AACD", "ACDA", true},
                {"BOB", "ROB", false}


        };
    }


    @Test(dataProvider = "testDataForStringRotationW")
    public void stringRotation(String string1, String string2, boolean expectedResult) {

        boolean actualResult = stringRotationClassW.stringRotationW.areRotations(string1, string2);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
