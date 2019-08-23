public class Solution {

    // 分类讨论 + 注意边界值

    public int myAtoi(String str) {

        // 定义常量
        final Character PLUS = '+';
        final Character MINUS = '-';
        if (str == null || str.length() == 0) {
            return 0;
        }
        // 1、去掉左右空格
        str = str.trim();
        int len = str.length();
        int index = 0;
        if (len == 0) {
            return 0;
        }
        char signChar = str.charAt(0);
        long res = 0;
        int sign = 1;
        // 2、看第一个字符的符号，如果是符号记录符号，如果不是数字，直接返回 0
        if (signChar == PLUS){
            index++;
            sign = 1;
        } else if (signChar == MINUS) {
            index++;
            sign = -1;
        } else if (!Character.isDigit(signChar)) {
            return 0;
        }
        // 3、注意越界问题
        for (int i = index; i < len; i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                int cint = c - '0';
                res = res * 10 + cint;
                if (res * sign > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (res * sign < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                break;
            }
        }
        // 为了防止 long 类型越界，所以要在遍历的时候检查是否溢出
        // "9223372036854775808"
        res = res * sign;
        return (int) res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int myAtoi = solution.myAtoi("9223372036854775808");
        System.out.println(myAtoi);
    }
}
