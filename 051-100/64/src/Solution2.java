import java.util.Arrays;

// https://leetcode-cn.com/problems/minimum-path-sum/description/
public class Solution2 {


    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n];
        dp[0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j > 0) {
                    dp[j] = grid[0][j] + dp[j - 1];
                } else if (j == 0 && i > 0) {
                    dp[j] = dp[j] + grid[i][0];
                } else if (i != 0 && j != 0) {
                    dp[j] = Integer.min(dp[j], dp[j - 1]) + grid[i][j];
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        // write your code here
        int[][] grid = {{1, 2, 5}, {3, 2, 1}};


// write your code here
        //int[][] grid = {{1, 4, 8, 6, 2, 2, 1, 7}, {4, 7, 3, 1, 4, 5, 5, 1}, {8, 8, 2, 1, 1, 8, 0, 1}, {8, 9, 2, 9, 8, 0, 8, 9}, {5, 7, 5, 7, 1, 8, 5, 5}, {7, 0, 9, 4, 5, 6, 5, 6}, {4, 9, 9, 7, 9, 1, 9, 0}};



        Solution2 solution = new Solution2();
        int minPathSum = solution.minPathSum(grid);
        System.out.println(minPathSum);
    }
}
