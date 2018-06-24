import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * @author liwei
 */
public class Solution {

    private boolean[] marked;

    // usedCount 表示已经使用过的元素的个数
    private void findPermution(int[] nums, int usedCount, int n, Stack<Integer> pre, List<List<Integer>> res) {
        if (usedCount == n) {
            res.add(new ArrayList<>(pre));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!marked[i]) {
                marked[i] = true;
                pre.push(nums[i]);
                findPermution(nums, usedCount + 1, n, pre, res);
                marked[i] = false;
                pre.pop();
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        marked = new boolean[len];
        if (len == 0) {
            return res;
        }
        findPermution(nums, 0, len, new Stack<>(), res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> permute = solution.permute(nums);
        System.out.println(permute);
    }
}
