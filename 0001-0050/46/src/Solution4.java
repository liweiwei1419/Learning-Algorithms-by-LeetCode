import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * @author liwei
 */
public class Solution4 {

    private int[] nums;
    private int length;
    private List<List<Integer>> result = new ArrayList<>();
    private boolean[] used;

    /**
     * @param index 表示已经取了 index 个元素构成子排列
     * @param p     已经得到的有，索引到 index-1 的一个子排列
     */
    private void generatePermutation(int index, List<Integer> p) {
        printUsedArrayAndDepth(index);
        if (index == nums.length) {
            // 此时所有的数字都已经使用完成 p 已经是一个解了
            // 这里一定要注意，Java 中是引用传递，因此得到一个结果的时候，要重新 new 一个对象
            result.add(new ArrayList<>(p));
            return;
        }
        // 看看哪些元素还没有被使用过
        for (int i = 0; i < length; i++) {
            if (!used[i]) {
                used[i] = true;
                p.add(nums[i]);
                generatePermutation(index + 1, p);
                // 刚开始接触回溯算法的时候常常会忽略状态重置
                // 回溯的时候，一定要记得状态重置
                p.remove(p.size() - 1);
                used[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.length = nums.length;
        if (length == 0) {
            return result;
        }
        used = new boolean[length];
        generatePermutation(0, new ArrayList<>());
        return result;
    }

    private void printUsedArrayAndDepth(int index) {
        StringBuilder s = new StringBuilder();
        s.append(index);
        s.append(": [");
        for (int i = 0; i < length; i++) {
            s.append(used[i] ? 1 : 0);
            if (i != length - 1) {
                s.append(",");
            }
        }
        s.append("]");
        System.out.println(s.toString());
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = new Solution4().permute(nums);
        System.out.println(lists);
    }
}
