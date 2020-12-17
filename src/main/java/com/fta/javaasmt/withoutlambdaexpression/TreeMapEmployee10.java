package com.fta.javaasmt.withoutlambdaexpression;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeMapEmployee10 {
    public SortedSet<Map.Entry<Integer, Employee6>> entriesSortedByEmpValues(Map<Integer, Employee6> map) {

        SortedSet<Map.Entry<Integer, Employee6>> sortedEntries = new TreeSet<Map.Entry<Integer, Employee6>>(
                new Comparator<Map.Entry<Integer, Employee6>>() {

                    @Override

                    public int compare(Map.Entry<Integer, Employee6> e1, Map.Entry<Integer, Employee6> e2) {
                        return e1.getValue().getEmpName().compareTo(e2.getValue().getEmpName());
                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }

}
