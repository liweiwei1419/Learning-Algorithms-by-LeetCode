import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 及其简单的一个问题，主要是熟悉 Set 的一个特性，可以去除重复元素。
// https://leetcode-cn.com/problems/intersection-of-two-arrays/description/
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            s1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(s1.contains(nums2[i])){
                // result 中的元素一定唯一
                result.add(nums2[i]);
                s1.remove(nums2[i]);
            }
        }
        int[] s = new int[result.size()];
        int i = 0;
        for(Integer element:result){
            s[i] =element;
            i++;
        }
        return s;
    }

    public static void main(String[] args) {
	// write your code here
        int[] nums1= {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] intersection = new Solution().intersection(nums1, nums2);
        System.out.println(Arrays.toString(intersection));
    }
}
