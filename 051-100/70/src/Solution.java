// https://leetcode-cn.com/problems/climbing-stairs/description/
public class Solution {

    private int[] cache;

    private int calcways(int n) {
        if (cache[n] != 0) {
            return cache[n];
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        cache[n] = calcways(n - 1) + calcways(n - 2);
        return cache[n];
    }

    public int climbStairs(int n) {
        cache = new int[n + 1];
        return calcways(n);
    }

    public static void main(String[] args) {
        // write your code here
        Solution solution = new Solution();
        int climbStairs = solution.climbStairs(2);
        System.out.println(climbStairs);
    }
}
