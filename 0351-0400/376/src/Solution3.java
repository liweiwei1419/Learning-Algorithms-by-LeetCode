// 根据 Solution2 而来，是一种更少空间复杂度的写法
public class Solution3 {

    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }

    public static void main(String[] args) {
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        Solution3 solution3 = new Solution3();
        int wiggleMaxLength = solution3.wiggleMaxLength(nums);
        System.out.println(wiggleMaxLength);
    }
}
