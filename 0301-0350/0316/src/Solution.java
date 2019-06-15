import java.util.Stack;

public class Solution {

    // 贪心算法

    public String removeDuplicateLetters(String s) {
        // 计算 26 字母数量
        int[] charsCount = new int[26];
        // 标记字母是否已经入栈
        boolean[] visited = new boolean[26];
        int len = s.length();
        char[] sChars = s.toCharArray();
        for (char c : sChars) {
            charsCount[c - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        // 最终字符的长度
        int index = 0;
        for (int count : charsCount) {
            if (count > 0) {
                index++;
            }
        }

        char[] res = new char[index];
        // len 是字符串的长度
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            // 有小字符的且满足其前面的字符在小字符后还有同样字符的，则出栈
            while (!stack.isEmpty() && c < stack.peek() && charsCount[stack.peek() - 'a'] > 1 && !visited[c - 'a']) {
                Character pop = stack.pop();
                visited[pop - 'a'] = false;
                charsCount[pop - 'a']--;
            }
            if (visited[c - 'a']) {
                //重复的字符根据游标往后移动，数量减一
                charsCount[c - 'a']--;
                continue;
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }

        while (!stack.isEmpty()) {
            res[--index] = stack.pop();
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res =solution.removeDuplicateLetters("bcabc");
        System.out.println(res);
    }
}
