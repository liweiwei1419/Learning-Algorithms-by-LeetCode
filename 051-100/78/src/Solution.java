import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/description/
 */
public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        subsets(nums, len, 0, new ArrayList<>(), res);
        return res;
    }

    private void subsets(int[] nums, int len, int step, List<Integer> path, List<List<Integer>> res) {
        if (step == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 不选 nums[step]
        subsets(nums, len, step + 1, path, res);
        path.add(nums[step]);
        // 选 nums[step]
        subsets(nums, len, step + 1, path, res);
        // 状态重置
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> subsets = solution.subsets(nums);
        System.out.println(subsets);
    }
}
