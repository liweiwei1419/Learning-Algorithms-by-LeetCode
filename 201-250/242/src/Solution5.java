import java.util.Arrays;

public class Solution5 {

    public boolean isAnagram(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if (slen != tlen) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        for (int i = 0; i < slen; i++) {
            if (sChars[i] != tChars[i]) {
                return false;
            }
        }
        return true;
    }
}
