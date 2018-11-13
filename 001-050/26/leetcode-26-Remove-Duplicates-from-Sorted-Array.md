---
title: leetcode 26. Remove Duplicates from Sorted Array
date: 2017-09-23 11:41:18
tags:
- leetcode
- 数组
categories: 
- 算法
- leetcode
---

# LeetCode 26. Remove Duplicates from Sorted Array

## 原题重现

{% blockquote LeetCode https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/ 26. Remove Duplicates from Sorted Array
%}

Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.

{% endblockquote %}

## 题意分析

+ 要求从一个有序的数组中删除重复的元素。
+ 思考如何定义删除？是从数组中删除？还是放在数组的末尾？
+ 剩余元素的排列是否要保证原有的相对顺序？
+ 是否有空间复杂度的要求？
+ 这里也用到了循环不变量的定义，要明确才能正确写出代码逻辑。

## 我的思路

1. 挨个加入到一个 Map 中，判断是否有键值，这个思路没有利用到数组的有序性，故不采纳；
2. 后一个元素减去前一个元素，如果等于0，就说明重复了（我用这种办法）。
```java
public class Solution {

    /**
     * 删除重复的元素，按照 LeetCode 上 Java 对删除数组元素的删除的判定，
     * LeetCode 上的规则就是不判定，只要这个数组前面有效索引上的数是正确的就可以了
     *
     * @param nums
     * @return 不重复的元素个数
     */
    public int removeDuplicates(int[] nums) {
        int k = 0;// 定义 [0,k)是一个没有重复元素的有序数组
        // 从第 1 个元素开始，依次考察前面的元素
        // 特别注意到三个元素连续的情况，例如 [6,6,6,6,7]
        // 判断第 1 个元素该不该进去
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        nums[k++] = nums[0];
        if (len == 1) {
            return 1;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 0) {
                nums[k++] = nums[i];
            }
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = -1;
        }
        return k;
    }

    public static void main(String[] args) {
        //int[] sortedArray = {1, 2};
        //int[] sortedArray = {1, 1};
        int[] sortedArray = {1, 2, 2, 2, 3, 4, 5, 6, 6, 6, 7, 7, 8, 9};
        //int[] sortedArray1 = {1,2,3,2,3,4,5,6,6,6,7,7,8,9};
        Solution solution = new Solution();
        int non_duplicates = solution.removeDuplicates(sortedArray);
        System.out.println("不重复的元素个数有 => " + non_duplicates);
        System.out.println(Arrays.toString(sortedArray));
    }
}
```

## 反思
这一版我写得不好，吃过一次晚饭以后，才得到了 Accepted。总结如下：
1、没有考虑极端的情况；
2、第 1 个元素必须加入到结果数组中；
3、既然我是与前一个元素进行比较，那么我的索引最大值就应该是数组长度-1，边界值问题模糊不清也是我经常犯的错误。

《LeetCode》题解上有新的思路，可以学习一下。