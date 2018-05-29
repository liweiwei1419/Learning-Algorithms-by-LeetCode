import java.util.Arrays;

public class Solution {

    // https://leetcode-cn.com/problems/merge-sorted-array/description/
    // 常规题，其实就是归并排序，教科书上的内容，想都不要想的题目
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 因为要在 num1 上修改，把 nums1 返回回去
        // 因此，把 num1 复制一份
        int[] nums3 = new int[m];
        for (int i = 0; i < m; i++) {
            nums3[i] = nums1[i];
        }

        int i = 0; // 数组3
        int j = 0; // 数组2
        int length = m + n;
        for (int k = 0; k < length; k++) {
            if (i == m) {
                nums1[k] = nums2[j];
                j++;
            } else if (j == n) {
                nums1[k] = nums3[i];
                i++;
            } else if (nums3[i] < nums2[j]) {
                nums1[k] = nums3[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        new Solution().merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
