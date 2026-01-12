class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0, n = points.length;
        for (int index = 1; index < n; index++) {
            ans += Math.max(Math.abs(points[index][0] - points[index - 1][0]),
                    Math.abs(points[index][1] - points[index - 1][1]));
        }

        return ans;
    }
}