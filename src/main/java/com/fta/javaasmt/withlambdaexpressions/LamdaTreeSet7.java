package com.fta.javaasmt.withlambdaexpressions;

import java.util.Set;
import java.util.TreeSet;

public class LamdaTreeSet7 {
    public Set<Integer> lamdaSortNumTreeSet(Set<Integer> treeSet) {
        TreeSet<Integer> newTreeSet = new TreeSet<Integer>(
                (o1, o2) -> o1 < o2 ? 1 : -1
        );
        newTreeSet.addAll(treeSet);
        return newTreeSet;
    }
}
