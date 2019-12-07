import java.util.Arrays;

/**
 * @author liwei
 * @date 2019/7/11 11:45 PM
 */
public class Solution4 {

    public int search(int[] nums, int target) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;

        while (left < right) {
            // 注意：根据分支逻辑，需要在取中间数的时候，向上取整
            int mid = (left + right + 1) >>> 1;

            if (nums[mid] > target) {
                // 下一轮搜索区间是：[left, mid - 1]
                right = mid - 1;
            } else {
                // 此时 nums[mid] <= target
                // mid 的左边一定不等于目标元素
                // 下一轮搜索区间是：[mid, right]
                left = mid;
            }
        }
        // 不要忘了单独做判断
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}
