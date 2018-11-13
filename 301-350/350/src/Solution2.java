import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map1.put(nums1[i], map1.containsKey(nums1[i]) ? map1.get(nums1[i]) + 1 : 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map1.containsKey(nums2[i]) && map1.get(nums2[i]) > 0) {
                list.add(nums2[i]);
                map1.put(nums2[i], map1.get(nums2[i]) - 1);
            }
        }
        int[] result = new int[list.size()];
        int i = 0;
        for (int j = 0; j < list.size(); j++) {
            result[i++] = list.get(j);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        // 返回 [2, 2].
        Solution2 solution = new Solution2();
        int[] intersect = solution.intersect(nums1, nums2);
        System.out.println(Arrays.toString(intersect));
    }
}
