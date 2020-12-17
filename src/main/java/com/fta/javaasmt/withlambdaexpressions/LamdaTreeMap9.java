package com.fta.javaasmt.withlambdaexpressions;

import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class LamdaTreeMap9 {

    public SortedSet<Map.Entry<String, Integer>> lamdaEntriesSortedByValues(Map<String, Integer> map) {

        SortedSet<Map.Entry<String, Integer>> sortedEntries = new TreeSet<Map.Entry<String, Integer>>(
                (e1, e2) -> {
                    return e2.getValue().compareTo(e1.getValue());
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
}
