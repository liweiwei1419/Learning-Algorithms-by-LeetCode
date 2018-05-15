import java.util.Arrays;

// https://leetcode-cn.com/problems/minimum-path-sum/description/
public class Solution3 {

    // 思考：我们有没有可能只用常数的空间复杂度就解决这个问题呢？
    public int minPathSum(int[][] grid) {

        return 0;
    }

    public static void main(String[] args) {
        // write your code here
        // int[][] grid = {{1, 4, 8, 6, 2, 2, 1, 7}, {4, 7, 3, 1, 4, 5, 5, 1}, {8, 8, 2, 1, 1, 8, 0, 1}, {8, 9, 2, 9, 8, 0, 8, 9}, {5, 7, 5, 7, 1, 8, 5, 5}, {7, 0, 9, 4, 5, 6, 5, 6}, {4, 9, 9, 7, 9, 1, 9, 0}};

        int[][] grid = {{1, 2, 5}, {3, 2, 1}};
        Solution3 solution = new Solution3();
        int minPathSum = solution.minPathSum(grid);
        System.out.println(minPathSum);
    }
}
