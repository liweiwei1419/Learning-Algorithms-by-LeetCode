public class Solution4 {

    public int findMin(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            // int mid = left + (right - left) / 2;
            int mid = (left + right) >>> 1;
            if (nums[mid] == nums[right]) {
                // 2 2 1 2 2 2 2 2 2
                // 2 2 2 2 2 2 3 2 2
                right--;
            } else if (nums[mid] < nums[right]) {
                // 8 9 1 2 3 4 5
                right = mid;

            } else {
                assert nums[mid] > nums[right];
                // 4 5 6 7 8 1 2
                left = mid + 1;
            }
        }
        assert left == right;
        return nums[left];
    }
}
