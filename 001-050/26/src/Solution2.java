
// 这种写法更简洁一些
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

}
