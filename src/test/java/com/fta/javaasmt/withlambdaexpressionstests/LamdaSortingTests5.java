package com.fta.javaasmt.withlambdaexpressionstests;

import com.fta.javaasmt.withlambdaexpressions.LamdaSorting5;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

public class LamdaSortingTests5 {

    LamdaSorting5 lamdaSorting = new LamdaSorting5();

    @DataProvider(name = "NumInReverse")
    public Object[][] dataforNumInRev() {
        return new Object[][]{
                {new Integer[]{5, 4, 3, 6, 2}, new Integer[]{6, 5, 4, 3, 2}},
                {new Integer[]{1, 0, 0, 0, 2}, new Integer[]{2, 1, 0, 0, 0}},
        };
    }

    @Test(dataProvider = "NumInReverse")
    public void testSortNumsInDesc(Integer[] actList, Integer[] expList) {
        ArrayList<Integer> actList1 = new ArrayList<Integer>(Arrays.asList(actList));
        ArrayList<Integer> expList1 = new ArrayList<Integer>(Arrays.asList(expList));
        Assert.assertEquals(lamdaSorting.sortWithLamda(actList1), expList1);
    }

}
