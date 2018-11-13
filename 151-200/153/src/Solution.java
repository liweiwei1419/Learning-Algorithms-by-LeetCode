public class Solution {

    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            throw new IllegalArgumentException("数组为空");
        }
        int left = 0;
        int right = len - 1;
        // 思考，为什么是 left < right
        while (left < right) {
            // 这一步就是取中点，没有什么特别之处
            int mid = left + (right - left) / 2;

            // 特别注意：这里有个大坑，不能用 nums[left] < nums[mid]
            // 特别注意：这里有个大坑，不能用 nums[left] < nums[mid]
            // 特别注意：这里有个大坑，不能用 nums[left] < nums[mid]

            if (nums[mid] > nums[right]) {
                // 5 6 7 8 9 1 2
                // 此时可以扔掉 mid 的值
                left = mid + 1;
            } else {
                // 5 6 7 1 2 3 4
                assert nums[mid] < nums[right];
                // 此时 mid 有可能是最小值所在的索引
                right = mid;
            }
        }

        // 退出循环说明 left 与 right 相等，所以只剩一个元素可能，
        // 所以 return [left] 或者 return [right] 都可以了
        // 注意不能 return mid，可以从 {2,1} 这个输入看出来。

        return nums[right];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int min = solution.findMin(nums);
        System.out.println(min);
    }
}
