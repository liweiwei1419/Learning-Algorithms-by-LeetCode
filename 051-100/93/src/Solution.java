import java.util.ArrayList;
import java.util.List;

// https://leetcode-cn.com/problems/restore-ip-addresses/description/
public class Solution {

    private List<String> res = new ArrayList<>();

    private boolean judgeIfIPSegment(String ipSegment) {
        int len = ipSegment.length();
        // 大于 1 位的时候，不能以 0 开头
        if (len > 1 && ipSegment.startsWith("0")) {
            return false;
        }
        return Integer.parseInt(ipSegment) <= 255;
    }

    private void findIpSegment(String s, int split, int begin, String pre) {
        // 先写递归终止条件
        if (split == 4) {
            if (begin == s.length()) {
                res.add(pre.substring(0, pre.length() - 1));
            }
            return;
        }
        // split < 4 的时候
        // begin + i <= s.length() 容易被忽略
        for (int i = 1; i <= 3 && begin + i <= s.length(); i++) {
            // 可能成为 ip 段的字符串
            String ifIpSegment = s.substring(begin, begin + i);
            if (judgeIfIPSegment(ifIpSegment)) {
                findIpSegment(s, split + 1, begin + i, pre + ifIpSegment + '.');
            }
        }

    }

    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        if (len == 0) {
            return res;
        }
        findIpSegment(s, 0, 0, "");
        return res;
    }

    public static void main(String[] args) {
        String s = "25525511135";
        Solution solution = new Solution();
        List<String> restoreIpAddresses = solution.restoreIpAddresses(s);
        System.out.println(restoreIpAddresses);
    }
}
