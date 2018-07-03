/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Created by liwei on 17/9/23.
 */
public class Solution2 {

    /**
     * 典型的使用三路快排可以解决的问题
     * <p>
     * 在这个过程中 设置 j 和 r 这两个辅助变量
     * 使得 [0,j) 中所有的元素等于 0 ，遍历过程中 i j 互换，然后 j 加 1 ， i 加 1
     * [j,i) 中所有的元素等于 1 , 遍历过程中， i 加 1 就可以了
     * [r,lenght-1] 中所有的元素等于 2 ，遍历过程中 r 先减1，交换 i 和 r ，注意，此时 i 不加
     * 不用 for 循环，因为不是从头遍历到为，这里采用的是指针碰撞，直到 i 和 r 撞到一起为止
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int i = 0;
        int l = 0;
        int r = nums.length;
        while (i < r) {
            if (nums[i] == 0) {
                swap(nums, i++, l++);
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, --r);
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
