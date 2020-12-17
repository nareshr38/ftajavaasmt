package com.fta.javaasmt.withlambdaexpressions;

import java.util.List;

public class LamdaSortEmployesUsingArrayList6 {

    public static List<LamdaEmployee6> lamdaSortEmpByName(List<LamdaEmployee6> employees) {
        employees.sort(
                (o1, o2) -> o1.getEmpName().compareTo(o2.getEmpName())
        );

        return employees;
    }
}
