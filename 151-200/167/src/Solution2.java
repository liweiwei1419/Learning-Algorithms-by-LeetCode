package leetcode.q167;

import java.util.Arrays;

/**
 * 在剩下的范围中寻找 target - num1
 * 特别要注意两点：
 * 1、递归的方法在一开始就要写上递归终止的条件；
 * 2、index2 的获取应该在 i+1 这个范围
 *
 * Created by liwei on 17/9/20.
 */
public class Solution2 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length-1; i++) {
            int num1 = numbers[i];
            int num2 = target - num1;
            int index2 = binarySearch(numbers,i+1,numbers.length-1,num2);

            if(index2!=0){
                return new int[]{i+1,index2+1};
            }
        }
        throw new RuntimeException("在数组中没有找到这样的两个数，使得它们的和为指定值");
    }


    // 1,2,3,4,5 4

    /**
     * 这里 return 0 和 -1 都是可以的，因为 0 和 -1 都不可能被取到
     * @param nums
     * @param left
     * @param right
     * @param target
     * @return
     */
    public int binarySearch(int[] nums,int left,int right,int target){
        if(left>right){
            return 0;
        }
        int mid = left + (right-left)/2;

        if(nums[mid] == target){
            return mid;
        }else if(nums[mid] > target){
            return binarySearch(nums,left,mid-1,target);
        }else {
            return binarySearch(nums,mid+1,right,target);
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,4,9,56,90};
        Solution2 solution = new Solution2();

        int[] res = solution.twoSum(nums, 8);
        System.out.println(Arrays.toString(res));
    }
}
