class Solution {
    // prefix sum array
    int[][] rowPref, colPref, diag1Prefix, diag2Prefix;

    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        buildPrefix(grid);

        int max = 1; // 1*1 already magic square

        for (int i = 2; i <= Math.min(m, n); i++) {
            for (int j = 0; j + i <= m; j++) {
                for (int j2 = 0; j2 + i <= n; j2++) {
                    if (checkMagic(j, j2, i)) {
                        max = Math.max(max, i);
                    }
                }
            }
        }

        return max;
    }

    void buildPrefix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        rowPref = new int[m][n + 1];
        colPref = new int[m + 1][n];
        diag1Prefix = new int[m + 1][n + 1];
        diag2Prefix = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowPref[i][j + 1] = rowPref[i][j] + grid[i][j];
                colPref[i + 1][j] = colPref[i][j] + grid[i][j];
                diag1Prefix[i + 1][j + 1] = diag1Prefix[i][j] + grid[i][j];
                diag2Prefix[i + 1][j] = diag2Prefix[i][j + 1] + grid[i][j];
            }
        }
    }

    boolean checkMagic(int row, int col, int side) {
        int target = rowPref[row][col + side] - rowPref[row][col];

        // rows
        for (int i = row; i < row + side; i++) {
            if (rowPref[i][col + side] - rowPref[i][col] != target) {
                return false;
            }
        }

        // cols
        for (int i = col; i < col + side; i++) {
            if (colPref[row + side][i] - colPref[row][i] != target) {
                return false;
            }
        }

        // diagonal1
        if (diag1Prefix[row + side][col + side] - diag1Prefix[row][col] != target) {
            return false;
        }

        if (diag2Prefix[row + side][col] - diag2Prefix[row][col + side] != target) {
            return false;
        }

        return true;
    }
}