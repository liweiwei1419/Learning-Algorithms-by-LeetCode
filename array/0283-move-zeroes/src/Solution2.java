public class Solution2{

    public void moveZeroes(int[] nums) {
        // 遍历指针
        int i = 0;
        // 一开始都写非零元素，然后都写零元素
        int j = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (int k = j; k < nums.length; k++) {
            nums[k] = 0;
        }
    }

}