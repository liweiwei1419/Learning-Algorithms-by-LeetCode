import java.util.Arrays;

/**
 * @author liwei
 * @date 18/7/2 下午3:18
 */
public class Solution3 {

    // 特别要注意边界条件的判断

    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        // 定义
        // [0,l) 都等于 0
        // [l,i) 都等于 1
        // [r,len) 都等于 2
        int l = 0;

        // 初始值 r 在边界外，所以交换完 r 之后，r 的情况我们是已经知道的
        int r = len;
        int i = 0;
        while (i < r) {
            if (nums[i] == 0) {
                // 交换
                swap(nums, l, i);
                l++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                assert nums[i] == 2;
                r--;
                swap(nums, i, r);
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 1};
        Solution3 solution3 = new Solution3();
        solution3.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
