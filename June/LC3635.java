class LC3635 {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int bestLandFinish = Integer.MAX_VALUE;
        int bestWaterFinish = Integer.MAX_VALUE;

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < landStartTime.length; i++) {
            bestLandFinish = Math.min(bestLandFinish, landStartTime[i] + landDuration[i]);
        }

        for (int i = 0; i < waterStartTime.length; i++) {
            int curr = Math.max(bestLandFinish, waterStartTime[i]) + waterDuration[i];
            ans = Math.min(ans, curr);
        }

        for (int i = 0; i < waterStartTime.length; i++) {
            bestWaterFinish = Math.min(bestWaterFinish, waterStartTime[i] + waterDuration[i]);
        }

        for (int i = 0; i < landStartTime.length; i++) {
            int curr = Math.max(bestWaterFinish, landStartTime[i]) + landDuration[i];
            ans = Math.min(ans, curr);
        }

        return ans;
    }
}