import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<List<String>> res = new ArrayList<>();

    // 判断是否回文
    private boolean judgeIfReverse(String s) {
        int len = s.length();
        if (len == 0 || len == 1) {
            return true;
        }
        // 01210 5 2
        // 012210 6 3
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private List<String> arrConvertList(String str) {
        List<String> res = new ArrayList<>();
        for (String s : str.split(",")) {
            res.add(s);
        }
        return res;
    }

    private void findReverse(String s, int begin, String pre) {
        if (begin == s.length()) {
            res.add(arrConvertList(pre));
            return;
        }
        for (int i = begin + 1; i <= s.length(); i++) {
            String ifReserve = s.substring(begin, i);
            if (judgeIfReverse(ifReserve)) {
                findReverse(s, i, pre + ifReserve + ",");
            }
        }
    }

    public List<List<String>> partition(String s) {
        int len = s.length();
        if (len == 0) {
            return res;
        }
        findReverse(s, 0, "");
        return res;
    }

    public static void main(String[] args) {
        // write your code here
        Solution solution = new Solution();
        String s = "aab";
        List<List<String>> partition = solution.partition(s);
        System.out.println(partition);

    }
}
