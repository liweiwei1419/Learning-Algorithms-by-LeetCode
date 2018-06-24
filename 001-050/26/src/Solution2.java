import java.util.Arrays;

public class Solution2 {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int j = 0;
        int i = 1;
        for (; i < len; i++) {
            if (nums[i] == nums[j]) {
                // 什么都不做
            } else {
                nums[++j] = nums[i];
            }
        }
        // 返回的是数组的长度，所以要 + 1
        return j + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // int[] nums = new int[]{1,1,1,2,2,2,3,3,3,4,5,6,7,7,7,8,9,10,10};
        int[] nums = new int[]{1};
        int result = solution.removeDuplicates(nums);
        System.out.println(result);
        System.out.println(Arrays.toString(nums));
    }
}
