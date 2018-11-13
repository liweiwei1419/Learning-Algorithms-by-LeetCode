import java.util.Arrays;

/**
 * @author liwei
 * @date 18/6/29 下午4:50
 */
public class Solution3 {
    /**
     * 排个序，在测试用例一定存在符合题目要求的数的时候，是可以这么用的
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len/2];
    }
}