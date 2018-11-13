/**
 * 常规题，其实就是归并排序，教科书上的内容，但是如果我不想开内存空间，题目中说了，nums1 够用，我可以从后向前归并
 * https://leetcode-cn.com/problems/merge-sorted-array/description/
 *
 * @author liwei
 */
public class Solution2 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 因为要在 num1 上修改，把 nums1 返回回去
        // 因此，把 num1 复制一份
        int[] nums3 = new int[m];
        System.arraycopy(nums1, 0, nums3, 0, m);
        // 数组3
        int i = 0;
        // 数组2
        int j = 0;
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
}
