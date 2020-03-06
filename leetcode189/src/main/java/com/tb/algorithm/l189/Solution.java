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

    /**
     * 参考方法2， 举例 1 2 3 4 5 6   K=3
     *  第一次循环、 1 -> 4, 4 -> 1,
     *  第二次循环、 2 -> 5, 5 -> 2,
     *  第三次循环、 3 -> 6, 6 -> 3,
     *  完全替换
     *
     *  举例 1 2 3 4 5 6 7   K=3
     *      *  第一次循环、 1 -> 4, 4 -> 7, 7 -> 3, 3 -> 6, 6 -> 2, 2 -> 5, 5 -> 1
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {

        if (null == nums || nums.length <= 1 || k < 0) {
            System.out.println("不符合条件");
            return;
        }
        int count = 0;
        for (int i = 0; count < nums.length; i++) {
            int current = i;
            int prev = nums[i];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (i != current);


        }

    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate2(a, 3);
        System.out.println(1);
    }
}
