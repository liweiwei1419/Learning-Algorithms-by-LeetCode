import java.util.Arrays;

/**
 * 这道题和二分查找没有什么关系，就是双指针对撞
 */
public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if (len < 3) {
            throw new IllegalArgumentException("参数错误");
        }
        // 初始化

        int diff = Integer.MAX_VALUE;
        int res = nums[0] + nums[1] + nums[len - 1];
        // 排序很关键
        Arrays.sort(nums);
        // len-3 len-2 len-1
        for (int i = 0; i < len - 2; i++) {
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    assert sum == target;
                    return target;
                }
                if (Math.abs(sum - target) < diff) {
                    diff = Math.abs(sum - target);
                    res = sum;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        Solution solution = new Solution();
        int threeSumClosest = solution.threeSumClosest(nums, target);
        System.out.println(threeSumClosest);
    }
}