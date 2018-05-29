package leetcode.q344;

/**
 * Created by liwei on 17/9/23.
 */
public class Solution {
    public String reverseString(String s) {
        char[] cArray = s.toCharArray();
        int i = 0;
        int j = cArray.length - 1;
        while (i < j) {
            swap(cArray, i, j);
            i++;
            j--;
        }
        return new String(cArray);
    }

    private void swap(char[] s, int index1, int index2) {
        if (index1 == index2) return;
        char temp = s[index1];
        s[index1] = s[index2];
        s[index2] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.reverseString("hello world");
        System.out.println(result);
    }
}
