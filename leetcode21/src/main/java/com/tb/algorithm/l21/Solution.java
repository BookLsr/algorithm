package com.tb.algorithm.l21;

import com.tb.algorithm.l21.model.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: leetcode 21
 * @Author: WindPursuer
 * @Date 2020/3/7 7:56 PM
 */

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(-1);
        ListNode temp = head;

        /**
         * 采用链表循环，进行设置
         */
        while (l1 != null || l2 != null) {

            if (null == l2 || (null != l1 && l1.val <= l2.val)) {
                head.next = new ListNode(l1.val);
                l1 = l1.next;
                head = head.next;
                continue;
            }

            head.next = new ListNode(l2.val);
            l2 = l2.next;
            head = head.next;


        }
        temp = temp.next;
        return temp;

    }


    public static int[] retainAll(int[] array1, int[] array2) {
        /**
         * 利用Set去重
         */
        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0, j = 0; i < array1.length && j < array2.length;) {
            if (array1[i] < array2[j]) {
                i++;
            }
            if (array1[i] > array2[j]) {
                j++;
            }
            if (array1[i] == array2[j]) {
                set.add(array1[i]);
                i++;
                j++;

            }
        }
        int[] result = new int[set.size()];
        Integer[] integers = set.toArray(new Integer[]{});
        for (int i = 0; i < integers.length; i++) {
            result[i] = integers[i];
        }
        return result;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode head = solution.mergeTwoLists(l1, l2);
        while (head.next != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }
}
