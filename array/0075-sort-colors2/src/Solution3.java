/**
 * @author liweiwei1419
 * @date 2019/10/12 11:42 上午
 */
public class Solution3 {

    /**
     * 循环不变量：
     * all in [0, zero) = 0
     * all in [zero, i) = 1
     * all in [two, len - 1] = 2
     * 初始化的时候：zero = 0，two = len
     * 结束的时候，i = two
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        int zero = 0;
        int two = len;
        // 循环结束的时候 i = two + 1
        for (int i = 0; i < two; ) {
            if (nums[i] == 0) {
                swap(nums, i, zero);
                zero++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                // assert nums[i] == 2;
                two--;
                swap(nums, i, two);
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
