public class Solution9 {

    // 另一种思路的二分法：个人感觉思路更清晰
    // https://blog.csdn.net/Jeanphorn/article/details/47028041
    // https://blog.csdn.net/Jeanphorn/article/details/47028041
    // https://blog.csdn.net/Jeanphorn/article/details/47028041

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int col = matrix[0].length;
        int left = 0;
        int right = row - 1;
        // 找行的最大索引
        // 2
        // 4
        // 7
        // 9
        // target = 7 的话，应该找到 4
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][0] > target) {
                right = mid - 1;
            } else if (matrix[mid][0] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        // 此时 left == right

        // 对每一行进行二分查找，这里 i 的上限写 left 或者 right 都是可以的
        for (int i = 0; i <= right; i++) {
            int l = 0;
            int r = col - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (matrix[i][mid] < target) {
                    l = mid + 1;
                } else if (matrix[i][mid] > target) {
                    r = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{}};
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
    }
}