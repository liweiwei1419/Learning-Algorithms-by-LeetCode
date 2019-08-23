import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                res[1] = i;
                res[0] = map.get(target - nums[i]);
            }
        }
        return res;
    }

    public int[] twoSum2(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(target - nums[i])) {
                int[] res = new int[2];
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            } else {
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("给出的数组和 target 不合法！");
    }
}
