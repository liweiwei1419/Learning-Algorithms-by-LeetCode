import java.util.Arrays;

/**
 * 练习，同 Solution
 *
 * @author liwei
 * @date 18/7/2 下午9:10
 */
public class Solution4 {

    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int l = 0;
        int r = len - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum > target) {
                r--;
            } else if (sum < target) {
                l++;
            } else {
                int[] res = new int[2];
                res[0] = l + 1;
                res[1] = r + 1;
                return res;
            }
        }
        throw new IllegalArgumentException("输入数据有误");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        Solution4 solution4 = new Solution4();
        int[] res = solution4.twoSum(nums, 4);
        System.out.println(Arrays.toString(res));
    }
}
