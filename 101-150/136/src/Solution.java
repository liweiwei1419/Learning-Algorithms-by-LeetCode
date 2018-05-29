// https://leetcode-cn.com/problems/single-number/description/
// 136. 只出现一次的数字
public class Solution {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        Solution solution = new Solution();
        int singleNumber = solution.singleNumber(nums);
        System.out.println(singleNumber);
    }
}
