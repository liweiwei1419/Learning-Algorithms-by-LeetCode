import java.util.*;

// https://leetcode-cn.com/problems/3sum/description/
public class Solution {

    // nums = [-1, 0, 1, 2, -1, -4]，
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }

        // 如果暴力求解的话，考虑的可能性非常多，所以不妨排序，然后再使用指针对撞的思路
        // 这样，在内层循环的时候，一旦找到一个解，内层循环就可以退出了，这是解决这个问题的关键
        // 虽然数组中的元素可以重复，但一个数不能重复使用，所以"排序+指针对撞"这个策略是可行的
        // 排好序的思考方式是不是很像插入排序？
        // 考虑一下，能不能使用求组合数（搜索）的方式得到所有解
        // [-4, -1, 0, 1, 2]
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> oneSolver = new ArrayList<>();
                    oneSolver.add(nums[i]);
                    oneSolver.add(nums[j]);
                    oneSolver.add(nums[k]);
                    res.add(oneSolver);
                    // 找到了，当前循环就不会再有解了，可以进入下一循环，这里是关键，前提是数组得排好序
                    break;
                } else if (sum > 0) {// 后面的数太大了，让它往前走一步试试看
                    k--;
                } else { // sum < 0， 前面的数太小了，让它往后走一步试试看
                    j++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Solution solution = new Solution();
        List<List<Integer>> res = solution.threeSum(nums);
        res.forEach(System.out::println);
    }
}
