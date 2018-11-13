+ 这是一道典型的动态规划问题，并且还是二维的动态规划问题
+ 而且这个状态还比较难想，要结合具体的例子才能找到状态转移方程
+ 首先要注意到最特殊的情况：当 t == "" 为 true 的时候，不论 s 是什么，s 都有一个子串（那就是空字符串）能和此时的 t 匹配。
+ 因此 `dp[i][0] = 1`，所以 `0` 这个位置就被占据了，这就是为什么 dp 要设置成 `dp[slen + 1][tlen + 1]` 的原因。


参考资料：
https://leetcode.com/problems/distinct-subsequences/discuss/37320/Java-.
https://www.cnblogs.com/higerzhang/p/4133793.html
https://www.jianshu.com/p/510906b900ec