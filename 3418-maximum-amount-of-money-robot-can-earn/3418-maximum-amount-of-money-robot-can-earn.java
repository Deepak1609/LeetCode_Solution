class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int[][][] dp = new int[m][n][3];

        // Initialize with very small values
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }

        // Base case
        for (int k = 0; k < 3; k++) {
            if (coins[0][0] >= 0) {
                dp[0][0][k] = coins[0][0];
            } else {
                if (k > 0) dp[0][0][k] = 0; // neutralize
                dp[0][0][k] = Math.max(dp[0][0][k], coins[0][0]);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                for (int k = 0; k < 3; k++) {

                    int bestPrev = Integer.MIN_VALUE;

                    if (i > 0) bestPrev = Math.max(bestPrev, dp[i-1][j][k]);
                    if (j > 0) bestPrev = Math.max(bestPrev, dp[i][j-1][k]);

                    if (bestPrev == Integer.MIN_VALUE) continue;

                    // Case 1: take value
                    dp[i][j][k] = Math.max(dp[i][j][k], bestPrev + coins[i][j]);

                    // Case 2: neutralize if negative
                    if (coins[i][j] < 0 && k > 0) {
                        int prevNeutral = Integer.MIN_VALUE;

                        if (i > 0) prevNeutral = Math.max(prevNeutral, dp[i-1][j][k-1]);
                        if (j > 0) prevNeutral = Math.max(prevNeutral, dp[i][j-1][k-1]);

                        if (prevNeutral != Integer.MIN_VALUE) {
                            dp[i][j][k] = Math.max(dp[i][j][k], prevNeutral);
                        }
                    }
                }
            }
        }

        return Math.max(dp[m-1][n-1][0],
               Math.max(dp[m-1][n-1][1], dp[m-1][n-1][2]));


        
    }
}