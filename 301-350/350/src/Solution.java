import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/description/
 */
public class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int e : nums1) {
            if (map.containsKey(e)) {
                map.put(e, map.get(e) + 1);
            } else {
                map.put(e, 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int e : nums2) {
            if (map.containsKey(e) && map.get(e) >= 1) {
                result.add(e);
                map.put(e, map.get(e) - 1);
            }
        }
        int[] s = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            s[i] = result.get(i);
        }
        return s;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};

        int[] nums2 = {2, 2};
        // 返回 [2, 2].
        Solution solution = new Solution();
        int[] intersect = solution.intersect(nums1, nums2);
        System.out.println(Arrays.toString(intersect));
    }
}
