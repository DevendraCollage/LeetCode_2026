class Solution {
    public double separateSquares(int[][] squares) {
        double left = Double.MAX_VALUE, right = 0;
        double totalArea = 0.0;

        for (int[] square : squares) {
            double y = square[1];
            double side = square[2];
            totalArea += side * side;
            left = Math.min(left, y);
            right = Math.max(right, y + side);
        }

        while (right - left > 1e-5) {
            double mid = (left + right) / 2.0;
            double aboveArea = getArea(mid, squares);

            if (aboveArea > totalArea / 2.0) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return (left + right) / 2.0;
    }

    double getArea(double yline, int[][] squares) {
        double area = 0.0;

        for (int[] square : squares) {
            double y = square[1];
            double side = square[2];

            if (y >= yline) {
                area += side * side;
            } else if (y + side > yline) {
                area += (y + side - yline) * side;
            }
        }
        return area;
    }
}
