/**
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/description/
 * 这是最容易想到的解法，使用滑动窗口
 *
 * @author liwei
 */
public class Solution {

    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int l = 0;
        int r = -1;
        // 注意1：既然是求最小的长度，初始值应该设置成一个不可能达到的上限
        int minSubArrayLen = len + 1;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            r++;
            // 注意2：这里的 = 号不要忘记了
            while (sum >= s) {
                minSubArrayLen = Integer.min(minSubArrayLen, r - l + 1);
                sum -= nums[l];
                l++;
            }
        }
        // 如果全部数组元素加起来都 <s ，即 minSubArrayLen 的值没有被更新，根据题意，返回 0
        if (minSubArrayLen == len + 1) {
            return 0;
        }
        return minSubArrayLen;
    }

    // 与上面的写法相同，只是边界条件设置不一样
    public int minSubArrayLen1(int s, int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int l = 0;
        int r = 0;
        int minSubArrayLen = len + 1;
        int segmentSum = 0;
        for (int num : nums) {
            segmentSum += num;
            r++;
            // 注意：根据题意"找出该数组中满足其和 ≥ s 的长度最小的子数组"
            // 注意这个边界条件
            while (segmentSum >= s) {
                minSubArrayLen = Integer.min(minSubArrayLen, r - l);
                segmentSum -= nums[l];
                l++;
            }
        }
        if (minSubArrayLen == len + 1) {
            return 0;
        }
        return minSubArrayLen;
    }

    // 3 种写法本质上都是一样：滑动窗口
    public int minSubArrayLen2(int s, int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int l = 0;
        int segmentSum = 0;
        int minSubArrayLen = len + 1;
        for (int i = 0; i < len; i++) {

            segmentSum += nums[i];
            while (segmentSum >= s) {
                minSubArrayLen = Integer.min(minSubArrayLen, i - l + 1);
                segmentSum -= nums[l];
                l++;
            }
        }
        if (minSubArrayLen == len + 1) {
            return 0;
        }
        return minSubArrayLen;
    }

    public static void main(String[] args) {
        int s = 15;
        int[] nums = {1, 2, 3, 4, 5};
        Solution solution = new Solution();
        int minSubArrayLen = solution.minSubArrayLen(s, nums);
        System.out.println(minSubArrayLen);
    }
}
