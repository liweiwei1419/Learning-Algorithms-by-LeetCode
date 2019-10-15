/**
 * @author liweiwei1419
 * @date 2019/9/23 4:33 下午
 */
public class Solution {

    // 深度优先遍历

    private int m;
    private int n;
    private char[][] board;
    private int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public void solve(char[][] board) {
        m = board.length;
        if (m == 0) {
            return;
        }
        n = board[0].length;
        if (n == 0) {
            return;
        }
        this.board = board;

        // 第 1 列和最后 1 列
        for (int i = 0; i < m; i++) {
            floodFill(i, 0);
            floodFill(i, n - 1);
        }

        // 第 1 行和最后 1 行
        for (int i = 1; i < n - 1; i++) {
            floodFill(0, i);
            floodFill(m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '-') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    private void floodFill(int i, int j) {
        if (inArea(i, j) && board[i][j] == 'O') {
            board[i][j] = '-';
            for (int k = 0; k < 4; k++) {
                int newX = i + directions[k][0];
                int newY = j + directions[k][1];
                floodFill(newX, newY);
            }
        }
    }
}
