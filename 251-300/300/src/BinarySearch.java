/**
 * 二分查找法找后继
 *
 * @author liwei
 * @date 18/6/20 上午10:58
 */
public class BinarySearch {

    private int ceil(int[] nums, int target) {
        int len = nums.length;

        int l = 0;
        int r = len;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mid <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        // 跳出循环的时候 l == r
        if (r - 1 >= 0 && nums[r - 1] == target) {
            return r - 1;
        }
        return r;
    }


    public static void main(String[] args) {

    }
}
