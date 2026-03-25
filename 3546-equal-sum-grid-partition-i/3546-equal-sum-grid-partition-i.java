class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        long total = 0;

        for(int[] row : grid) {
            for(int val : row) {
                total += val;
            }
        }

        // now checking in row
        long rowSum = 0;
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < m ; j++) {
                rowSum += grid[i][j];
            }
            if(total - rowSum == rowSum) {
                return true;
            }
        }

        // check in column
        long colSum = 0;
        for(int j = 0; j < m - 1; j++) {
            for(int i = 0; i < n; i++) {
                colSum += grid[i][j];
            }
            if(total - colSum == colSum) {
                return true;
            }
        }

        return false;
    }
}