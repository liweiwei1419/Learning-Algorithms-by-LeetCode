/**
 * 配图用
 *
 * @author liwei
 * @date 2019/6/27 10:58 AM
 */
public class Solution5 {

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (nums[len - 1] < target) {
            return len;
        }

        int left = 0;
        int right = len - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
