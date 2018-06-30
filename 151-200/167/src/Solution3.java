import java.util.Arrays;

/**
 * 同 Solution
 * 我个人觉得指针对撞的解法思路清晰，表意明确，代码量也少
 */
public class Solution3 {

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i + 1, j + 1};
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        throw new RuntimeException("在数组中没有找到这样的两个数，使得它们的和为指定值");
    }

    // 1,2,3,4,5 4
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 4, 9, 56, 90};
        Solution3 solution = new Solution3();
        int[] res = solution.twoSum(nums, 8);
        System.out.println(Arrays.toString(res));
    }
}
