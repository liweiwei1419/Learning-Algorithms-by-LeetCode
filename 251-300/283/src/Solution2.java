package leetcode.q283;


import java.util.Arrays;

/**
 * Created by liwei on 17/9/19.
 */
public class Solution2 {
    public void moveZeroes(int[] nums) {
        int i = 0;// 数组元素中非 0 元素的起始索引，每次遍历到就 + 1
        int j = nums.length - 1; // 数组中 0 元素的起始索引，每次遍历到就 -1

        for (int k = 0; k < nums.length; k++) {
            if (nums[k] == 0) {
                swap(nums, k, j);
                j--;
            } else { // nums[k] != 0
                swap(nums, k, i);
                i++;
            }
            if (i == j - 1) break;
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
        Solution2 solution = new Solution2();
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

    }
}
