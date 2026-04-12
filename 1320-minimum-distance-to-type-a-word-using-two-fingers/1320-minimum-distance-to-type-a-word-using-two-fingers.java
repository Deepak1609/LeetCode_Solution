class Solution {
    public int minimumDistance(String word) {
        int n = word.length();

        // dp[j] = min cost where other finger is at j
        int[] dp = new int[26];

        for (int i = 1; i < n; i++) {
            int[] newDp = new int[26];
            for (int k = 0; k < 26; k++) newDp[k] = Integer.MAX_VALUE;

            int prev = word.charAt(i - 1) - 'A';
            int curr = word.charAt(i) - 'A';

            for (int j = 0; j < 26; j++) {
                if (dp[j] == Integer.MAX_VALUE) continue;

                // Case 1: same finger
                newDp[j] = Math.min(newDp[j],
                        dp[j] + dist(prev, curr));

                // Case 2: use other finger
                newDp[prev] = Math.min(newDp[prev],
                        dp[j] + dist(j, curr));
            }

            dp = newDp;
        }

        int ans = Integer.MAX_VALUE;
        for (int x : dp) ans = Math.min(ans, x);

        return ans;
    }

    private int dist(int a, int b) {
        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}