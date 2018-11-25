import java.util.Arrays;

public class Solution {

    // 很明显要用二分查找算法

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int len = nums.length;
        if (len == 0) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }

        int left = 0;
        int right = len - 1;

        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (index == -1) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }

        int lowerBound = index;
        int upBound = index;
        while (lowerBound > 0 && nums[lowerBound - 1] == nums[lowerBound]) {
            lowerBound--;
        }
        while (upBound < len - 1 && nums[upBound] == nums[upBound + 1]) {
            upBound++;
        }
        res[0] = lowerBound;
        res[1] = upBound;
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1};
        int target = 1;
        int[] searchRange = solution.searchRange(nums, target);
        System.out.println(Arrays.toString(searchRange));
    }
}
