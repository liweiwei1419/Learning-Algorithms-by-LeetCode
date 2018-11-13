---
title: leetcode 93. Restore IP Addresses
date: 2017-09-28 13:05:18
description: 给出一个数字字符串，为这个数字字符串加上三个点（.），使其成为一个合法的IP地址，返回所有的合法的 IP 地址。
tags:
- leetcode
- 递归
- 回溯
- 树形问题
- 算法
categories: 
- 算法
- leetcode
---

# leetcode 93. Restore IP Addresses

## 原题再现

{% blockquote LeetCode https://leetcode.com/problems/restore-ip-addresses/description/ 93. Restore IP Addresses %}

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

{% endblockquote %}

#### 题目大意
给出一个数字字符串，为这个数字字符串加上三个点（.），使其成为一个合法的IP地址，返回所有的合法的 IP 地址。
#### 补充说明
- 如给定字符串 "25525511135",
- 返回 ["255.255.11.135", "255.255.111.35"]



我们再想想，我们递归到底，无非就是给一串数字加上三个"."，不管能不能成为 IP ，分割次数增加和之前的 IP 段积累我们都有操作，只不过没有成为 IP 地址的 list 最后没有被 result 收进去，递归走到底之后，我们都应该把分割次数减少，并且把 IP 段积累恢复。

#### 我的解答


#### 总结
- 这里要注意一些细节：1、通过完善测试用例的方式来发现一些坑；2、提交给 LeetCode ，就可以发现一些自己可能没有想到的情况；
- 第 1 遍写出来的代码肯定是有诸多问题的，需要一些耐心，打印一些输出语句，来分析程序的走向。
- 树形问题使用回溯算法的一个套路是：在循环中使用递归，状态在递归前后进行恢复。
