class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int cols = encodedText.length() / rows;

        char mat[][] = new char[rows][cols];
        int i = 0, j = 0;
        for (int ind = 0; ind < encodedText.length(); ind++) {
            mat[i][j] = encodedText.charAt(ind);
            if (j < cols - 1) {
                j++;
            } else {
                i++;
                j = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < cols; k++) {
            int slant = 0;
            for (int k2 = 0; k2 < rows; k2++) {
                if (k + slant < cols) {
                    sb.append(mat[k2][k + slant]);
                    slant++;
                }
            }
        }

        return sb.toString().stripTrailing();
    }
}