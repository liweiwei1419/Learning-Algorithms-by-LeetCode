import java.util.Arrays;

public class Solution {

    // 输入: [1,2,3,4,5,6,7] 和 k = 3
    //        7 6 5 4 3 2 1
    //        5 6 7 1 2 3 4

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if (len == 0 || k <= 0) {
            return;
        }
        k %= len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    private void reverse(int[] nums, int index1, int index2) {
        if (index1 >= index2) {
            return;
        }
        int l = index1;
        int r = index2;
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        Solution solution = new Solution();
        solution.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}