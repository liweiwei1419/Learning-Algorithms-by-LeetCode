public class Solution {

    // 思路：看 nums[mid] 和区间 [mid, len - 1] 的长度，即 len - mid - 1 + 1 = len - mid
    // 要返回的是 nums 中的值
    // [0,1,2,5,6]

    public int hIndex(int[] citations) {
        int len = citations.length;
        // 特判
        if (len == 0 || citations[len - 1] == 0) {
            return 0;
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (citations[mid] < len - mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return len - left;
    }


    public static void main(String[] args) {
        int[] citations = {0, 1, 2, 5, 6};
        Solution solution = new Solution();
        int hIndex = solution.hIndex(citations);
        System.out.println(hIndex);
    }
}
