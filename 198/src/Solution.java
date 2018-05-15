// https://leetcode-cn.com/problems/house-robber/description/
public class Solution {

    private int[] cache;

    // 考虑偷取从 begin 开始的所有物品的最大价值
    private int tryRob(int[] nums, int begin) {
        if (begin >= nums.length) {
            return 0;
        }
        if (cache[begin] != -1) {
            return cache[begin];
        }
        int res = 0;
        for (int i = begin; i < nums.length; i++) {
            res = Integer.max(res, nums[i] + tryRob(nums, i + 2));
        }
        cache[begin] = res;
        return res;
    }

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        cache = new int[len];
        // 初值为 -1 很重要，不能为 0，因为房屋内的宝物价值很有可能为 0
        for (int i = 0; i < len; i++) {
            cache[i] = -1;
        }
        return tryRob(nums, 0);
    }

    public static void main(String[] args) {
        // write your code here

        int[] nums = {1, 2, 3, 1};
        // int[] nums = {2, 7, 9, 3, 1};
        //int[] nums = {1,2};
        Solution solution = new Solution();
        int rob = solution.rob(nums);
        System.out.println(rob);
    }
}
