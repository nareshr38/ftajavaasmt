package com.fta.javaasmt.withoutlambdaexpressiontests;

import com.fta.javaasmt.withoutlambdaexpression.Employee6;
import com.fta.javaasmt.withoutlambdaexpression.SortEmployeesUsingArrayList6;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class EmployeeTests6 {

    private static final Logger logger = LogManager.getLogger(EmployeeTests6.class.getName());


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
    public void testSortEmpByName(Employee6[] actList, Employee6[] expList) {

        ArrayList<Employee6> employeeArrayList = new ArrayList<>(Arrays.asList(actList));

        Assert.assertEquals(SortEmployeesUsingArrayList6.sortEmpByName(employeeArrayList).toString(),
                new ArrayList<>(Arrays.asList(expList)).toString());

    }
}
