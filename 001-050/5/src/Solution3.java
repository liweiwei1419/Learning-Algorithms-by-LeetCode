/**
 * 使用 Manacher 算法
 */
public class Solution3 {

    /**
     * 创建分隔符分割的字符串
     *
     * @param s      原始字符串
     * @param divide 分隔字符
     * @return 使用分隔字符处理以后得到的字符串
     */
    private String generateSDivided(String s, char divide) {
        int len = s.length();
        if (len == 0) {
            return "";
        }
        if (s.indexOf(divide) != -1) {
            throw new IllegalArgumentException("参数错误，您传递的分割字符，在输入字符串中存在！");
        }
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(divide);
        for (int i = 0; i < len; i++) {
            sBuilder.append(s.charAt(i));
            sBuilder.append(divide);
        }
        return sBuilder.toString();
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 0) {
            return "";
        }
        String sDivided = generateSDivided(s, '#');
        int slen = sDivided.length();
        int[] p = new int[slen];
        int mx = 0;
        // id 是由 mx 决定的，所以不用初始化，只要声明就可以了
        int id = 0;
        int longestPalindrome = 1;
        String longestPalindromeStr = s.substring(0, 1);
        for (int i = 0; i < slen; i++) {
            if (i < mx) {
                // 这一步是 Manacher 算法的关键所在，一定要结合图形来理解
                // 这一行代码是关键，可以把两种分类讨论的情况合并
                p[i] = Integer.min(p[2 * id - i], mx - i);
            } else {
                // 走到这里，只可能是因为 i = mx
                if (i > mx) {
                    throw new IllegalArgumentException("程序出错！");
                }
                p[i] = 1;
            }
            while (i - p[i] >= 0 && i + p[i] < slen && sDivided.charAt(i - p[i]) == sDivided.charAt(i + p[i])) {
                p[i]++;
            }
            // 我们想象 mx 的定义，它是遍历过的 i 的 i + p[i] 的最大者
            // 写到这里，我们发现，如果 mx 的值越大，
            // 进入上面 i < mx 的判断的可能性就越大，这样就可以重复利用之前判断过的回文信息了
            if (i + p[i] > mx) {
                mx = i + p[i];
                id = i;
            }

            if (p[i] - 1 > longestPalindrome) {
                longestPalindrome = p[i] - 1;
                longestPalindromeStr = sDivided.substring(i - p[i] + 1, i + p[i]).replace("#", "");
            }
        }
        return longestPalindromeStr;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        String s = "abbahopxpo";
        String longestPalindrome = solution3.longestPalindrome(s);
        System.out.println(longestPalindrome);
    }
}
