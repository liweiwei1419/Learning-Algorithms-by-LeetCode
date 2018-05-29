import java.util.Arrays;

// 思路：排个序，挨个判断就知道了，感觉这种解法更简单些
public class Solution2 {
    public boolean isAnagram(String s, String t) {
        boolean isAnagram = true;
        if (s.length() != t.length()) {
            isAnagram = false;
        } else {
            char[] sArray = s.toCharArray();
            Arrays.sort(sArray);
            char[] tArray = t.toCharArray();
            Arrays.sort(tArray);
            for (int i = 0; i < sArray.length; i++) {
                if (sArray[i] != tArray[i]) {
                    isAnagram = false;
                    break;
                }
            }
        }
        return isAnagram;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        boolean anagram = new Solution2().isAnagram(s, t);
        System.out.println(anagram);
    }
}


