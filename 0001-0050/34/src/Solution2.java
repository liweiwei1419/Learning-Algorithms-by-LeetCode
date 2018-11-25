public class Solution2 {

    // 推荐的二分法的版本

    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{-1, -1};
        }
        int lowerBound = findLowerBound(nums, target);
        if (lowerBound == -1) {
            return new int[]{-1, -1};
        }
        int upBound = findUpBound(nums, target);
        return new int[]{lowerBound, upBound};
    }


    private int findLowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // 这种取中点的做法，一定要保证左边在增加
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // 此时 left = right

        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    private int findUpBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // 注意：这里 (right - left + 1) / 2; 加 1 ，是为了让取中点这件事情靠近右边
            int mid = left + (right - left + 1) / 2;
            // 1 2 3 4 5 6 7 8
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                // nums[mid] <= target
                left = mid;
            }
        }
        if (nums[right] == target) {
            return right;
        }
        return -1;
    }

}
