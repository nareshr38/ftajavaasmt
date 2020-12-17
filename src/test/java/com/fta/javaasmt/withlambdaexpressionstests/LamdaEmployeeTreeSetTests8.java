package com.fta.javaasmt.withlambdaexpressionstests;

import com.fta.javaasmt.withlambdaexpressions.LamdaEmployee6;
import com.fta.javaasmt.withlambdaexpressions.LamdaEmployeeTreeSet8;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class LamdaEmployeeTreeSetTests8 {
    LamdaEmployeeTreeSet8 lamdaEmployeeTreeSet = new LamdaEmployeeTreeSet8();

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

    public void testSortEmpByNameTree(LamdaEmployee6[] employees, LamdaEmployee6[] sortedEmp) {

        Set<LamdaEmployee6> employeeSet = new TreeSet<>(Arrays.asList(employees));

        Assert.assertEquals(lamdaEmployeeTreeSet.lamdaSortEmpTreeSet(employeeSet),
                new TreeSet<>(Arrays.asList(sortedEmp)));
    }

}
