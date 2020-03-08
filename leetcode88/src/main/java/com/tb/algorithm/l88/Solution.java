package com.tb.algorithm.l88;
/**
 * @Description: 合并数组
 * @Author: WindPursuer
 * @Date 2020/3/8 9:50 PM
 */
public class Solution {


    /**
     * 采用额外数组，去承载排序后的结果
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums_result = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m || j < n) {

            if (i < m && (j >= n || nums1[i] < nums2[j])) {
                nums_result[k] = nums1[i];
                i++;
                k++;
                continue;
            }
            nums_result[k] = nums2[j];
            j++;
            k++;

        }
        System.arraycopy(nums_result, 0, nums1, 0, m + n);

    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] a = {1, 2, 3, 0, 0, 0};
        int[] b = {2, 5, 6};
        solution.merge(a, 3, b, 3);

    }
}
