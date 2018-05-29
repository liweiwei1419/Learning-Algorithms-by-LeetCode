// https://leetcode-cn.com/problems/combination-sum-iv/description/
public class Solution {

    // 这样写直接就 ac 了，研究一下
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 1; i < target + 1; i++) {
            for (int num : nums) {
                if(i >= num){
                    dp[i] = dp[i] + dp[i - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        // write your code here
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        int target = 4;

        int combinationSum4 = solution.combinationSum4(nums, target);
        System.out.println(combinationSum4);
    }
}
