public class Solution {

    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int len = s.length();
        int index = 0;
        while (index < len) {
            for (int i = 0; i < numRows && index < len; i++) {
                rows[i].append(s.charAt(index));
                index++;
            }
            for (int i = numRows - 2; i > 0 && index < len; i--) {
                rows[i].append(s.charAt(index));
                index++;
            }
        }
        for (int i = 1; i < numRows; i++) {
            rows[0].append(rows[i]);
        }
        return rows[0].toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        Solution solution = new Solution();
        String convert = solution.convert(s, numRows);
        System.out.println(convert);
    }
}
