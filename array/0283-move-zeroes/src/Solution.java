/**
 * 1,0,3,4,0 遇到 1 什么也不做
 * 1,0,3,4,0 遇到 0 就跳到下一个
 * 1,3,0,4,0 遇到 3 就和 0 交换
 * 1,3,4,0,0 遇到 4 就和 0 交换
 * <p>
 * Created by liwei on 17/9/19.
 */
public class Solution {

    // 我们的约定：
    // 在区间 [0, l) 里，所有的值都非零
    // 而在区间 [l, i) 里，所有的值都为零
    // 初始化的时候 l = 0，所以是交换完以后，指针向后移动

    // [0, 1, 0, 3, 12]
    // [1, 0, 0, 3, 12]
    // [1, 3, 0, 0, 12]
    // [1, 3, 12, 0, 0]

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
