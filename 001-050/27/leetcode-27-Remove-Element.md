---
title: leetcode 27. Remove Element
date: 2017-09-17 16:34:41
tags:
- leetcode
categories: 
- 算法
- leetcode
---


# LeetCode 27. Remove Element

## 原题重现

{% blockquote LeetCode https://leetcode.com/problems/remove-element/description/ 27. Remove Element %}

Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate（分配） extra space for another array, you must do this in place with constant（不变的） memory（内存）.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.

{% endblockquote %}

## 题意分析

就这道问题，我们要考虑的问题是：
+ 如何定义删除？从数组中删除？还是放在数组的末尾？
+ 剩余元素的排列是否要保证原来的相对顺序？
+ 是否有空间复杂度的要求？

我的解答：有瑕疵，因为在 Java 中数组的长度是固定的。在这个函数中不能移除 Java 数组中的元素。但是居然在 LeetCode 中通过了。
```java
public class Solution {

    // Given input array nums = [3,2,2,3], val = 3

    /**
     * 题目的要求中说，顺序可以改变
     * 不管怎么样，先写出来最要紧
     * 难点：Java 中的数组元素怎么删除，这里我没有实现
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        Solution solution = new Solution();
        int removeElementNum = solution.removeElement(nums, val);
        System.out.println(removeElementNum);
        System.out.println(Arrays.toString(nums));
    }
}
```

## 第 2 遍解答，其实本质上是一样的

### 思路分析

对题目的说明：在一个数组里面移除指定元素，并返回新的数组的长度。
解题思路：给出两个指针 i 和 j，其中 i 就想我们平常遍历数组元素一样，是一个普通的循环遍历。
和 j 就像是一支笔，我们要借助这支笔，往一个新数组里面写数据。
只不过，根据题意，我们恰恰好可以利用原来的数组的空间，这是因为，我们的任务是 Remove Element，新数组的元素个数一定不会超过原数组的元素个数。

### 代码实现
```java
public class Solution {

    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;
        for (; i < nums.length; i++) {
            if(nums[i]==val){
                continue;
            }
            nums[j] = nums[i];
            // 只要遇到与 val 不等的元素，就累加 1
            // 所以，直接返回 j 就可以了
            j++;
        }
        return j;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.removeElement(new int[]{3,2,2,3},2);
        System.out.println(result);
    }
}
```


