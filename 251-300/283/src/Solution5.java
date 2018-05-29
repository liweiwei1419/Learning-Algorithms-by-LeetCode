package leetcode.q283;


import java.util.Arrays;

/**
 * Created by liwei on 17/9/19.
 */
public class Solution5 {
    /**
     * i 用于遍历
     * 在区间 [0,j] 里，所有的值都非零
     * 而在区间 [j+1,i) 里，所有的值都为零
     * 初始化的时候 j = -1 ， i = 0
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int j = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, ++j);
            }
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        if (index1 == index2) return;
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
