package com.fta.javaasmt.withoutlambdaexpressiontests;

import com.fta.javaasmt.withoutlambdaexpression.CollectionsSort11;
import com.fta.javaasmt.withoutlambdaexpression.Employee6;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CollectionSortTests11 {
    CollectionsSort11 collectionSort = new CollectionsSort11();

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
    public void testSortEmp(Employee6[] employees, Employee6[] sortedEmp) {
        ArrayList<Employee6> employeeArrayList = new ArrayList<>(Arrays.asList(employees));
        Assert.assertEquals(collectionSort.sortEmp(employeeArrayList).toString(), new ArrayList<>(Arrays.asList(sortedEmp)).toString());
    }
}
