public class Solution7 {

    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            throw new IllegalArgumentException("数组为空，无最小元素");
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {
            // int mid = left + (right - left) / 2;
            int mid = (left + right) >>> 1;
            if (nums[mid] < nums[right]) {
                // 6 7 1 2 4 5
                right = mid;
            } else {
                // nums[mid] > nums[right]
                // 6 7 8 9 1
                left = mid + 1;
            }
        }
        return nums[left];
    }
}