public class Solution5 {

    // 参考资料：http://www.cnblogs.com/anne-vista/p/5135401.html

    public int searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = matrix[0].length;
        int res = 0;
        // 从左下角开始找
        int rowIndexMax = getRowIndexMax(matrix, target);
        for (int i = 0; i <= rowIndexMax; i++) {
            // 每一行都用二分去找，找到了 res + 1
            if (find(matrix[i], target)) {
                res++;
            }
        }
        return res;
    }

    private boolean find(int[] row, int target) {
        int left = 0;
        int right = row.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    private int getRowIndexMax(int[][] matrix, int target) {
        int row = matrix.length;
        // 先找行号的最大值
        int left = 0;
        int right = row - 1;

        // 1
        // 3
        // 7
        // 9
        // target = 6 的话，找到 3


        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][0] == target) {
                return mid;
            } else if (matrix[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return right;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {2, 4, 7, 8},
                {3, 5, 9, 10}
        };

        int target = 3;
        Solution5 solution = new Solution5();
        int searchMatrix = solution.searchMatrix(matrix, target);
        System.out.println(searchMatrix);
    }
}
