import java.util.Arrays;

// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/description/
// 常规题目：这里利用到数组的有序性，如果遇到和上一个一样的元素，就什么都不做

public class Solution {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int pre = nums[0];
        int l = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] != pre) {
                // 注意顺序：先更新值，再递增脚标
                pre = nums[i];
                nums[l] = nums[i];
                l++;
            }
        }
        // 注意 l 是遍历到的与之前不同元素的个数，要把第 1 个元素算进去，所以要加 1
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 3, 4, 4, 4};
        Solution solution = new Solution();
        int ret = solution.removeDuplicates(nums);
        System.out.println(ret);
        System.out.println(Arrays.toString(nums));
    }
}
