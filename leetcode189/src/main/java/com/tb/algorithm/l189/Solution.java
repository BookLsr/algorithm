package com.tb.algorithm.l189;

/**
 * @Description:
 * @Author: WindPursuer
 * @Date 2020/3/6 8:35 PM
 */

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
public class Solution {


    public void rotate(int[] nums, int k) {

        if (null == nums || nums.length <= 1 || k < 0) {
            System.out.println("不符合条件");
            return;
        }

        k = k % nums.length;
        for (int i = 1; i <= k; i++) {

            int temp = nums[0];
            for (int j = 1; j < nums.length; j++) {
                if (j == nums.length - 1) {
                    nums[0] = nums[j];
                    nums[j] = temp;
                    break;
                }
                int temp1 = nums[j];
                nums[j] = temp;
                temp = temp1;
            }

        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(a, 3);
    }
}
