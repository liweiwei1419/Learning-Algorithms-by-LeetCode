public class Solution3 {

    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int l = 1;
        int r = len - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            int counter = 0;
            for (int num : nums) {
                if (num < mid) {
                    counter += 1;
                }
            }
            if (counter >= mid) {
                // 如果小于 4 的个数等于 4 或者更多
                // 那么重复的数一定位于 1、2、3
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }
}
