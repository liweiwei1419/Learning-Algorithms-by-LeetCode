public class Solution2 {

    // 原始二分查找实现：递归

    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        return binarySearch(nums, target, 0, len - 1);
    }

    private static int binarySearch(int[] arr, int target, int left, int right) {
        // 先处理递归到底的情况
        if (left > right) {
            // 不能形成区间，返回 -1 表示没有找到
            return -1;
        }
        int mid = (left + right) >>> 1;
        if (target == arr[mid]) {
            // 找到了，就将目标元素的索引返回
            return mid;
        } else if (target < arr[mid]) {
            // 既然是有序数组，目标元素的值比中间元素还要小，就应该在中间元素的左边去找
            return binarySearch(arr, target, left, mid - 1);
        } else {
            // 既然是有序数组，目标元素的值比中间元素还要大，就应该在中间元素的右边去找
            return binarySearch(arr, target, mid + 1, right);
        }
    }

}
