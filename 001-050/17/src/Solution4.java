import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<String> res = new ArrayList<>();
    private String[] digitsMap = {
            " ", "", "abc", "def", "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
    };


    private void findCombinations(String digits, int begin, String pre) {
        // 先写递归终止条件
        if (begin == digits.length()) {
            res.add(pre);
            return;
        }
        String nextStr = digitsMap[digits.charAt(begin) - '0'];
        for (int i = 0; i < nextStr.length(); i++) {
            findCombinations(digits, begin + 1, pre + nextStr.charAt(i));
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return res;
        }
        findCombinations(digits,0,"");
        return res;
    }

    public static void main(String[] args) {
        // write your code here
        Solution solution =new Solution();
        List<String> letterCombinations = solution.letterCombinations("23");
        System.out.println(letterCombinations);
    }
}
