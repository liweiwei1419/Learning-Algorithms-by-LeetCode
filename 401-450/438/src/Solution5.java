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

        // 数组 cntp 在预处理以后是没有变化的
        for (int i = 0; i < plen; i++) {
            cntp[p.charAt(i) - 'a']++;
        }

        int same = 0;
        for (int i = 0; i < 26; i++) {
            if (cntp[i] == 0) {
                same++;
            }
        }

        for (int i = 0; i < slen; i++) {
            char curChar = s.charAt(i);
            cnts[curChar - 'a']++;
            if (cnts[curChar - 'a'] == cntp[curChar - 'a']) {
                same++;
            } else if (cnts[curChar - 'a'] == cntp[curChar - 'a'] + 1) {
                same--;
            }

            if (i >= plen) {
                int deleteIndex = i - plen;
                char deleteChar = s.charAt(deleteIndex);
                cnts[deleteChar - 'a']--;
                if (cnts[deleteChar - 'a'] == cntp[deleteChar - 'a']) {
                    same++;
                } else if (cnts[deleteChar - 'a'] == cntp[deleteChar - 'a'] - 1) {
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
