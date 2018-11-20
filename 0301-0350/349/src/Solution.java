import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 极其简单的一个问题，主要是熟悉 Set 的一个特性，判断是否存在重复元素。
// https://leetcode-cn.com/problems/intersection-of-two-arrays/description/

public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                set2.add(nums2[i]);
            }
        }
        int[] result = new int[set2.size()];
        int i = 0;
        for (Integer num : set2) {
            result[i++] = num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] intersection = new Solution().intersection(nums1, nums2);
        System.out.println(Arrays.toString(intersection));
    }
}
