package com.whispering.leetcode.question;

import java.util.Arrays;

public class LeetCode1608 {

    public static final String URL = "https://leetcode.cn/problems/special-array-with-x-elements-greater-than-or-equal-x/";

    public int specialArray(int[] nums) {

        Arrays.sort(nums);

        int index = -1;

        for (int i = nums.length; i >= 1; i--) {

            index = nums.length - i;

            if ((nums[index] >= i) & (index - 1 < 0 || nums[index - 1] < i)) {
                return i;
            }

        }

        return -1;

    }

}
