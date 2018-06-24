import java.util.TreeSet;

// https://leetcode-cn.com/problems/contains-duplicate-iii/description/
public class Solution {

    /**
     * 10             20     30   ,t = 3
     * 12   15  18
     * 15  18     21
     *
     * @param nums
     * @param k    k 是索引之间的最大差值
     * @param t    是两个数值之间的最大差值
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long floor = set.floor((long) nums[i] + t); // floor 表示地板函数
            Long ceiling = set.ceiling((long) nums[i] - t); // ceiling 表示天花板
            if ((floor != null && floor >= nums[i]) || (ceiling != null && ceiling <= nums[i])) {
                return true;
            }
            set.add((long) nums[i]);

            if (set.size() == (k + 1)) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // write your code here

        int[] nums = {2, 2};
        int k = 3;
        int t = 0;
        Solution solution = new Solution();
        boolean containsNearbyAlmostDuplicate = solution.containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println(containsNearbyAlmostDuplicate);
    }
}
