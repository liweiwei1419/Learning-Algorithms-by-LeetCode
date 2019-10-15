/**
 * @author liweiwei1419
 * @date 2019/9/19 7:40 下午
 */
public class Solution2 {

    /**
     * 二分查找：正面思考
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
            int mid = (left + right ) >>> 1;
            if (nums[mid] >= target) {
                // 个人的经验是这种思路比较容易出错，但不一定，
                // 我比较习惯于从反面思考，例如：要我找第 1 个大于等于 target 的数，我的思考就是小于 target 的数一定不是我想要的
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
