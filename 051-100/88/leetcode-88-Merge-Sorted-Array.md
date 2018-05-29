---
title: leetcode 88. Merge Sorted Array
date: 2017-09-23 15:46:44
tags:
---

88. Merge Sorted Array https://leetcode.com/problems/merge-sorted-array/description/

LeetCode 88：
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.

我的解答：
```java
public class Solution {

    /**
     * @param nums1 一个排好序的数组1
     * @param m
     * @param nums2 一个排好序的数组2
     * @param n     结果放在 nums1 中
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];
        for (int i = 0; i < m; i++) {
            temp[i] = nums1[i];
        }
        for (int i = 0; i < n; i++) {
            temp[m + i] = nums2[i];
        }


        int left = 0; // 数组1的第1个元素
        int right = m; // 数组2的第1个元素

        // 这种特殊情况要考虑进去
        if (m > 0 && n > 0 && temp[m - 1] <= temp[m]) {
            for (int i = 0; i < m + n; i++) {
                nums1[i] = temp[i];
            }
            return;
        }

        // 要赋值完 m+n 个元素，就要遍历 m+n 个元素
        for (int i = 0; i < m + n; i++) {
            if (left >= m) { // 如果左边用完了，就一直拿右边的元素
                nums1[i] = temp[right];
                right++;
            } else if (right >= m + n) {
                nums1[i] = temp[left];
                left++;
            } else if (temp[left] < temp[right]) {
                nums1[i] = temp[left];
                left++;
            } else { // temp[left] >= temp[right]
                nums1[i] = temp[right];
                right++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        int[] nums2 = {5, 6, 7, 8, 9};

        Solution solution = new Solution();
        solution.merge(nums1, 5, nums2, 5);
        System.out.println(Arrays.toString(nums1));

    }

}
```