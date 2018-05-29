package leetcode.q283;


import java.util.Arrays;

/**
 * Created by liwei on 17/9/19.
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;// 遍历指针
        int j = 0;// 一开始都写非零元素，然后都写零元素

        for (; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (int k = j; k < nums.length; k++) {
            nums[k] = 0;
        }

    }


    //
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 2, 0, -1, 3};
        Solution solution = new Solution();
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

    }
}
