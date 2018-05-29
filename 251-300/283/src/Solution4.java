package leetcode.q283;


import java.util.Arrays;

/**
 * 有点双路快速排序的意思
 * 0, 1, 0, 2, 0, -1, 3 i=0,j=6,k=0
 * 3, 1, 0, 2, 0, -1, 0 i=0,j=5,k=1
 * 1, 3, 0, 2, 0, -1, 0 i=1,j=5,k=2
 * 1, 3, -1, 2, 0, 0, 0 i=1,j=4,k=3
 * 1, 2, -1, 3, 0, 0, 0 i=2,j=4,k=4
 * 1, 2, -1, 3, 0, 0, 0 i=2,j=3,k=5
 * Created by liwei on 17/9/19.
 */
public class Solution4 {
    public void moveZeroes(int[] nums) {
        int i = 0;// 数组元素中非 0 元素的起始索引，每次遍历到就 + 1
        int j = nums.length - 1; // 数组中 0 元素的起始索引，每次遍历到就 -1

        for (int k = 0; k < nums.length; k++) {
            System.out.println(Arrays.toString(nums));
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
        Solution4 solution = new Solution4();
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

    }
}
