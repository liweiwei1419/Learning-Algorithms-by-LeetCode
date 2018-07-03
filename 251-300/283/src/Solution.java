/**
 * 快速排序 partition 的思想我认为是最简单的
 */
public class Solution {


    // 在区间 [0, l) 里，所有的值都非零
    // 而在区间 [l, i) 里，所有的值都为零
    // 初始化的时候 l = 0

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        // l 表示下一个填写非零元素的索引
        int l = 0;
        // i 用于遍历
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                swap(nums, l, i);
                l++;
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
