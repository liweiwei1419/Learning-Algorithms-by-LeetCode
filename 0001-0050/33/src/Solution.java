public class Solution {

    // 不管怎么分，都一定有一边是递增序列
    // 另一边是一个规模更小的旋转数组
    //    参考资料：
    //    https://blog.csdn.net/wwh578867817/article/details/46592851

    // 此时左边是顺序数组
    // 6 7 8 9 1 2

    // 此时右边是顺序数组
    // 6 7 1 2 3 4 5 6

    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }

        int left = 0;
        int right = len - 1;
        // 注意：这里是等于
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 这里有一个坑，那就是
            // mid 有可能和 left 相等，所以分类标准这样
            // nums[left] < nums[mid] 不能用这个判断
            if (nums[mid] > nums[right]) {
                // 此时旋转点在右边
                // 6 7 8 9 1 2
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 此时旋转点在左边
                // 6 7 1 2 3 4 5 6
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;
        Solution solution = new Solution();
        int search = solution.search(nums, target);
        System.out.println(search);
    }
}
