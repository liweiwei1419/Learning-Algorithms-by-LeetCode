import java.util.ArrayList;
import java.util.List;

// https://leetcode-cn.com/problems/palindrome-partitioning/description/
// 基本思路和 ip 分割是一样的
public class Solution {

    private List<List<String>> result = new ArrayList<>();
    private String s;
    private int length;

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return result;
        }
        this.s = s;
        this.length = s.length();
        find(0, "");
        return result;
    }

    private void find(int begin, String pre) {
        System.out.println(begin + " " + pre);

        if (begin == length) {
            result.add(str2List(pre));
        }
        String reverseStr;
        for (int i = begin + 1; i <= length; i++) {
            reverseStr = s.substring(begin, i);
            if (judgeIfReverse(reverseStr)) {
                find(i, pre + reverseStr + ".");
            }
        }
    }

    private boolean judgeIfReverse(String s) {
        int length = s.length();
        if (length == 0) {
            return false;
        }
        if (length == 1) {
            return true;
        }
        int i = 0;
        int j = length - 1;
        while (i <= j) {
            if (!(s.charAt(i) == s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    private List<String> str2List(String str) {
        List<String> result = new ArrayList<>();
        // 注意1：. 有特殊含义，需要转义
        // 注意2：. 在末尾可以忽略，在开头就要算进去
        String[] reverseArr = str.split("\\.");
        int length = reverseArr.length;
        for (int i = 0; i < length; i++) {
            result.add(reverseArr[i]);
        }
        return result;
    }


    public static void main(String[] args) {
        // write your code here
        List<List<String>> result = new Solution().partition("ashsfssdsada");
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
        System.out.println("end");
    }
}
