import java.util.HashMap;
import java.util.Map;

/**
 * 这道题的解法很多，可以帮助我们开阔视野
 * 可以参考花花酱的视频：http://zxi.mytechroad.com/blog/divide-and-conquer/leetcode-169-majority-element/
 * 方法1：使用 Hash 表统计每个数出现的次数，只要这个次数大于总数的一半，就可以将这个数返回了
 */
public class Solution {

    /**
     * [0,1,2,3]
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int half = len / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.get(num);
            if (count == null) {
                map.put(num, 1);
            } else {
                // 反正都是要 + 1 的
                if (count + 1 > half) {
                    return num;
                }
                map.put(num, count + 1);
            }
        }
        throw new RuntimeException("数组中不存在众数！");
    }

    public static void main(String[] args) {
        int[] nums = {5, 6, 6};
        Solution solution = new Solution();
        int majorityElement = solution.majorityElement(nums);
        System.out.println(majorityElement);
    }
}
