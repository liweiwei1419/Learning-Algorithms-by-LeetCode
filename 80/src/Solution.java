import java.util.Arrays;

public class Solution {

    // https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/description/
    // 每个元素至多出现 2 次

    // 重复出现 1 次和 2 次的时候什么都不做
    // [0,1,1,1,2,2,2,2,3,3,4]
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int pre = nums[0];
        int duplicate_times = 0;
        // 返回它 + 1
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == pre) {
                duplicate_times++;
                // 重复 1 次的时候，也要赋值
                if (duplicate_times == 1) {
                    j++;
                    nums[j] = pre;
                }
                // 重复 1 次以上的时候，什么都不做
            } else {
                pre = nums[i];
                j++;
                nums[j] = nums[i];
                duplicate_times = 0;
            }
        }
        // 返回要加 1 ，因为要算上第 1 个元素（索引为 0 的那个元素）
        return j + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 2, 2, 2, 2, 3, 3, 4};
        int ret = new Solution().removeDuplicates(nums);
        System.out.println(ret);
        System.out.println(Arrays.toString(nums));
    }
}
