package com.whispering.leetcode.question;

import java.util.Arrays;

public class LeetCode724 {

    public static void main(String[] args) {
        int[] l = new int[]{1, 2, 3, 4, 5};
        System.out.println(new LeetCode724().pivotIndex(l));
    }

    public int pivotIndex(int[] nums) {
        int s = Arrays.stream(nums).sum();
        if (s - nums[0] == 0) {
            return 0;
        }
        int l = 0;
        int r;

        for (int i = 1; i < nums.length; i++) {
            l += nums[i - 1];
            r = (s - l - nums[i]);
            if (l == r) {
                return i;
            }
        }

        return -1;

//        int total = Arrays.stream(nums).sum();
//        int sum = 0;
//        for (int i = 0; i < nums.length; ++i) {
//            if (2 * sum + nums[i] == total) {
//                return i;
//            }
//            sum += nums[i];
//        }
//        return -1;

    }

}
