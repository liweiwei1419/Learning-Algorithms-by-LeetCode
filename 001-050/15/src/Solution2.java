import java.util.*;

/**
 * https://leetcode-cn.com/problems/3sum/description/
 */
public class Solution2 {


    // 时间复杂度 : O(n^2);
    // 空间复杂度 : O(n);

    /**
     * Edward 老师提供的解法
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            // 避免 {-1, -1, -1, 1, 2, 3, 4} 这种情况出现
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int low = i + 1;
            int high = len - 1;
            int target = -nums[i];
            while (low < high) {
                int sum = nums[low] + nums[high];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    // 处理特例 int[] nums = {-2, 0, 0, 2, 2};
                    while (low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }
                    while (low < high && nums[high] == nums[high - 1]) {
                        high--;
                    }
                    low++;
                    high--;
                } else if (sum < target) {
                    low++;
                } else {
                    high--;
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
