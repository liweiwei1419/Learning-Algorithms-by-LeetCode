// https://leetcode-cn.com/problems/unique-paths-ii/description/
// 留作练习
public class Solution3 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        // System.out.println(Arrays.toString(dp));
        return 0;
    }


    /**
     * [
     * [0,0,0],
     * [0,1,0],
     * [0,0,0]
     * ]
     *
     * @param args
     */
    public static void main(String[] args) {
        // write your code here
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        Solution3 solution = new Solution3();
        int uniquePathsWithObstacles = solution.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(uniquePathsWithObstacles);
    }
}
