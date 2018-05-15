// 自顶向下记忆化搜索
// https://leetcode-cn.com/problems/integer-break/description/
public class Solution {

    private int[] cache;

    private int maxBreak(int n) {
        if (n == 2) {
            return 1;
        }
        if(cache[n]!=0){
            return cache[n];
        }
        int max = 0;
        for (int i = 1; i < n - 1; i++) {
            max = max3(i * maxBreak(n - i), i * (n - i), max);
        }
        max = Integer.max(max, n - 1);
        cache[n] = max;
        return max;
    }

    private int max3(int a, int b, int c) {
        return Integer.max(Integer.max(a, b), c);
    }


    public int integerBreak(int n) {
        if (n < 2) {
            return 0;
        }
        cache = new int[n+1];
        return maxBreak(n);
    }

    public static void main(String[] args) {
        // write your code here

        Solution s = new Solution();
        int maxBreak = s.integerBreak(10);
        System.out.println(maxBreak);
    }
}
