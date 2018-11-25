import java.util.Random;

/**
 * @author liwei
 * @date 18/7/2 下午7:05
 */
public class Solution2 {

    private static Random random = new Random(System.currentTimeMillis());

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        if (len == 0 || k > len) {
            throw new IllegalArgumentException("参数错误");
        }
        // 转换一下，这样比较好操作
        // 【第 k 大元素的索引是 len - k】
        int target = len - k;
        int l = 0;
        int r = len - 1;
        while (true) {
            int i = partition(nums, l, r);
            if (i < target) {
                l = i + 1;
            } else if (i > target) {
                r = i - 1;
            } else {
                return nums[i];
            }
        }
    }

    // 在区间 [left, right] 这个区间执行 partition 操作

    private int partition(int[] nums, int left, int right) {
        // 在区间随机选择一个元素作为标定点（以下这两行代码非必需）
        // 这一步优化非必需
        if (right > left) {
            int randomIndex = left + 1 + random.nextInt(right - left);
            swap(nums, left, randomIndex);
        }

        int pivot = nums[left];
        int l = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                l++;
                swap(nums, l, i);
            }
        }
        swap(nums, left, l);
        return l;
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
        int[] nums = {1};
        int k = 1;
        Solution2 solution2 = new Solution2();
        int solution2KthLargest = solution2.findKthLargest(nums, k);
        System.out.println(solution2KthLargest);
    }
}
