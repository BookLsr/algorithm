package com.tb.algorithm.l41;


import com.sun.crypto.provider.DESKeyFactory;

import java.util.concurrent.ConcurrentHashMap;

public class Solution {



    /**
     * @Description: 接雨水，还没搞懂，明天继续
     * @Author: WindPursuer
     * @Date 2020/3/11 10:49 PM
     */
    public int trap(int[] height) {
        int sum = 0;
        String a = "as";
        char[] c = a.toCharArray();
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }

        return sum;

    }


    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader()); //启动类加载器C语言实现，故为null
        System.out.println(DESKeyFactory.class.getClassLoader().getClass().getName());
        System.out.println(Solution.class.getClassLoader().getClass().getName());
        System.out.println(ClassLoader.getSystemClassLoader().getClass().getName());

    }

}
