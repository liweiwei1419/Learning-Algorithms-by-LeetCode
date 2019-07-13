/**
 * 最好的二分查找法模板写出来的代码
 *
 * @author liwei
 * @date 2019/7/11 11:45 PM
 */
public class Solution3 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}
