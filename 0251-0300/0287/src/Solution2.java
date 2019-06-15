public class Solution2 {

    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int l = 1;
        int r = len - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int counter = 0;
            for (int num : nums) {
                if (num <= mid) {
                    counter += 1;
                }
            }
            if (counter > mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
