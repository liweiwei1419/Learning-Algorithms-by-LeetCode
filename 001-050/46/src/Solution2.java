import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// https://leetcode-cn.com/problems/permutations/description/
public class Solution2 {

    private List<List<Integer>> res = new ArrayList<>();
    // 设置是否使用的数组，也是套路了
    private int[] nums;
    private boolean[] used;

    private void findPermutions(int index, Stack<Integer> stack) {
        // 这一行代码是调试信息，可以帮助我们观察程序的执行流程
        // System.out.println(Arrays.toString(used));
        if (index == nums.length) {
            // 添加到结果集中
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                stack.push(nums[i]);
                findPermutions(index + 1, stack);
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
        findPermutions(0, new Stack<>());
        return res;
    }

    public static void main(String[] args) {
        // write your code here

        Solution2 solution2 = new Solution2();
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = solution2.permute(nums);
        System.out.println(permute);
        System.out.println("end");

    }
}
