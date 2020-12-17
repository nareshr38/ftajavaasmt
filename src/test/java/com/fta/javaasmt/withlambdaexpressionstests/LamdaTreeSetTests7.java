package com.fta.javaasmt.withlambdaexpressionstests;

import com.fta.javaasmt.withlambdaexpressions.LamdaTreeSet7;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class LamdaTreeSetTests7 {
    LamdaTreeSet7 lamdaTreeSort = new LamdaTreeSet7();

    @DataProvider(name = "NumInReverseTree")
    public Object[][] dataforNumInRevTree() {
        return new Object[][]{
                {new Integer[]{5, 4, 3, 6, 2}, new Integer[]{6, 5, 4, 3, 2}},
                {new Integer[]{1, 0, 0, 0, 2}, new Integer[]{2, 1, 0}},
        };
    }

    @Test(dataProvider = "NumInReverseTree")
    public void testLamdaSortNumTreeSet(Integer[] ints, Integer[] exp) {
        Set<Integer> integerSet1 = new TreeSet<>(Arrays.asList(ints));
        Assert.assertEquals(lamdaTreeSort.lamdaSortNumTreeSet(integerSet1).toArray(), exp);
    }
}
