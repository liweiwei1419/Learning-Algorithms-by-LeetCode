public class Solution4 {

    public int climbStairs(int n) {
        if (n <= 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        int[] memory = new int[n + 1];
        memory[0] = 1;
        memory[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            memory[i] = -1;
        }
        for (int i = 2; i < n + 1; i++) {
            memory[i] = memory[i - 1] + memory[i - 2];
        }
        return memory[n];
    }
}
