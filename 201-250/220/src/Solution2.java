import java.util.TreeSet;

public class Solution2 {

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
            Long floor = set.floor((long) nums[i] + t);
            Long ceiling = set.ceiling((long) nums[i] - t);
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
        int[] nums = {1, 5, 9, 1, 5, 9};
        int k = 2;
        int t = 3;
        Solution2 solution2 = new Solution2();
        boolean containsNearbyAlmostDuplicate = solution2.containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println(containsNearbyAlmostDuplicate);
    }
}
