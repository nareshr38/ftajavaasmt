package com.fta.javaasmt.withoutlambdaexpression;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class EmployeeTreeSet8 {
    public Set<Employee6> sortEmpTreeSet(Set<Employee6> employeeSet) {
        Set<Employee6> newEmpSet = new TreeSet<>(new Comparator<Employee6>() {
            @Override
            public int compare(Employee6 o1, Employee6 o2) {
                return o1.getEmpName().compareTo(o2.getEmpName());
            }
        });
        newEmpSet.addAll(employeeSet);
        return newEmpSet;
    }
}
