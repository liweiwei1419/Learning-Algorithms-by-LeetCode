import java.util.Arrays;

// https://leetcode-cn.com/problems/remove-element/description/
public class Solution {

    // 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
    // [0,1,2,2,3,0,4,2]
    // [2,1,0,2,3,0,4,2]
    // [2,2,0,1,3,0,4,2]
    // [2,2,2,1,3,0,4,0]

    // 思路：常规题，只要等于指定元素，就交换，不等于就放过
    public int removeElement(int[] nums, int val) {
        // 定义 [0,j) 这个区间里的数满足 不等于 val，所以是先交换，再 ++
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                swap(nums, j, i);
                j++;
            }
        }
        return j;
    }


    private void swap(int[] nums, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        int t = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = t;
    }

    // https://leetcode-cn.com/problems/remove-element/description/
    public static void main(String[] args) {
        // write your code here
        int[] nums = {3, 2, 2, 3};
        int val = 2;
        int result = new Solution().removeElement(nums, val);
        System.out.println(result);
        System.out.println(Arrays.toString(nums));
    }
}
