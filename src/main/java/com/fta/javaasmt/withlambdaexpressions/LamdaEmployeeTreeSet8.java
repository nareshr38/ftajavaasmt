package com.fta.javaasmt.withlambdaexpressions;

import java.util.Set;
import java.util.TreeSet;

public class LamdaEmployeeTreeSet8 {
    public Set<LamdaEmployee6> lamdaSortEmpTreeSet(Set<LamdaEmployee6> employeeSet) {
        Set<LamdaEmployee6> newEmpSet = new TreeSet<>(
                (o1, o2) -> o1.getEmpName().compareTo(o2.getEmpName())
        );
        newEmpSet.addAll(employeeSet);
        return newEmpSet;
    }
}
