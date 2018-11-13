/**
 * 连续子数组的最大和问题
 * 53. 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/description/
 *
 * @author liwei
 */
public class Solution2 {

    /**
     * 和 Solution 一样，空间复杂度更小
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int segmentSum = nums[0];
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            segmentSum = Math.max(nums[i], segmentSum + nums[i]);
            res = Math.max(res, segmentSum);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Solution2 solution = new Solution2();
        int maxSubArray = solution.maxSubArray(nums);
        System.out.println(maxSubArray);
    }
}