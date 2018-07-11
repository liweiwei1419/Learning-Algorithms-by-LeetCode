public class Solution3 {

    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] < nums[mid]) {
                // 6 7 8 9 1 2
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                assert nums[left] >= nums[mid];
                // 6 7 1 2 3 4 5
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 0;
        Solution3 solution3 = new Solution3();
        int search = solution3.search(nums, target);
        System.out.println(search);
    }
}
