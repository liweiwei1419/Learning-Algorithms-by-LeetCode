import java.util.HashSet;
import java.util.Set;

// https://leetcode-cn.com/problems/contains-duplicate/description/
public class Solution {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // write your code here

        Solution solution = new Solution();
        int[] nums = new int[0];
        boolean containsDuplicate = solution.containsDuplicate(nums);
        System.out.println(containsDuplicate);
    }
}
