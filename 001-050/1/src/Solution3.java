import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author liwei
 * @date 18/7/2 下午1:51
 */
public class Solution3 {

    public int[] twoSum(int[] nums, int target) {
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
