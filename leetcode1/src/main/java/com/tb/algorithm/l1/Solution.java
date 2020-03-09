package com.tb.algorithm.l1;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * @Author: WindPursuer
 * @Date 2020/3/9 8:41 PM
 */
public class Solution {


    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp) && i != map.get(temp)) {
                return new int[] {i, map.get(temp)};
            }
        }
        return new int[2];

    }


    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        int[] result = solution.twoSum(nums, 9);
        System.out.println(result[0] + "->" + result[1]);
    }
}
