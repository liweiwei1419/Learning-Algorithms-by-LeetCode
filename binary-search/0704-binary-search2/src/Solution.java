/**
 * @author liweiwei1419
 * @date 2019/10/9 2:17 下午
 */
public class Solution {

    /**
     * 循环
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        // 在 [left, right] 区间里查找 target
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                // [left, mid - 1]
                right = mid - 1;
            } else {
                // nums[mid] < target，[mid + 1, right]
                left = mid + 1;
            }
        }
        return -1;
    }
}
