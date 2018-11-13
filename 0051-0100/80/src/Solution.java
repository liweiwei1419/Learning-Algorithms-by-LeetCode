import java.util.Arrays;

// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/description/
// 每个元素至多出现 2 次
// 解释：删除重复的元素，但是要求重复的元素至多保留两个。
// 思考：应该充分利用排好序的数组这个特性来完成。
// 设置一个变量，用于比较和之前的值是否重复，还要设置一个变量，计算重复次数。
// 注意：同样要注意到 nums = [] 的情况。
// 这道题调试了很久，最终还是独立解出来了，
// 主要是忽略了一个细节，在重复次数为 1 的时候，挪动指针位置的时候，同时也要赋值，一开始我忘记赋值了。

public class Solution {


    // 重复出现 1 次和 2 次的时候什么都不做
    // [0,1,1,1,2,2,2,2,3,3,4]

    public int removeDuplicates(int[] nums) {
        // [1,1] 最多 2 个元素就能够不用判断
        int len = nums.length;

        if (len <= 2) {
            return len;
        }
        int pre = nums[0];
        int duplicateTimes = 0;

        // 第 1 个元素肯定被保留，所以直接写 1
        // j 表示我每一次遍历，即将被覆盖的那个索引
        int j = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] == pre) {
                // 只要有重复，次数就要加 1
                duplicateTimes++;
                // 重复 1 次的时候，也要赋值
                if (duplicateTimes == 1) {

                    nums[j] = pre;
                    j++;
                }
                // 重复 1 次以上的时候，什么都不做，就相当于没有看到这个元素
            } else {
                // 重置次数和之前的那个值
                pre = nums[i];
                duplicateTimes = 0;

                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 2, 2, 2, 2, 3, 3, 4};
        int ret = new Solution().removeDuplicates(nums);
        System.out.println(ret);
        System.out.println(Arrays.toString(nums));
    }
}
