public class Solution3 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int j = 0;
        int i = 1;

        for (; i < nums.length; i++) {
            if (nums[i] == nums[j]) {
                // 什么都不做
            } else {
                nums[++j] = nums[i];
            }
        }
        // 返回的是数组的长度，所以要 + 1
        return j + 1;
    }
}
