import java.util.HashSet;

/**
 * 排序，逐个检查
 */
public class Solution3 {
    public boolean containsDuplicate(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            boolean success = set.add(num);
            if(!success){
                return true;
            }
        }
        return false;
    }
}
