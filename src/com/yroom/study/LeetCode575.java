package com.yroom.study;

import java.util.Arrays;

public class LeetCode575 {
    public int distributeCandies(int[] candyType) {
        int avg = candyType.length / 2;
        int candyTypeAfterDis = Arrays.stream(candyType).distinct().toArray().length;
        return candyTypeAfterDis>=avg?avg:candyTypeAfterDis;
    }

}
