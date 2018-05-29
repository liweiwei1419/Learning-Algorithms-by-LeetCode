---
title: leetcode 215. Kth Largest Element in an Array
date: 2017-09-23 15:47:13
tags:
---


215. Kth Largest Element in an Array https://leetcode.com/problems/kth-largest-element-in-an-array/description/

LeetCode 215：

Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.

我的解答：
```java
public class Solution {

    /**
     * 给定任意一个数组，返回第 k 大的元素，并非索引
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int p = 0;

        int left = 0;
        int right = len - 1;
        while (left <= right) {
            p = partition(nums, left, right);
            if (len - p == k) {
                break;
            } else if (len - p + 1 > k) {
                left = p + 1;
            } else {
                right = p - 1;
            }
        }
        return nums[p];
    }

    /**
     * 4,3,7,8
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] nums, int left, int right) {
        // 就找第 1 个元素作为标定点
        int k = nums[left];

        int i = left + 1; // [left,i)小于 k
        int j = right; // (j,right]大于 k

        for (int l = left + 1; i <= j; l++) {
            if (nums[l] < k) {
                i++;
            } else {//nums[l]>=k
                swap(nums, l, j--);
                l--;
            }

        }
        i--;
        swap(nums, i, left);
        return i;
    }


    private void swap(int[] data, int index1, int index2) {
        if (index1 == index2) return;
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }


    public static void main(String[] args) {
        int[] data = {3, 2, 1, 5, 6, 4};
        int k = 2;
        Solution solution = new Solution();

        solution.partition(data, 2, 4);
        int kthLargest = solution.findKthLargest(data, k);
        System.out.println("kthLargest = >" + kthLargest);
    }
}
```