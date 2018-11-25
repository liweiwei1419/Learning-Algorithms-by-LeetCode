import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution2 {

    private List<List<Integer>> res = new ArrayList<>();
    // 设置是否使用的数组，也是套路了
    private int[] nums;
    private boolean[] marked;

    // hasUsedCount 表示已经使用的数组元素的个数
    private void findPermutions(int hasUsedCount, Stack<Integer> stack) {
        // 这一行代码是调试信息，可以帮助我们观察程序的执行流程
        // System.out.println(Arrays.toString(used));
        if (hasUsedCount == nums.length) {
            // 添加到结果集中
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!marked[i]) {
                marked[i] = true;
                stack.push(nums[i]);
                findPermutions(hasUsedCount + 1, stack);
                stack.pop();
                marked[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        this.nums = nums;
        marked = new boolean[len];
        findPermutions(0, new Stack<>());
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> permute = solution.permute(nums);
        System.out.println(permute);
    }
}
