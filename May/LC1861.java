class Solution {
    public static char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;
        char[][] ans = new char[n][m];

        for (int i = 0; i < m; i++) {
            char[] row = applyGravity(box[i]);

            for (int j = 0; j < n; j++) {
                ans[j][m - 1 - i] = row[j];
            }
        }

        return ans;
    }

    // Helper function to fill the boxes
    private static char[] applyGravity(char[] row) {
        int stones = 0, cells = 0;
        for (int i = 0; i < row.length; i++) {
            if (row[i] == '*') {
                int j = i - 1;
                while (cells-- > 0) {
                    if (stones > 0) {
                        stones -= 1;
                        row[j] = '#';
                    } else {
                        row[j] = '.';
                    }
                    j--;
                }
            } else if (row[i] == '#') {
                stones++;
            }
            cells++;
        }
        int j = row.length - 1;
        while (cells-- > 0) {
            if (stones > 0) {
                stones -= 1;
                row[j] = '#';
            } else {
                row[j] = '.';
            }
            j--;
        }

        return row;
    }
}