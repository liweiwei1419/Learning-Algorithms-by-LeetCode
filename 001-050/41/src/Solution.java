import java.util.Arrays;

public class Solution {

    public int firstMissingPositive(int[] nums) {

        int len = nums.length;
        if (len == 0) {
            return 1;
        }

        // 1 2 3 4
        // 2 3 1 4 ： 2 应该在索引为 1 的位置，3 应该在索引为 2 的位置，以此类推

        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }

        // 调试代码
        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < len; i++) {
            if (nums[i] - 1 != i) {
                return i + 1;
            }
        }

        return len + 1;
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
        Solution solution = new Solution();
        int[] nums = {3, 4, -1, 5};
        int firstMissingPositive = solution.firstMissingPositive(nums);
        System.out.println(firstMissingPositive);
    }
}
