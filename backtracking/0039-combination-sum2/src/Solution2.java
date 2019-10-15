import java.util.ArrayList;
import java.util.List;

/**
 * @author liweiwei1419
 * @date 2019/10/6 4:52 下午
 */
public class Solution2 {

    List<List<Integer>> output = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> out = new ArrayList<Integer>();
        backtrak(candidates, out, 0, 0, target);
        return output;
    }

    // 需要设计一个变量，表示下一次搜索的起始位置
    public void backtrak(int[] candidates, List<Integer> ans, int start, int cur, int target) {
        if (cur == target) {
            // 对于 Java 而言，对象在方法中是通过引用传递的，因此，要新建一个对象把当前得到的结果保存下来
            output.add(new ArrayList<>(ans));
        } else {
            // 从起始位置开始尝试每一个可能的解
            for (int i = start; i < candidates.length; i++) {
                if (cur + candidates[i] <= target) {
                    ans.add(candidates[i]);
                    cur += candidates[i];

                    // 因为每一个数字可以重复使用多次，因此下一轮搜索还是从 i 开始
                    backtrak(candidates, ans, i, cur, target);
                    // 一轮搜索结束以后，状态需要重置，因此数字加上的要减去，列表末尾加上的要移除
                    cur -= candidates[i];
                    ans.remove(ans.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {8, 7, 4, 3};
        int target = 11;
        Solution2 solution2 = new Solution2();
        List<List<Integer>> res = solution2.combinationSum(candidates, target);
        System.out.println(res);
    }
}
