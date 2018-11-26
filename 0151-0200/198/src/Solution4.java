/**
 * 没有记忆化搜索的递归，提交到 LeetCode 上不能通过
 * Submission Result: Time Limit Exceeded
 * Created by liwei on 17/10/3.
 */
public class Solution4 {

    public int rob(int[] nums) {
        // 针对特殊情况应该首先考虑到
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return getRob(nums, 0);
    }

    // 状态的定义：[i,...,n-1] 这个些个房屋中能够偷取的宝物总和的最大值
    // 有最大，一般就有一个遍历的过程
    private int getRob(int[] nums, int start) {
        // 递归终止条件
        if (start >= nums.length) {
            return 0;
        }
        int max = -1;
        int len = nums.length;
        // i 应该从 start 这个位置开始！
        for (int i = start; i < len; i++) {
            max = Integer.max(max, nums[i] + getRob(nums, i + 2));
        }
        return max;
    }
}
