import java.util.Arrays;

class Solution {
    // https://leetcode-cn.com/problems/move-zeroes/description/
    // [0, 1, 0, 3, 12]
    // [1, 0, 0, 3, 12]
    // [1, 3, 0, 0, 12]
    // [1, 3, 12, 0, 0]
    // 常规题：用思维定势就可以完成
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                swap(nums,i,j);
                j++;
            }

        }
    }

    private void swap(int[] nums,int index1,int index2){
        if(index1==index2){
            return;
        }
        int temp = nums[index1];
        nums[index1] =nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        (new Solution()).moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}