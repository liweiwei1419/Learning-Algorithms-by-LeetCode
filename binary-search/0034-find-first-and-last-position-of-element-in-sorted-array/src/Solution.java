public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int lowerBound = findLowerBound(nums, target);
        if (lowerBound == -1) {
            return new int[]{-1, -1};
        }
        int upBound = findUpBound(nums, target);
        return new int[]{lowerBound, upBound};
    }

    private int findLowerBound(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
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
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    private int findUpBound(int[] nums, int target) {
        // 这里也不用对 len 长度为 0 的时候做特判
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        // 这里可以不用后处理，因为在查找 lower bound 的时候处理过
        // 目标值一定存在在排序数组中，才会执行到这个方法
        return left;
    }
}
