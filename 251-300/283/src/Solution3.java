package leetcode.q283;


import java.util.Arrays;

/**
 * 1,0,3,4,0 遇到 1 什么也不做
 * 1,0,3,4,0 遇到 0 就跳到下一个
 * 1,3,0,4,0 遇到 3 就和 0 交换
 * 1,3,4,0,0 遇到 4 就和 0 交换
 * <p>
 * Created by liwei on 17/9/19.
 */
public class Solution3 {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }

        }
    }


    private void swap(int[] arr, int index1, int index2) {
        if (index1 == index2) return;
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }


    //
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 2, 0, -1, 3};
        Solution3 solution = new Solution3();
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

    }
}
