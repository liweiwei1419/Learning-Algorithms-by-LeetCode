/**
 * 1,0,3,4,0 遇到 1 什么也不做
 * 1,0,3,4,0 遇到 0 就跳到下一个
 * 1,3,0,4,0 遇到 3 就和 0 交换
 * 1,3,4,0,0 遇到 4 就和 0 交换
 * <p>
 * Created by liwei on 17/9/19.
 */
public class Solution3 {

    // https://leetcode-cn.com/problems/move-zeroes/description/
    // [0, 1, 0, 3, 12]
    // [1, 0, 0, 3, 12]
    // [1, 3, 0, 0, 12]
    // [1, 3, 12, 0, 0]
    // 常规题：用思维定势就可以完成


    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, j);
                j++;
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
}
