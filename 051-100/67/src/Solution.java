public class Solution {

    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int maxLen = Math.max(aLen, bLen);

        StringBuilder sa = new StringBuilder(a).reverse();
        StringBuilder sb = new StringBuilder(b).reverse();
        while (sa.length() < maxLen) {
            sa.append("0");
        }
        while (sb.length() < maxLen) {
            sb.append("0");
        }
        StringBuilder res = new StringBuilder();
        int sum = 0;
        int num1;
        int num2;
        for (int i = 0; i < maxLen; i++) {
            num1 = sa.charAt(i) - '0';
            num2 = sb.charAt(i) - '0';
            if (sum + num1 + num2 > 1) {
                res.append(sum + num1 + num2 - 2);
                sum = 1;
            } else {
                res.append(sum + num1 + num2);
                sum = 0;
            }
        }
        if (sum == 1) {
            res.append("1");
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        Solution solution = new Solution();
        String addBinary = solution.addBinary(a, b);
        System.out.println(addBinary);
    }
}
