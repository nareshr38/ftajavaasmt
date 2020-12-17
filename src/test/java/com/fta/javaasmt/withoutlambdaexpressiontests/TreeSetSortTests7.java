package com.fta.javaasmt.withoutlambdaexpressiontests;

import com.fta.javaasmt.withoutlambdaexpression.TreeSet7;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;


public class TreeSetSortTests7 {
    private static final Logger logger = LogManager.getLogger(EmployeeTests6.class.getName());

    TreeSet7 treeSetSort = new TreeSet7();

    @DataProvider(name = "NumInReverseTree")
    public Object[][] dataforNumInRevTree() {
        return new Object[][]{
                {new Integer[]{5, 4, 3, 6, 2}, new Integer[]{6, 5, 4, 3, 2}},
                {new Integer[]{1, 0, 0, 0, 2}, new Integer[]{2, 1, 0}},
        };
    }

    @Test(dataProvider = "NumInReverseTree")
    public void testSortNumTreeSet(Integer[] ints, Integer[] exp) {
        Set<Integer> integerSet1 = new TreeSet<>(Arrays.asList(ints));
        Assert.assertEquals(treeSetSort.sortNumTreeSet(integerSet1).toArray(), exp);
    }
}
