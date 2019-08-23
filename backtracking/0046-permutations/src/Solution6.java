import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution6 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }

        helper(nums, 0, len, res);
        return res;
    }

    private void helper(int[] nums, int begin, int len, List<List<Integer>> res) {
        if (begin == len) {
            List<Integer> currRes = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                currRes.add(nums[i]);
            }
            res.add(currRes);
        }
        // 从 begin 的下一位开始一直要交换到最后一位
        for (int i = begin; i < len; i++) {
            // System.out.println(Arrays.toString(nums) + " i " + i + " begin " + begin);
            swap(nums, begin, i);
            helper(nums, begin + 1, len, res);
            // 注意：递归完成以后要交换回来
            swap(nums, begin, i);
        }
    }

    private void swap(int[] nums, int index1, int index2) {
//        nums[index1] = nums[index1] ^ nums[index2];
//        nums[index2] = nums[index1] ^ nums[index2];
//        nums[index1] = nums[index1] ^ nums[index2];
        if (index1 == index2) {
            return;
        }
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = new Solution6().permute(nums);
        System.out.println(lists);
    }
}

