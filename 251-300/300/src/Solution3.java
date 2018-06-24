import java.util.Arrays;

public class Solution3 {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        // 最长就是
        int[] tail = new int[len];
        // 表示最终有效数组的长度
        int res = 0;
        for (int num : nums) {
            int i = 0;
            int j = res;
            while (i != j) {
                int mid = (i + j) / 2;

                if (tail[mid] < num) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            tail[i] = num;
            if (i == res) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        Solution3 solution3 = new Solution3();
        int lengthOfLIS = solution3.lengthOfLIS(nums);
        System.out.println(lengthOfLIS);
    }
}
