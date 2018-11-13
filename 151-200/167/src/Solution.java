import java.util.Arrays;

/**
 * 1,2,3,4,5,6,7 找 4
 */
public class Solution {

    // 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
    // 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

    /**
     * 数组有序，可以使用滑动数组
     *
     * @param numbers
     * @param target
     * @return
     */
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
                assert sum == target;
                int[] res = new int[2];
                res[0] = l + 1;
                res[1] = r + 1;
                return res;
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
