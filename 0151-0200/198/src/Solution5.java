/**
 * 加入了记忆化搜索的递归
 * Created by liwei on 17/10/3.
 */
public class Solution5 {

    private int[] memory;

    public int rob(int[] nums) {
        int len = nums.length;
        memory = new int[len + 1];

        for (int i = 0; i < len + 1; i++) {
            memory[i] = -1;
        }
        return getRob(nums, 0);
    }

    // 状态的定义：[i,...,n-1] 这个些个房屋中能够偷取的宝物总和的最大值
    // 有最大，一般就有一个遍历的过程
    private int getRob(int[] nums, int start) {
        int max = -1;
        int len = nums.length;
        if (start >= nums.length) {
            return 0;
        }
        if (memory[start] == -1) {
            for (int i = start; i < len; i++) {
                max = Integer.max(max, nums[i] + getRob(nums, i + 2));
            }
            memory[start] = max;
        }
        return memory[start];
    }
}
