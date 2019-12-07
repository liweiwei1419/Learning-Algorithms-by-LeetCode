/**
 * @author liweiwei1419
 * @date 2019/11/28 9:47 上午
 */
public class Solution4 {

    public int search(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
