public class Solution {

    public int mySqrt(int x) {
        if (x < 1) {
            return 0;
        }
        if (x < 4) {
            return 1;
        }
        long l = 1;
        long r = x / 2;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long square = mid * mid;
            if (square <= x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return (int) r;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(4));
        int max = 2147395599;
        for (int i = 0; i < max; i++) {
            int mySqrt = solution.mySqrt(i);
            int sysSqrt = (int) Math.sqrt(i);
            if (mySqrt != sysSqrt) {
                System.out.println(i);
                break;
            }
        }
    }
}