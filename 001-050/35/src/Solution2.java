public class Solution2 {

    // 只会把比自己大的覆盖成小的
    // 如果有一连串数跟 target 相同，则返回索引最靠前的

    // 特例： 3 5 5 5 5 5 5 5 5 5
    // 特例： 3 6 7 8

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        if (nums[len - 1] < target) {
            return len;
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // nums[mid] 的值可以舍弃
                left = mid + 1;
            } else {
                // nums[mid] 不能舍弃
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6};
        int target = 4;
        Solution2 solution2 = new Solution2();
        int searchInsert = solution2.searchInsert(nums, target);
        System.out.println(searchInsert);
    }
}
