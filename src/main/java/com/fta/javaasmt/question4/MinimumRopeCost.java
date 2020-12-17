package com.fta.javaasmt.question4;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumRopeCost {
MinimumRopeCost(){

    }

    public static int toFindMinimumCost(int[] ropes) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();


        for (int ropeIndex = 0; ropeIndex < ropes.length; ropeIndex++) {
            priorityQueue.addAll(Collections.singleton(ropes[ropeIndex]));
        }

        int costOfRopes = 0;

        while (priorityQueue.size() > 1) {

            int firstRope = priorityQueue.poll();
            int secondRope = priorityQueue.poll();
            costOfRopes += firstRope + secondRope;
            priorityQueue.add(firstRope + secondRope);
        }

        return costOfRopes;
    }
}
