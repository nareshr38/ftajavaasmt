package com.fta.javaasmt.withoutlambdaexpression;

public class SecondBiggestNumberClass2 implements SecondBiggestNumber2 {

    @Override
    public int secondLargest(int[] arr) {
        int index;
        int first;
        int second;
        int arrSize = arr.length;


        if (arrSize < 2) {
            return -1;

        }

        first = second = Integer.MIN_VALUE;
        for (index = 0; index < arrSize; index++) {

            if (arr[index] > first) {
                second = first;
                first = arr[index];
            } else if (arr[index] > second && arr[index] != first)
                second = arr[index];
        }

        if (second == Integer.MIN_VALUE)
            return 0;
        else
            return second;
    }
}
