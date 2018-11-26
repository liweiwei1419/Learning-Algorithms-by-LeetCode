public class Solution {

    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] == nums[right]) {
                right--;
            } else {
                right = mid;
            }
        }
        assert left == right;
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        Solution solution = new Solution();
        int solutionMin = solution.findMin(nums);
        System.out.println(solutionMin);
    }
}