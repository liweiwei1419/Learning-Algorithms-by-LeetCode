public class Solution2 {

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len;

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
