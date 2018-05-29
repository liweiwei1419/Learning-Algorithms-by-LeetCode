import java.util.ArrayList;
import java.util.List;

// https://leetcode-cn.com/problems/permutations-ii/
public class Solution {

    private int[] nums;
    private int length;
    private boolean[] used;
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        this.length = nums.length;
        if (length == 0) {
            return result;
        }
        used = new boolean[length];
        generatePermutation(0, new ArrayList<>());
        return result;
    }

    private void generatePermutation(int index, List<Integer> p) {
        if (index == length) {
            // 如果和以前有的排列不重复，才添加到结果集中
            if (!judgeDuplicate(p)) {
                result.add(new ArrayList<>(p));
            }
            return;
        }
        for (int i = 0; i < length; i++) {
            if (!used[i]) {
                used[i] = true;
                p.add(nums[i]);
                generatePermutation(index + 1, p);
                p.remove(p.size() - 1);
                used[i] = false;
            }
        }
    }

    private boolean judgeDuplicate(List<Integer> p) {
        List<Integer> currentList;
        for (int i = 0; i < result.size(); i++) {
            currentList = result.get(i);
            for (int j = 0; j < length; j++) {
                if (p.get(j) != currentList.get(j)) {
                    break;
                } else {
                    // p.get(j) == currentList.get(j)
                    if (j == length - 1) {
                        // 如果此时已经比较到第 3 个数字都相等了，就说明已经重复了
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // int[] nums = {1,2,3};
        int[] nums = {1, 1, 2};
        List<List<Integer>> lists = new Solution().permuteUnique(nums);
        System.out.println(lists);
    }
}
