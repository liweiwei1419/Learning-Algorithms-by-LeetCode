import java.util.Arrays;

/**
 * @author liwei
 * @date 18/7/2 下午1:35
 */
public class Solution3 {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        // 马上要在新数组（覆盖了旧数组）的第 1 个位置
        int l = 1;
        int pre = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] != pre) {
                nums[l] = nums[i];
                l++;
                pre = nums[i];
            }
        }
        return l;
    }


    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6};
        Solution3 solution3 = new Solution3();
        int removeDuplicates = solution3.removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(removeDuplicates);
    }
}
