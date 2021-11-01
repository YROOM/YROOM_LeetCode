package com.yroom.study;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test53 {
    //给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
/*
    输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
    输出：6
    解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
*/
    public static int maxSubArray(int[] nums) {
        int ans = 0;
        Set<Integer> ansSet = new HashSet<>();
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return Arrays.stream(nums).max().getAsInt();
        }
        if (nums.length > 1) {
            ansSet.add(Arrays.stream(nums).max().getAsInt());
            //滑动窗口从1到长度
            for (int i = 2; i <= nums.length; i++) {
                ansSet.addAll(flowWindow(i, nums.length, nums));
            }

        }
        return ansSet.stream().max(Integer::compareTo).get();
    }

    //滑动窗口
    public static Set<Integer> flowWindow(int n, int length, int[] nums) {
        Set<Integer> sets = new HashSet<>();
        int i = 0;
        int j = n - 1;
        while (j < length) {
            int ans = 0;
            for (int k = i; k <= j; k++) {
                ans = ans + nums[k];
            }
            sets.add(ans);
            i++;
            j++;
        }
        return sets;
    }


    public static void main(String[] args) {
        int[] a = {5, 4, -1, 7, 8};

        System.out.println(maxSubArray(a));


    }

}
