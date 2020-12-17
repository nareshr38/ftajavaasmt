package com.fta.javaasmt.withoutlambdaexpression;

import java.util.*;

public class Sorting5 {

    public List<Integer> sortingMethod(List<Integer> list) {


        list.sort(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1 : -1;
            }
        });

        return list;
    }
}


