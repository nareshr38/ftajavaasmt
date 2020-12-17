package com.fta.javaasmt.withlambdaexpressions;

import java.util.*;


public class LamdaSorting5 {

    public List<Integer> sortWithLamda(List<Integer> list) {

        list.sort(
                (o1, o2) -> o1 < o2 ? 1 : -1
        );

        return list;
    }

}
