/**
 * @author liweiwei1419
 * @date 2019/10/9 2:23 下午
 */
public class Solution2 {

    /**
     * 设计递归方法
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        return binarySearch(nums, 0, len - 1, target);
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            // [mid + 1, right]
            return binarySearch(nums, mid + 1, right, target);
        }else {
            // nums[mid] > target，[left, mid - 1]
            return binarySearch(nums, left, mid - 1, target);
        }

    }
}
