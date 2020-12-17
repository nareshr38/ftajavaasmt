package com.fta.javaasmt.withoutlambdaexpression;

import java.util.*;

public class TreeSet7 {

    public Set<Integer> sortNumTreeSet(Set<Integer> treeSet) {

        TreeSet<Integer> newTreeSet = new TreeSet<Integer>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 2 : -1;
            }
        });
        newTreeSet.addAll(treeSet);
        return newTreeSet;


    }
}
