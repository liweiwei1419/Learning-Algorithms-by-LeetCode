import java.util.Arrays;

/**
 * @author liwei
 * @date 18/7/2 下午1:21
 */
public class Solution4 {

    public void moveZeroes(int[] nums) {
        // 遍历指针
        int i = 0;
        // 一开始都写非零元素，然后都写零元素
        int j = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (int k = j; k < nums.length; k++) {
            nums[k] = 0;
        }
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();

        int[] nums = {0,1,0,3,12};
        solution4.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

    }
}
