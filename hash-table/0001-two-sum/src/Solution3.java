/**
 * @author liwei
 * @date 2019/8/26 10:59 PM
 */
public class Solution3 {

    // 暴力解法，时间复杂度 O(N^2)

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        // 最后一位不要遍历，因为它的后面已经没有元素了
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
