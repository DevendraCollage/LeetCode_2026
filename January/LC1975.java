class Solution {
    public static long maxMatrixSum(int[][] matrix) {
        int minAbsValue = Integer.MAX_VALUE;
        int negatives = 0;
        long totalSum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int value = matrix[i][j];
                totalSum += Math.abs(value);
                if (value < 0) {
                    negatives++;
                }
                minAbsValue = Math.min(minAbsValue, Math.abs(value));
            }
        }

        if ((negatives & 1) == 0) {
            return totalSum;
        }

        // If negatives are odd, subtract twice the smallest absolute value
        return totalSum - 2 * minAbsValue;
    }
}