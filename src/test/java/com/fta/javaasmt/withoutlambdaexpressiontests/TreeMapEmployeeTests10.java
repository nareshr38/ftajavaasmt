package com.fta.javaasmt.withoutlambdaexpressiontests;

import com.fta.javaasmt.withoutlambdaexpression.Employee6;
import com.fta.javaasmt.withoutlambdaexpression.TreeMapEmployee10;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapEmployeeTests10 {
    private static final Logger logger = LogManager.getLogger(TreeMapEmployeeTests10.class.getName());
    TreeMapEmployee10 treeMapEmployee = new TreeMapEmployee10();

    @Test
    public void testSortMapEmps() {
        Map<Integer, Employee6> employeeMap = new TreeMap<>();
        employeeMap.put(1, new Employee6(11, "Sandy", 1));
        employeeMap.put(2, new Employee6(12, "Joe", 2));
        employeeMap.put(3, new Employee6(10, "Tom", 0));
        System.out.println(employeeMap);
        System.out.println(treeMapEmployee.entriesSortedByEmpValues(employeeMap));
    }
}
