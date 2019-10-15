/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/description/
 *
 * @author liwei
 */
public class Solution {

    // 常规问题：借助快速排序的子过程 partition ，小放过，大交换
    // 解题思路：这道题可以借用 partition 的思想
    // 关键在于理解 partition 的返回值，
    // 返回值是拉通了整个数组的索引值，这一点是非常重要的，不要把问题想得复杂了
    // 找第 k 大，语义是从右边往左边数，那么从左向右数是第几个呢，我们列出几个找找规律就好了。
    // [2,5,6,1,4,7] ，
    // 一共 6 个元素，找第 2 大，索引是 4
    // 找第 4 大，索引是 2，因此，目标元素的索引是 len - k，即找最终排定以后位于 len - k 的那个元素

    // 减治法（分治法的特例）
    // 时间复杂度：O(log N)
    // 空间复杂度：O(1)

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        // 转换一下，第 k 大元素的索引是 len - k
        int target = len - k;

        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                assert index > target;
                right = index - 1;
            }
        }
    }

    /**
     * 在 nums 数组的 [left, right] 部分执行 partition 操作，返回 nums[i] 排序以后应该在的位置
     * 在遍历过程中保持循环不变量的语义
     * 1、(left, k] < nums[left]
     * 2、(k, i] >= nums[left]
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                // 小于 pivot 的元素都被交换到前面
                j++;
                swap(nums, j, i);
            }
        }
        // 最后这一步不要忘记了
        swap(nums, j, left);
        return j;
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
