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
            if (nums[middle] > key) {
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


//    public static void main(String[] args) {
////        Solution solution = new Solution();
////        int[] nums = {1,2,3,4,4,5,6,7,8,9};
////        int result = solution.find(nums, 5);
////        System.out.println(result);
//
//        char[] a = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
//        char[] b = {'a', 'b', 'c', 'd', 'f', 'g'};
//        char result1 = find(a, b);
//        System.out.println(result1);
//    }




    public static char find(char[] chars1, char[] chars2) {
        /**
         * 1、判断数组
         * 2、确定key是否在数组内
         * 3、采用二分法查找
         */

        if (chars1 == null || chars1.length == 0) {
            System.out.println("不符合规范");
            throw new RuntimeException();
        }

        if (chars2 == null || chars2.length == 0) {
            System.out.println("不符合规范");
            throw new RuntimeException();
        }
        int start = 0;
        int end = chars1.length - 1;
        int middle;
        while (start <= end) {
            middle = (start + end) / 2;
            if (chars1[middle] == chars2[middle]) {
                start = middle + 1;
            }
            if (chars1[middle] != chars2[middle]) {
                if (chars1[middle - 1] == chars2[middle - 1]) {
                    return chars1[middle];
                }
                end = middle;
            }

        }
        throw new RuntimeException();

    }






    public static void main(String[] args) throws InterruptedException {
        final Object lock1 = new Object();
        final Object lock2 = new Object();
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("1 开始获取1锁");
                synchronized (lock1) {
                    System.out.println("1 获取1锁");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("1 尝试获取2锁");
                    synchronized (lock2) {
                        System.out.println("1 已经获取2锁");
                    }
                }

            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                System.out.println("2 开始获取2锁");
                synchronized (lock2) {
                    System.out.println("2 获取2锁");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("2 尝试获取1锁");
                    synchronized (lock1) {
                        System.out.println("2 已经获取1锁");
                    }
                }

            }
        });
        thread1.start();
        thread2.start();
        Thread.sleep(10000);
    }

    public int help(String productId, String helpUserId, String userId) {
        /**
         * 1、判断helpUserId是否已经砍过，否则加入redis，并进行第二部操作，是返回code，良好提示
         * 2、利用redis decr函数进行递减，若<0.良好提示，否则返回砍价后的价格
         */
        return 0;

    }

}
