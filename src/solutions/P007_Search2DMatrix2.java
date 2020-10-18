package solutions;

/**
 * Created by yesongren on 2020/10/18
 * 240. Search a 2D Matrix II
 */
public class P007_Search2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] > target) --j;
            else if (matrix[i][j] < target) ++i;
            else return true;
        }
        return false;
    }
}
