import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/description/
 */
public class Solution2 {

    // nums = [2, 7, 11, 15], target = 9

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                // 找到了解
                res[0] = map.get(target - nums[i]);
                res[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Solution solution = new Solution();
        int[] twoSum = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(twoSum));
    }
}
