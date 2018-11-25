public class Solution3 {

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

    // 写了一个不太好理解的二分法的版本

    private int findLowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        // left + 1 == right;

        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }
        return -1;
    }

    private int findUpBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (nums[right] == target) {
            return right;
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}
