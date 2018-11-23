public class Solution5 {

    // 这种写法最清晰了
    // 从右上角开始, 比较 target 和 matrix[x][y] 的值
    // 如果小于 target，则该行不可能有此数，所以 x++
    // 如果大于 target，则该列不可能有此数，所以 y--
    // 遇到边界则表明该矩阵不含 target

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int col = matrix[0].length;
        // 站在右上角
        int x = 0;
        int y = col - 1;
        while (x < row && y >= 0) {
            // 打开注释，可以用于调试的代码
            // System.out.println("沿途走过的数字：" + matrix[x][y]);
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 5;
        Solution5 solution5 = new Solution5();
        boolean searchMatrix = solution5.searchMatrix(matrix, target);
        System.out.println(searchMatrix);
    }
}
