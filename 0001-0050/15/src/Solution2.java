import java.util.*;

/**
 * https://leetcode-cn.com/problems/3sum/description/
 */
public class Solution2 {


    // 时间复杂度 : O(n^2);
    // 空间复杂度 : O(n);

    /**
     * 双指针
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        // 特判
        if (len < 3) {
            return res;
        }
        // 排序是前提、关键
        Arrays.sort(nums);

        for (int i = 0; i < len - 2; i++) {
            // 剪枝：避免 {-1, -1, -1, 1, 2, 3, 4} 这种情况出现
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = len - 1;
            int target = -nums[i];
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 处理特例 int[] nums = {-2, 0, 0, 2, 2};
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] nums = {-2, 0, 0, 2, 2};
        List<List<Integer>> threeSum = solution2.threeSum(nums);
        System.out.println(threeSum);
    }
}
