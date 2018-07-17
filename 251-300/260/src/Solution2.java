import java.util.Arrays;

public class Solution2 {

    public int[] singleNumber(int[] nums) {
        int axorb = 0;
        for (int num : nums) {
            axorb ^= num;
        }
        int mask = axorb & (~(axorb - 1));
        int[] res = new int[2];
        for (int num : nums) {
            if ((mask & num) != 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};
        Solution2 solution2 = new Solution2();
        int[] singleNumber = solution2.singleNumber(nums);
        System.out.println(Arrays.toString(singleNumber));
    }
}
