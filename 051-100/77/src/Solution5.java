import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode-cn.com/problems/combinations/description/
public class Solution {

    private List<List<Integer>> res = new ArrayList<>();


    private void findCombine(int n, int k, int index, Stack<Integer> stack) {
        if (stack.size() == k) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = index; i <= n - (k - stack.size()) + 1; i++) {
            stack.add(i);
            findCombine(n, k, i + 1, stack);
            stack.pop();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        if (k > n || n < 0 || k < 0) {
            return res;
        }
        findCombine(n, k, 1, new Stack<>());
        return res;
    }

    public static void main(String[] args) {
        // write your code here

        Solution solution = new Solution();
        List<List<Integer>> combine = solution.combine(4, 2);
        System.out.println(combine);
    }
}
