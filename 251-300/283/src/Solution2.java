/**
 * 有点双路快速排序的意思
 * 0, 1, 0, 2, 0, -1, 3 i=0,j=6,k=0
 * 3, 1, 0, 2, 0, -1, 0 i=0,j=5,k=1
 * 1, 3, 0, 2, 0, -1, 0 i=1,j=5,k=2
 * 1, 3, -1, 2, 0, 0, 0 i=1,j=4,k=3
 * 1, 2, -1, 3, 0, 0, 0 i=2,j=4,k=4
 * 1, 2, -1, 3, 0, 0, 0 i=2,j=3,k=5
 */
public class Solution2 {

    // 指针对撞
    public void moveZeroes(int[] nums) {
        // 数组元素中非 0 元素的起始索引，每次遍历到就 + 1
        int l = 0;
        // 数组中 0 元素的起始索引，每次遍历到就 -1
        int r = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, r);
                r--;
            } else { // nums[i] != 0
                swap(nums, i, l);
                l++;
            }
            if (l == r - 1) {
                break;
            }
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
