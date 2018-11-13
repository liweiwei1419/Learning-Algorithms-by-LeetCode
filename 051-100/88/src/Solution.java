import java.util.Arrays;

/**
 * 题目中说了，nums1 够用，我可以从后向前归并
 * 这道题真正想考查的应该是这种实现方式，我们不能太死板，按照教科书的方式从头归并
 * https://leetcode-cn.com/problems/merge-sorted-array/description/
 *
 * @author liwei
 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        int i = m - 1;
        int j = n - 1;
        for (int k = len - 1; k >= 0; k--) {
            if (i == -1) {
                // i 用完了，j 出列
                nums1[k] = nums2[j];
                j--;
            } else if (j == -1) {
                // j 用完了，i 出列
                nums1[k] = nums1[i];
                i--;
            } else if (nums1[i] >= nums2[j]) {
                // 谁大谁出列
                nums1[k] = nums1[i];
                i--;
            } else {
                assert nums1[i] < nums2[j];
                nums1[k] = nums2[j];
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        Solution solution = new Solution();
        solution.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
