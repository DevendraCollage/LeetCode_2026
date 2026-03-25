class Solution {
    long rows[], cols[];

    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        rows = new long[m];
        cols = new long[n];
        long sum = getSum(grid);

        long currSum = rows[0];

        for (int i = 1; i < m; i++) {
            if (currSum >= sum - currSum) {
                return true;
            }
            currSum += rows[i];
        }

        currSum += cols[0];
        for (int i = 1; i < n; i++) {
            if (currSum == sum - currSum) {
                return true;
            }
            currSum = cols[i];
        }

        return false;
    }

    long getSum(int[][] grid) {
        long sum = 0;
        for (int i = 0; i < grid.length; i++) {
            long rowSum = 0;
            for (int j = 0; j < grid[0].length; j++) {
                sum += grid[i][j];
                rowSum += grid[i][j];
            }
            rows[i] = rowSum;
        }

        for (int i = 0; i < grid[0].length; i++) {
            long colSum = 0;
            for (int j = 0; j < grid.length; j++) {
                colSum += grid[i][j];
            }
            cols[i] = colSum;
        }

        return sum;
    }
}