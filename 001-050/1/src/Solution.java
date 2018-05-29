import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    // [2,7,11,15]
    // https://leetcode-cn.com/problems/two-sum/description/
    // 一开始可能想不到，看了这道题的标准解法以后，印象就很深了。
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {// 找到了解
                result[1] = i;
                result[0] = map.get(target - nums[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // write your code here
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] twoSum = new Solution().twoSum(nums, target);
        System.out.println(Arrays.toString(twoSum));


    }
}
