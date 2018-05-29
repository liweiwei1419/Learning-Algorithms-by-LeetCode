import java.util.*;

// https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/description/
public class Solution2 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[list.size()];
        int l=0;
        for (int k = 0; k < list.size(); k++) {
            result[l++] = list.get(k);
        }
        return result;
    }

    public static void main(String[] args) {
        // write your code here
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2}; // 返回 [2, 2].
        Solution2 solution = new Solution2();
        int[] intersect = solution.intersect(nums1, nums2);
        System.out.println(Arrays.toString(intersect));
    }
}
