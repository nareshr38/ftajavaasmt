package com.fta.javaasmt.withoutlambdaexpressiontests;

import com.fta.javaasmt.withoutlambdaexpression.Employee6;
import com.fta.javaasmt.withoutlambdaexpression.EmployeeTreeSet8;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class EmployeeTreeSetTests8 {
    EmployeeTreeSet8 employeeTreeSet = new EmployeeTreeSet8();

    @DataProvider(name = "EmployeeData")
    public Object[][] dataForEmployee() {
        return new Object[][]{
                {new Employee6[]{
                        new Employee6(23, "Vijay", 101),
                        new Employee6(27, "Ajay", 27),
                        new Employee6(105, "Jai", 21)},
                        new Employee6[]{
                                new Employee6(27, "Ajay", 106),
                                new Employee6(21, "Jai", 105),
                                new Employee6(23, "Vijay", 101)}
                }
        };
    }

    @Test(dataProvider = "EmployeeData")
    public void testSortEmpByNameTree(Employee6[] employees, Employee6[] sortedEmp) {

        Set<Employee6> employeeSet = new TreeSet<>(Arrays.asList(employees));

        Assert.assertEquals(employeeTreeSet.sortEmpTreeSet(employeeSet),
                new TreeSet<>(Arrays.asList(sortedEmp)));
    }
}
