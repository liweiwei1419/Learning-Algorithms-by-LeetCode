import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liweiwei1419
 * @date 2019/10/8 6:05 下午
 */
public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        int hash = 0;
        Stack<Integer> path = new Stack<>();
        dfs(nums, hash, path, len, res);
        return res;
    }

    private void dfs(int[] nums, int hash, Stack<Integer> path, int len, List<List<Integer>> res) {
        if (path.size() == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if ((hash & (1 << i)) == 0) {
                path.add(nums[i]);
                hash |= (1 << i);

                dfs(nums, hash, path, len, res);
                hash |= (1 << i);
                path.pop();
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> res = solution.permute(nums);
        System.out.println(res);
    }
}
