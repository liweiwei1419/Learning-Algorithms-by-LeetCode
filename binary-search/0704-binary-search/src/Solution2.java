public class Solution2 {

    public int search(int[] nums, int target) {
        return binarySearch(nums, target);
    }

    private static int binarySearch(int[] arr, int target) {
        // 左边界
        int left = 0;
        // 右边界
        int right = arr.length - 1;
        int mid;
        // 通过 while 循环不断缩减搜索的区间端点，一次可以排除一大半
        while (left <= right) {
            // mid = left + (right - left) / 2;
            mid = (left + right) >>> 1;

            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 不能形成区间的时候，说明没有找到，返回 -1 就好了
        return -1;
    }
}
