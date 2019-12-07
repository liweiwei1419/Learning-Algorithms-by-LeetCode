/**
 * @author liwei
 * @date 2019/7/11 11:45 PM
 */
public class Solution3 {

    // 把等于元素放在最后判断的二分查找算法

    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {

            int mid = (left + right) >>> 1;

            if (nums[mid] < target) {
                // 下一轮搜索区间是：[mid + 1, right]
                left = mid + 1;
            } else {
                // 此时 nums[mid] >= target，
                // mid 的右边一定不存在 target，下一轮搜索区间是：[left, mid]
                right = mid;
            }
        }
        // 不要忘了单独做判断
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}
