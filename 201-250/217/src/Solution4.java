import java.util.HashSet;
import java.util.Set;

// https://leetcode-cn.com/problems/contains-duplicate/description/
public class Solution4 {

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
        Solution4 solution4 = new Solution4();
        int[] nums = new int[0];
        boolean containsDuplicate = solution4.containsDuplicate(nums);
        System.out.println(containsDuplicate);
    }
}
