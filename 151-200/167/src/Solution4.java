import java.util.Arrays;

public class Solution4 {

    /**
     * 暴力解法，复杂度太高，不推荐
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int num1 = numbers[i];
            int num2 = target - num1;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] == num2) {
                    return new int[]{i + 1, j + 1};
                } else if (numbers[j] > num2) {
                    break;
                }
            }
        }
        throw new RuntimeException("在数组中没有找到这样的两个数，使得它们的和为指定值");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Solution4 solution4 = new Solution4();
        int[] twoSum = solution4.twoSum(nums, target);
        System.out.println(Arrays.toString(twoSum));
    }
}
