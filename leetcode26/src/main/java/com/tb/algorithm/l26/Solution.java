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


    /**
     * @Description: 找出最先出现的
     * @Author: WindPursuer
     * @Date 2020/3/7 2:09 PM
     */
    public int find(int[] nums, int key) {
        /**
         * 1、判断数组
         * 2、确定key是否在数组内
         * 3、采用二分法查找
         */

        if (nums == null || nums.length == 0) {
            System.out.println("不符合规范");
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        if (nums[start] > key || nums[end] < key) {
            System.out.println("不符合规范");
            return -1;
        }

        int middle;
        while (start <= end) {
            middle = (start + end) / 2;
            /**
             * 1、判断二分在左还是右
             * 2、如果相等则往左继续寻找
             */
            if (nums[middle] >= key) {
                end = middle - 1;
            } else if (nums[middle] < key) {
                start = middle + 1;
            } else {
                while (middle - 1 >= 0 && nums[middle - 1] == key) {
                    middle--;
                }
                return middle;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4,4,5,6,7,8,9};
        int result = solution.find(nums, 5);
        System.out.println(result);
    }
}
