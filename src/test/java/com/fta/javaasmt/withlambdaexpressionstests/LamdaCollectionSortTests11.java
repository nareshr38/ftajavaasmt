package com.fta.javaasmt.withlambdaexpressionstests;

import com.fta.javaasmt.withlambdaexpressions.LamdaCollectionSort11;
import com.fta.javaasmt.withlambdaexpressions.LamdaEmployee6;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class LamdaCollectionSortTests11 {
    LamdaCollectionSort11 lamdaCollectionSort = new LamdaCollectionSort11();

    @DataProvider(name = "EmployeeData")
    public Object[][] dataForEmployee() {
        return new Object[][]{
                {new LamdaEmployee6[]{
                        new LamdaEmployee6(23, "Vijay", 101),
                        new LamdaEmployee6(27, "Ajay", 27),
                        new LamdaEmployee6(105, "Jai", 21)},
                        new LamdaEmployee6[]{
                                new LamdaEmployee6(27, "Ajay", 106),
                                new LamdaEmployee6(21, "Jai", 105),
                                new LamdaEmployee6(23, "Vijay", 101)}
                }
        };
    }

    @Test(dataProvider = "EmployeeData")
    public void testLamdaSortEmp(LamdaEmployee6[] employees, LamdaEmployee6[] sortedEmp) {
        ArrayList<LamdaEmployee6> employeeArrayList = new ArrayList<>(Arrays.asList(employees));
        Assert.assertEquals(lamdaCollectionSort.lamdaSortEmp1(employeeArrayList).toString(),
                new ArrayList<>(Arrays.asList(sortedEmp)).toString());
    }
}
