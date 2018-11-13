import java.util.ArrayList;
import java.util.List;

public class Solution4 {

    // 参考了小 Q 的思路，其实还是滑动窗口

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] cntp = new int[256];
        int[] cnts = new int[256];
        for (char c : p.toCharArray()) {
            cntp[c]++;
        }
        int same = 0;
        for (int i = 0; i < 256; i++) {
            if (cntp[i] == 0) {
                same++;
            }
        }
        int slen = s.length();
        for (int i = 0; i < slen; i++) {
            cnts[s.charAt(i)]++;
            if (cnts[s.charAt(i)] == cntp[s.charAt(i)]) {
                same++;
            } else if (cnts[s.charAt(i)] == cntp[s.charAt(i)] + 1) {
                // 超过了 same 就减 1，再超过反正已经减了 1 ，就不用再减了
                same--;
            }
            // 当 i>= p.lenght() 的时候，左边窗口要考虑左移了
            if (i >= p.length()) {
                int deleteIndex = i - p.length();
                cnts[s.charAt(deleteIndex)]--;
                if (cnts[s.charAt(deleteIndex)] == cntp[s.charAt(deleteIndex)]) {
                    same++;
                } else if (cnts[s.charAt(deleteIndex)] == cntp[s.charAt(deleteIndex)] - 1) {
                    // 超过了 same 就减 1，再超过反正已经减了 1 ，就不用再减了
                    same--;
                }
            }
            if (same == 256) {
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }
}
