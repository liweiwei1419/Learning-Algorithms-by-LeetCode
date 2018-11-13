/**
 * @author liwei
 * @date 18/6/29 下午5:46
 */
public class Solution5 {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        int half = len >> 1;
        int ans = 0;
        // 想清楚这一步又是为什么
        for (int i = 31; i >= 0; i--) {
            int zeros = 0;
            int compartor = 1 << i;
            for (int num : nums) {
                if ((num & compartor) == 0) {
                    zeros++;
                }
            }
            // 想清楚这一步是为什么
            ans <<= 1;
            ans += (zeros > half) ? 0 : 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5, 6, 6};
        Solution5 solution5 = new Solution5();
        int majorityElement = solution5.majorityElement(nums);
        System.out.println(majorityElement);
    }
}

