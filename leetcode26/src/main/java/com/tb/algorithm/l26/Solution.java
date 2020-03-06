package com.tb.algorithm.l26;

/**
 * @Description:
 * @Author: WindPursuer
 * @Date 2020/3/5 9:54 PM
 */

/**
 * 删除排序数组中的重复项,不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class Solution {


    public int removeDuplicates(int[] nums) {
        /**
         * 1、判断长度
         * 2、进行相同前置操作
         */
        int length = nums.length;
        if (length <= 1) {
            return length;
        }
        int temp = 0;
        for (int i = 1; i < length; i++) {
            if (nums[i] != nums[i-1]) {
                temp += 1;
                nums[temp] = nums[i];
            }


        }
        return temp + 1;

    }
}
