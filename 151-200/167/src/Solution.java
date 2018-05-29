package leetcode.q167;

import java.util.Arrays;

/**
 * 暴力解法的思路
 * 1,2,3,4,5,6,7 找 4
 * Created by liwei on 17/9/20.
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int num1 = numbers[i];
            int num2 = target - num1;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] == num2) {
                    //
                    int[] res = {i + 1, j + 1};
                    return res;

                } else if (numbers[j] > num2) {
                    break;
                }
            }
        }
        throw new RuntimeException("在数组中没有找到这样的两个数，使得它们的和为指定值");
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        Solution solution = new Solution();
        int[] res = solution.twoSum(nums, 4);
        System.out.println(Arrays.toString(res));
    }
}
