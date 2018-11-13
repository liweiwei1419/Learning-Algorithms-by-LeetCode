package leetcode.q349;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by liwei on 17/9/13.
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }


        int[] result = new int[set2.size()];

        int index = 0;
        for (int num : set2) {
            result[index++] = num;
        }

        return result;
    }
}