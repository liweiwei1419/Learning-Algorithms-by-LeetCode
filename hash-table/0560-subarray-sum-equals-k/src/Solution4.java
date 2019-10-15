import java.util.HashMap;
import java.util.Map;

/**
 * @author liweiwei1419
 * @date 2019/9/20 12:21 下午
 */
public class Solution4 {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> hash = new HashMap<>();
        hash.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            if (hash.containsKey(sum - k)) {
                count += hash.get(sum - k);
            }
            hash.put(sum, hash.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
