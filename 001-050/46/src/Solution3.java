import java.util.ArrayList;
import java.util.List;


public class Solution3 {

    private List<List<Integer>> result = new ArrayList<>();
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        int numsLen = nums.length;
        used = new boolean[numsLen];
        for (int i = 0; i < numsLen; i++) {
            used[i] = false;
        }
        generatePermutation(nums, 0, new ArrayList<Integer>());
        return result;
    }

    /**
     * 树形问题使用回溯算法的一个套路是：在循环中使用递归。
     * <p>
     * integers 中保存了一个有 index-1 个元素的排列。
     * 向这个排列的末尾添加第 index 个元素, 获得一个有 index 个元素的排列
     *
     * @param nums
     * @param index
     * @param integers
     */
    private void generatePermutation(int[] nums, int index, ArrayList<Integer> integers) {
        if (index == nums.length) {
            // 这里有个坑，integers 是一个指针，所以要新建一个对象放进去
            result.add(new ArrayList<>(integers));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                integers.add(nums[i]);
                generatePermutation(nums, index + 1, integers);
                used[i] = false;
                integers.remove(integers.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        List<List<Integer>> permute = solution4.permute(new int[]{1, 2, 3, 4});
        System.out.println(permute);
        System.out.println(permute.size());
    }
}
