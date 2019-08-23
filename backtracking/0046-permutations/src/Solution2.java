import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution2 {

    // 把一些变量设置成全局

    private List<List<Integer>> res = new ArrayList<>();
    private int[] nums;
    private boolean[] used;
    private Stack<Integer> stack=new Stack<>();

    private void dfs(int hasUsed) {
        // 这一行代码是调试信息，可以帮助我们观察程序的执行流程
        // System.out.println(Arrays.toString(used));
        if (hasUsed == nums.length) {
            // 添加到结果集中
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                stack.push(nums[i]);
                dfs(hasUsed + 1);
                stack.pop();
                used[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        this.nums = nums;
        used = new boolean[len];
        dfs(0);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution2 solution2 = new Solution2();
        List<List<Integer>> permute = solution2.permute(nums);
        System.out.println(permute);
    }
}
