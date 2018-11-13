import java.util.*;

/**
 * 使用树状数组
 */
public class Solution4 {


    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }


        TreeSet<Integer> set = new TreeSet();
        for (int i = 0; i < len; i++) {
            set.add(nums[i]);
        }

        Map<Integer, Integer> map = new HashMap<>();
        int index = 1;
        for (Integer num : set) {
            map.put(num, index);
            index++;
        }

        FenwickTree fenwickTree = new FenwickTree(set.size() + 1);

        for (int i = len - 1; i >= 0; i--) {
            index = map.get(nums[i]);
            fenwickTree.update(index, 1);
            res.add(fenwickTree.query(index - 1));
        }
        Collections.reverse(res);
        return res;
    }


    private class FenwickTree {
        private int[] sums_;
        private int len;

        public FenwickTree(int n) {
            this.len = n;
            sums_ = new int[n + 1];
        }

        public void update(int i, int delta) {
            while (i <= len) {
                sums_[i] += delta;
                i += lowbit(i);
            }
        }

        public int query(int i) {
            // 从右到左查询
            int sum = 0;
            while (i > 0) {
                sum += sums_[i];
                i -= lowbit(i);
            }
            return sum;
        }

        public int lowbit(int x) {
            return x & (-x);
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 6, 1};
        Solution4 solution4 = new Solution4();
        List<Integer> countSmaller = solution4.countSmaller(nums);
        System.out.println(countSmaller);
    }
}
