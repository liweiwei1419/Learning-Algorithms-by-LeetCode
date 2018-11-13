import java.util.HashSet;

/**
 * 使用 hash 表进行检查
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
            } else {
                return true;
            }
        }
        return false;
    }
}
