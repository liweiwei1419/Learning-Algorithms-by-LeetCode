import java.util.HashMap;

public class Solution {

    // 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
    // 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
    // "并且 i 和 j 的差的绝对值最大为 k"，改成"并且 i 和 j 的差的绝对值不超过 k" 或许就好理解多了
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        // 先将极端用例返回
        if (len < 2) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        // int[] nums = {1, 0, 1, 1};
        // int k = 1;
        // int[] nums = {1, 2, 3, 1, 2, 3};
        // int k = 2;
        Solution solution = new Solution();
        boolean containsNearbyDuplicate = solution.containsNearbyDuplicate(nums, k);
        System.out.println(containsNearbyDuplicate);
    }
}
