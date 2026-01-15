import java.util.Arrays;

class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        // sort
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int hstrip = 1, vstrip = 1;

        // Horizontal bars
        int currStrip = 1;
        int prevbar = hBars[0];

        for (int i = 1; i < hBars.length; i++) {
            if (hBars[i] == prevbar + 1) {
                currStrip++;
                hstrip = Math.max(hstrip, currStrip);
            } else {
                currStrip = 1;
            }
            prevbar = hBars[i];
        }

        // Vertical bars
        currStrip = 1;
        prevbar = vBars[0];

        for (int i = 1; i < vBars.length; i++) {
            if (vBars[i] == prevbar + 1) {
                currStrip++;
                vstrip = Math.max(vstrip, currStrip);
            } else {
                currStrip = 1;
            }
            prevbar = vBars[i];
        }

        int side = Math.min(hstrip, vstrip) + 1;
        return side * side;
    }
}