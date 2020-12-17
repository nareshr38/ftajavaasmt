package com.fta.javaasmt.withlambdaexpressionstests;

import com.fta.javaasmt.withlambdaexpressions.LamdaEmployee6;
import com.fta.javaasmt.withlambdaexpressions.LamdaSortEmployesUsingArrayList6;
import com.fta.javaasmt.withoutlambdaexpression.Employee6;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class LamdaEmployeeTests6 {


    private static final Logger logger = LogManager.getLogger(LamdaEmployeeTests6.class.getName());


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
    public void testSortEmpByName(LamdaEmployee6[] actList, LamdaEmployee6[] expList) {

        ArrayList<LamdaEmployee6> employeeArrayList = new ArrayList<>(Arrays.asList(actList));

        Assert.assertEquals(LamdaSortEmployesUsingArrayList6.lamdaSortEmpByName(employeeArrayList).toString(),
                new ArrayList<>(Arrays.asList(expList)).toString());

    }

}
