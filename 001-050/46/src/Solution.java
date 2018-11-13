import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * @author liwei
 */
public class Solution {


    // curSize 表示当前的路径 path 里面有多少个元素

    private void generatePermution(int[] nums, boolean[] used, int curSize, int len, Stack<Integer> path, List<List<Integer>> res) {
        if (curSize == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.push(nums[i]);
                used[i] = true;
                generatePermution(nums, used, curSize + 1, len, path, res);
                path.pop();
                used[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[] marked = new boolean[len];
        if (len == 0) {
            return res;
        }
        generatePermution(nums, marked, 0, len, new Stack<>(), res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> permute = solution.permute(nums);
        System.out.println(permute);
    }
}
