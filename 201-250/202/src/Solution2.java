package leetcode.q202;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by liwei on 17/9/13.
 */
class Solution {
    public boolean isHappy(int n) {
        boolean isHappy = false;
        Set<Integer> set1 = new HashSet<>();
        String numberStr = String.valueOf(n);
        while (true) {
            int sum = 0;
            for (int i = 0; i < numberStr.length(); i++) {
                sum += Math.pow(Integer.valueOf(String.valueOf(numberStr.charAt(i))), 2);
            }
            if (sum == 1) {
                isHappy = true;
                break;
            } else if (set1.contains(sum)) {
                break;
            } else {
                set1.add(sum);
                numberStr = String.valueOf(sum);
            }
        }
        return isHappy;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean isHappy = solution.isHappy(2);
        System.out.println(isHappy);
        char c = '1';
        System.out.println(Integer.parseInt(String.valueOf(c)));
    }
}
