class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[][] maxdp = new long[m][n];
        long[][] mindp = new long[m][n];

        maxdp[0][0] = grid[0][0];
        mindp[0][0] = grid[0][0];

        // first row

        for(int i = 1; i <n; i++) {
            maxdp[0][i] = maxdp[0][i-1] * grid[0][i];
            mindp[0][i] = maxdp[0][i];
        }

        // first column

        for(int j = 1 ; j < m; j++) {
            maxdp[j][0] = maxdp[j - 1][0] * grid[j][0];
            mindp[j][0] = maxdp[j][0];
        }


        // fill the rest
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                long val = grid[i][j];

                long a = maxdp[i - 1][j] * val;
                long b = mindp[i - 1][j] * val;
                long c = maxdp[i][j - 1] * val;
                long d = mindp[i][j - 1] * val;


                maxdp[i][j] = Math.max(Math.max(a,b), Math.max(c,d));
                mindp[i][j] = Math.min(Math.min(a,b), Math.min(c,d));

            }
        }

        long result = maxdp[m - 1][n - 1];
        if(result < 0){
            return -1;
        }
        else {
            return (int) (result % 1000000007);
        }
    }
}