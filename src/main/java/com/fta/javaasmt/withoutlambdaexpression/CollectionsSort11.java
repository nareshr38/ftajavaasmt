package com.fta.javaasmt.withoutlambdaexpression;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsSort11 {

    public List<Employee6> sortEmp(List<Employee6> employeeList) {
        Collections.sort(employeeList, new Comparator<Employee6>() {
            @Override
            public int compare(Employee6 o1, Employee6 o2) {
                return o1.getEmpName().compareTo(o2.getEmpName());
            }
        });
        return employeeList;
    }
}
