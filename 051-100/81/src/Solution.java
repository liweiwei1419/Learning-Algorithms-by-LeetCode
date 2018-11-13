public class Solution {

    public boolean search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }
        int left = 0;
        int right = len - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // System.out.println(mid);
            if (nums[mid] == target) {
                return true;
            }
            // 10 11 4 5 6 7 8 9
            if (nums[mid] < nums[right]) {
                // 右边的一定是顺序数组
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                assert nums[mid] >= nums[right];
                // 5 1 2 3 4 5 5 5 5 5 5 5
                // 1 1 3 1
                // 可能在左边，也有可能在右边
                if (nums[mid] == nums[right]) {
                    // 一步一步来，这一步操作很关键，因为我们已经判断了 nums[mid] != target，而此时 nums[mid] == nums[right]，
                    // 所以，nums[right] 可以丢弃了
                    right--;
                } else {
                    assert nums[mid] > nums[right];
                    // 4 5 6 7 8 9 1 2
                    // 左边是顺序数组
                    if (nums[left] <= target && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 3, 1};
        int target = 3;
        boolean search = solution.search(nums, target);
        System.out.println(search);
    }
}
