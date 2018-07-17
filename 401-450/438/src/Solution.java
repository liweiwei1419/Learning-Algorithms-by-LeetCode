import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {


    // 使用滑动窗口的方式解决，标记为简单哦
    // s = "cbaebabacd"，p = "abc"
    // 参考资料：https://blog.csdn.net/chenwuji91/article/details/52981530

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        // 先考虑特殊情况
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return res;
        }

        // 这个 hash 表记录了每个字母出现的频率，即计数值
        // ASCII 的长度是 256 位

        int[] hash = new int[256];

        // 滑动窗口的左边界
        int l = 0;
        // 滑动窗口的右边界
        int r = 0;
        // 滑动窗口的长度
        int distance = p.length();
        for (char c : p.toCharArray()) {
            hash[c]++;
        }

        int sLen = s.length();
        while (r < sLen) {
            if (hash[s.charAt(r)] > 0) {
                // 吸纳进来以后，说明差距减少 1
                distance--;
            }
            // 如果是等于 0 的就说明没有出现在 p 中，也 --，以后左边界扫到它的时候，就知道它不在 p 指定的范围中了
            // 不管当前字符在不在 hash 表中，都适用于这个逻辑（听下来想想为什么）
            hash[s.charAt(r)]--;
            r++;
            if (distance == 0) {
                // 差距为 0 了，就表示是一个结果，左端点加入结果集
                res.add(l);
            }
            if (r - l == p.length()) {
                // 大于等于 0 的，说明字符在 p 中，那些是负的字符说明不在 p 中
                if (hash[s.charAt(l)] >= 0) {
                    // 差距又拉大了 1
                    // 左端点离开滑动窗口，差距加大 1
                    distance++;
                }
                // 左端点离开滑动窗口
                // 不管 字符 在不在 p 中，都适用于这个逻辑
                hash[s.charAt(l)]++;
                l++;
            }
        }
        // System.out.println(Arrays.toString(hash));
        return res;
    }

    // c b a e b a b a c d
    // 0 1 2 3 4

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagrams = solution.findAnagrams(s, p);
        System.out.println(anagrams);
    }
}
