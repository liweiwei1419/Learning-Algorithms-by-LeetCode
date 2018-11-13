import java.util.ArrayList;
import java.util.List;

public class Solution3 {

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
        int plen = p.length();
        int slen = s.length();
        for (int i = 0; i < slen; i++) {
            int curChar = s.charAt(i);
            cnts[curChar]++;
            if (cnts[curChar] == cntp[curChar]) {
                same++;
            } else if (cnts[curChar] == cntp[curChar] + 1) {
                // 超过了 same 就减 1，再超过反正已经减了 1 ，就不用再减了
                same--;
            }
            // 当 i>= p.lenght() 的时候，左边窗口要考虑左移了
            if (i >= plen) {
                int deleteChar = s.charAt(i - plen);
                cnts[deleteChar]--;
                if (cnts[deleteChar] == cntp[deleteChar]) {
                    same++;
                } else if (cnts[deleteChar] == cntp[deleteChar] - 1) {
                    // 超过了 same 就减 1，再超过反正已经减了 1 ，就不用再减了
                    same--;
                }
            }
            if (same == 256) {
                res.add(i - plen + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagrams = solution3.findAnagrams(s, p);
        System.out.println(anagrams);
    }
}
