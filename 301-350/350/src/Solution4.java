package leetcode.q350;

import java.rmi.MarshalledObject;
import java.util.*;

/**
 * Created by liwei on 17/9/13.
 */
class Solution {


    public int[] intersect(int[] nums1, int[] nums2) {


        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            if (map1.containsKey(num)) {
                map1.put(num, map1.get(num) + 1);
            } else {
                map1.put(num, 1);
            }
        }


        List<Integer> resultList = new ArrayList<Integer>();

        for (int num : nums2) {

            if (map1.containsKey(num) && map1.get(num) >= 1) {
                resultList.add(num);
                map1.put(num, map1.get(num) - 1);
            }
        }


        int[] result = new int[resultList.size()];

        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;


    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        Solution solution = new Solution();
        int[] result = solution.intersect(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}
