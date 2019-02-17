import java.util.ArrayList;
import java.util.List;

public class Solution5 {

    // 这种解法从语义上更好理解一些

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        int[] cntp = new int[26];
        int[] cnts = new int[26];

        int plen = p.length();
        int slen = s.length();

        // 数组 cntp 在预处理以后是不会
        for (int i = 0; i < plen; i++) {
            cntp[p.charAt(i) - 'a']++;
        }

        // 数 0 的个数
        int same = 0;
        for (int i = 0; i < 26; i++) {
            if (cntp[i] == 0) {
                same++;
            }
        }

        for (int i = 0; i < slen; i++) {
            // 右边界进来的时候全部加 1
            char curChar = s.charAt(i);
            cnts[curChar - 'a']++;
            if (cnts[curChar - 'a'] == cntp[curChar - 'a']) {
                // 右边界进来的时候，正好相等，则两个数组相同的数量加 1
                same++;
            } else if (cnts[curChar - 'a'] == cntp[curChar - 'a'] + 1) {
                // 右边界进来的时候，s 数组比 p 数组相应位置多 1，也就是说，二者不等，所以相同的数量减 1
                same--;
            }

            if (i >= plen) {
                // 计算左边界
                int deleteIndex = i - plen;
                char deleteChar = s.charAt(deleteIndex);
                // 左边界出来的时候，全部减 1
                cnts[deleteChar - 'a']--;
                if (cnts[deleteChar - 'a'] == cntp[deleteChar - 'a']) {
                    // 滑出去以后相等，所以加 1
                    same++;
                } else if (cnts[deleteChar - 'a'] == cntp[deleteChar - 'a'] - 1) {
                    // 滑出去以后，比数组 p 少 1，所以减 1
                    same--;
                }
            }

            if (same == 26) {
                res.add(i - plen + 1);
            }
        }
        return res;
    }
}
