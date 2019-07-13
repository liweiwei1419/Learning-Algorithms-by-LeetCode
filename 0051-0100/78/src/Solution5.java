import java.util.ArrayList;
import java.util.List;

/**
 * @author liwei
 * @date 2019/7/3 3:05 AM
 */
public class Solution5 {

    public List<List<Integer>> subsets(int[] nums) {
        int size = nums.length;
        int n = 1 << size;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                if (((i >> j) & 1) == 1) {
                    cur.add(nums[j]);
                }
            }
            res.add(cur);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution5 solution5 = new Solution5();
        List<List<Integer>> subsets = solution5.subsets(nums);
        System.out.println(subsets);
    }
}
