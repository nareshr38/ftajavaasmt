package com.fta.javaasmt.withlambdaexpressions;

import java.util.Collections;
import java.util.List;

public class LamdaCollectionSort11 {

    public List<LamdaEmployee6> lamdaSortEmp1(List<LamdaEmployee6> employeeList) {
        Collections.sort(employeeList,
                (o1, o2) -> {
                    return o1.getEmpName().compareTo(o2.getEmpName());
                });
        return employeeList;
    }
}
