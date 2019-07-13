import java.util.Arrays;
import java.util.Collections;

class GuessGame {

    private static final int NUM = 6;

    int guess(int num) {
        if (num == NUM) {
            return 0;
        } else if (num < NUM) {
            return -1;
        }
        return 1;
    }
}


public class Solution extends GuessGame {

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            // int mid = left + (right - left + 1) / 2;
            int mid = (left + right + 1) >>> 1;
            int guessNum = guess(mid);
            if (guessNum == -1) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        // 最后剩下的数一定是所求，无需后处理
        return left;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 10;
        int guessNumber = solution.guessNumber(n);
        System.out.println(guessNumber);
    }
}


