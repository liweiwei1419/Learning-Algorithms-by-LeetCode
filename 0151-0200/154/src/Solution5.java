/**
 * @author liwei
 * @date 2018/11/25 6:42 PM
 */
public class Solution5 {

    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            throw new IllegalArgumentException("数组为空，最小值不存在");
        }
        return findMin(nums, 0, len - 1);
    }

    private int findMin(int[] nums, int left, int right) {
        if (left + 1 >= right) {
            return Math.min(nums[left], nums[right]);
        }
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        return Math.min(findMin(nums, left, mid - 1), findMin(nums, mid, right));
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        Solution solution = new Solution();
        int solutionMin = solution.findMin(nums);
        System.out.println(solutionMin);
    }
}
