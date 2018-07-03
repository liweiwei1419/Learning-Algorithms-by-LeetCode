/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/description/
 *
 * @author liwei
 */
public class Solution {

    // 常规问题：使用快速排序的思路就可以完成
    // 解题思路：这道题可以借用 partition 的思想
    // 关键在于理解 partition 的返回值，【返回值是拉通了整个数组的索引值，这一点是非常重要的，不要把问题想得复杂了】
    // [2,5,6,1,4,7] ，一共 6 个元素 找 k = 2，如果返回 4 ，就可以返回了
    // [2,5,6,1,4,7] ，一共 6 个元素 找 k = 2，如果返回 2 ，左边的区间就可以不用看了

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        while (true) {
            int i = partition(nums, l, r);
            // 下面的步骤是二分查找
            if (k == len - i) {
                return nums[i];
            } else if (k < len - i) {
                l = i + 1;
            } else {
                assert k < len - i;
                r = i - 1;
            }
        }
    }

    /**
     * 在 nums 数组的 [left,right] 部分执行 partition，返回 nums[i] 应该在的位置
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int k = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                // 交换
                k++;
                swap(nums, k, i);
            }
        }
        swap(nums, k, left);
        return k;
    }

    private void swap(int[] nums, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1};
        int ret = new Solution().findKthLargest(nums, 2);
        System.out.println(ret);
    }
}
