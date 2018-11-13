---
title: leetcode 80. Remove Duplicates from Sorted Array II
date: 2017-09-23 11:51:02
tags:
---


# LeetCode 80. Remove Duplicates from Sorted Array II

## 原题重现

{% blockquote LeetCode LeetCode https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/ 80. Remove Duplicates from Sorted Array II %}


Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.


{% endblockquote %}


这个写的比较顺，一下就通过了，但是我的解法只是击败了 35.43% 的选手。
```java
public class Solution {

    /**
     * 如果我们允许重复的元素最多出现两次呢？
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {

        int k = 0;// 从[0,k) 这个区间里的所有元素是一个有序数组，并且重复元素最多出现两次
        int duplicate_time = 0;

        // 首先考虑极端的情况
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        nums[k++] = nums[0];

        if (len == 1) {
            return 1;
        }

        for (int i = 1; i < len; i++) {
            if (nums[i] - nums[i - 1] == 0) {
                duplicate_time++;
                if (duplicate_time < 2) {
                    // 重复次数大于等于 2 次，什么都不做
                    nums[k++] = nums[i];
                }
            } else { // nums[i] - nums[i - 1] > 0
                duplicate_time = 0;
                nums[k++] = nums[i];
            }
        }
        // 把数组的剩余元素赋值为 -1
        for (int i = k; i < len; i++) {
            nums[i] = -1;
        }
        return k;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4};
        Solution solution = new Solution();
        int removeDuplicates = solution.removeDuplicates(arr);
        System.out.println("剩余的数组元素的个数 => " + removeDuplicates);
        System.out.println(Arrays.toString(arr));
    }

}
```