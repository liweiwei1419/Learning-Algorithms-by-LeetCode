/**
 * @author liweiwei1419
 * @date 2019/10/9 3:35 下午
 */
public class Solution {

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        // 特判
        if (target > nums[len - 1]) {
            return len;
        }

        // 在 [left, right] 里查找第 1 个大于等于 target 的元素
        int left = 0;
        int right = len - 1;
        while (left < right) {
            // 在区间只剩下一个元素的时候（left == right），退出循环
            // 最后这元素我们不是不看，而是留到循环以后来看
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 接下来在 [mid + 1, right] 查找
                left = mid + 1;
            } else {
                // nums[mid] >= target，
                // 接下来在 [left, mid] 查找
                right = mid;
            }
        }
        return left;
    }
}
