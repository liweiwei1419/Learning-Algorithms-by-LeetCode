import java.util.Arrays;


public class Solution {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int next = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[next]) {
                // 注意顺序：先更新值，再递增脚标
                next++;
                nums[next] = nums[i];
            }
        }
        return next + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 3, 4, 4, 4};
        Solution solution = new Solution();
        int ret = solution.removeDuplicates(nums);
        System.out.println(ret);
        System.out.println(Arrays.toString(nums));
    }
}
