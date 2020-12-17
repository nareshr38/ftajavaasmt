package com.fta.javaasmt.withlambdaexpressionstests;

import com.fta.javaasmt.withlambdaexpressions.LamdaEmployee6;
import com.fta.javaasmt.withlambdaexpressions.LamdaTreeMapEmployee10;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.TreeMap;

public class LamdaTreeMapEmployeeTests10 {
    private static final Logger logger = LogManager.getLogger(LamdaTreeMapEmployeeTests10.class.getName());
    LamdaTreeMapEmployee10 lamdaTreeMapEmployee = new LamdaTreeMapEmployee10();

    @Test
    public void testSortMapEmps() {
        Map<Integer, LamdaEmployee6> employeeMap = new TreeMap<>();
        employeeMap.put(1, new LamdaEmployee6(11, "Sandy", 1));
        employeeMap.put(2, new LamdaEmployee6(12, "Joe", 2));
        employeeMap.put(3, new LamdaEmployee6(10, "Tom", 0));
        logger.info(employeeMap);
        logger.info(lamdaTreeMapEmployee.lamdaEntriesSortedByEmpValues(employeeMap));
    }
}
