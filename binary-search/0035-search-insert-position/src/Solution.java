public class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        // 特判
        if (target > nums[len - 1]) {
            return len;
        }

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
