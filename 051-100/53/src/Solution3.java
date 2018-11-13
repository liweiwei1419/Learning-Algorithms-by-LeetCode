public class Solution3 {

    /**
     * 使用分治算法完成计算
     * https://www.geeksforgeeks.org/divide-and-conquer-maximum-sum-subarray/
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        return maxSubArraySum(nums, 0, len - 1);
    }

    /**
     * 一定会包含 nums[mid] 这个元素
     *
     * @param nums
     * @param l
     * @param m
     * @param r
     * @return
     */
    private int maxCrossingSum(int[] nums, int l, int m, int r) {
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        // 左半边包含 nums[mid] 元素，最多可以到什么地方
        // 走到最边界，看看最值是什么
        // 计算以 mid 结尾的最大的子数组的和
        for (int i = m; i >= l; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        // 右半边不包含 nums[mid] 元素，最多可以到什么地方
        // 计算以 mid+1 开始的最大的子数组的和
        for (int i = m + 1; i <= r; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;

    }

    /**
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private int maxSubArraySum(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        int mid = l + (r - l) / 2;
        return max3(maxSubArraySum(nums, l, mid),
                maxSubArraySum(nums, mid + 1, r),
                maxCrossingSum(nums, l, mid, r));
    }

    private int max3(int num1, int num2, int num3) {
        return Math.max(num1, Math.max(num2, num3));
    }
}