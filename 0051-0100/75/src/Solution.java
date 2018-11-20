import java.util.Arrays;

// https://leetcode-cn.com/problems/sort-colors/description/

public class Solution {

    // 注意边界条件的判断

    // 常规题：用三路快排的思想就可以完成
    // 输入: [2,0,2,1,1,0]
    // 输出: [0,0,1,1,2,2]

    // [2,0,2,1,1,0]
    // [0,0,2,1,1,2]
    // [0,0,2,1,1,2]
    // [0,0,1,1,2,2]
    // 2 的时候，移到末尾，注意，此时循环变量不动
    // 1 的时候不动
    // 0 的时候，移动到 1 的前面

    public void sortColors(int[] nums) {
        int l = -1;
        int r = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (i >= r) {
                break;
            }
            if (nums[i] == 0) {
                l++;
                swap(nums, l, i);
            }
            if (nums[i] == 1) {
                // 什么都不做
            }
            if (nums[i] == 2) {
                r--;
                swap(nums, r, i);
                i--; // i 的位置有了新的元素，所以还得判断一下
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

    public static void main(String[] args) {
        // write your code here
        int[] nums = {1, 2, 0};
        new Solution().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
