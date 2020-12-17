package com.fta.javaasmt.withlambdaexpressions;

import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class LamdaTreeMapEmployee10 {


    public SortedSet<Map.Entry<Integer, LamdaEmployee6>> lamdaEntriesSortedByEmpValues
            (Map<Integer, LamdaEmployee6> map) {

        SortedSet<Map.Entry<Integer, LamdaEmployee6>> sortedEntries = new TreeSet<Map.Entry<Integer, LamdaEmployee6>>(
                (e1, e2) -> {
                    return e1.getValue().getEmpName().compareTo(e2.getValue().getEmpName());
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
}
