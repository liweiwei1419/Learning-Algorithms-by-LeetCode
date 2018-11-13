import java.util.ArrayList;
import java.util.List;


/**
 * 和 Solution 是一致的
 */
public class Solution2 {

    private int[] nums;
    private int[] counter;
    private int[] indexes;

    private void mergeAndCountSmaller(int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeAndCountSmaller(l, mid);
        mergeAndCountSmaller(mid + 1, r);
        mergeOfTwoSortedArrAndCountSmaller(l, mid, r);
    }

    // indexes[i] = j，表示排名第 i 个数据的元素下标是 j
    private void mergeOfTwoSortedArrAndCountSmaller(int l, int m, int r) {
        int[] merged = new int[r - l + 1];
        int i = l;
        int j = m + 1;
        int k = 0;
        int jump = 0;
        while (i <= m || j <= r) {
            if (i > m) {
                // i 用完了 j++
                merged[k++] = indexes[j++];
            } else if (j > r) {
                // j 用完了 i++
                counter[indexes[i]] += jump;
                merged[k++] = indexes[i++];
            } else if (nums[indexes[i]] <= nums[indexes[j]]) {
                counter[indexes[i]] += jump;
                merged[k++] = indexes[i++];
            } else {
                // nums[indexes[i]] > nums[indexes[j]]
                jump++;
                merged[k++] = indexes[j++];
            }
        }
        for (int p = 0; p < merged.length; p++) {
            indexes[l + p] = merged[p];
        }
    }

    /**
     * 完成排序是对 indexes 数组进行排序
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>(len);
        if (len == 0) {
            return res;
        }
        this.nums = nums;
        counter = new int[len];
        indexes = new int[len];
        for (int i = 0; i < len; i++) {
            indexes[i] = i;
        }
        mergeAndCountSmaller(0, len - 1);
        for (int i = 0; i < len; i++) {
            res.add(counter[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 4};
        Solution2 solution2 = new Solution2();
        List<Integer> countSmaller = solution2.countSmaller(nums);
        System.out.println(countSmaller);
    }
}
