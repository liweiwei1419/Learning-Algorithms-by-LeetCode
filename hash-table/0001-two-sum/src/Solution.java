import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (map.containsKey(target - nums[i])) {
                Integer pre = map.get(target - nums[i]);
                return new int[]{pre, i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("找不到两数之和等于 target");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        Solution solution = new Solution();
        int[] res = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
