/**
 * @author liweiwei1419
 * @date 2019/10/12 12:57 下午
 */
public class Solution5 {
    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        // all in [0, zero] = 0
        // all in (zero, i) = 1
        // all in [two, len - 1] = 2
        int zero = -1;
        int two = len;
        // end: i = two
        for (int i = 0; i < two; ) {
            if (nums[i] == 0) {
                zero++;
                swap(nums, i, zero);
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                // nums[i] == 2
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
