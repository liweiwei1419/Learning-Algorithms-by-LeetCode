/**
 * @author liweiwei1419
 * @date 2019/9/19 7:40 下午
 */
public class Solution {

    /**
     * 二分查找：反面思考
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (target > nums[len - 1]) {
            return len;
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                // 如果看到的这个数小于 target，那么它以及它之前的数都不是我们要找的
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
