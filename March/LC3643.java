class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int m = grid.length, n = grid[0].length;
        int top = x, bottom = x + k - 1;

        while (top < bottom) {
            for (int i = y; i < y + k; i++) {
                int temp = grid[top][i];
                grid[top][i] = grid[bottom][i];
                grid[bottom][i] = temp;
            }

            top++;
            bottom--;
        }

        return grid;
    }
}