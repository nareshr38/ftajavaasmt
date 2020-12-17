package com.fta.javaasmt.withoutlambdaexpression;

import java.util.Comparator;
import java.util.List;

public class SortEmployeesUsingArrayList6 {

    public static List<Employee6> sortEmpByName(List<Employee6> employee6s) {

        employee6s.sort(new Comparator<Employee6>() {
            @Override
            public int compare(Employee6 o1, Employee6 o2) {
                return o1.getEmpName().compareTo(o2.getEmpName());
            }
        });

        return employee6s;
    }
}
