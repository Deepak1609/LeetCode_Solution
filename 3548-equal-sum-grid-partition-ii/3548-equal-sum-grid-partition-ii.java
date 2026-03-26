import java.util.*;

class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        long total = 0;
        for (int[] row : grid)
            for (int val : row)
                total += val;

        // ---------- HORIZONTAL CUT ----------
        long top = 0;
        Map<Integer, Integer> topMap = new HashMap<>();
        Map<Integer, Integer> bottomMap = new HashMap<>();

        for (int[] row : grid)
            for (int val : row)
                bottomMap.put(val, bottomMap.getOrDefault(val, 0) + 1);

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                int val = grid[i][j];

                top += val;

                topMap.put(val, topMap.getOrDefault(val, 0) + 1);
                bottomMap.put(val, bottomMap.get(val) - 1);
                if (bottomMap.get(val) == 0) bottomMap.remove(val);
            }

            long bottom = total - top;

            if (top == bottom) return true;

            long diff = Math.abs(top - bottom);

            if (top > bottom) {
                if (canRemove(grid, diff, 0, i, 0, m - 1, topMap)) return true;
            } else {
                if (canRemove(grid, diff, i + 1, n - 1, 0, m - 1, bottomMap)) return true;
            }
        }

        // ---------- VERTICAL CUT ----------
        long left = 0;
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();

        for (int[] row : grid)
            for (int val : row)
                rightMap.put(val, rightMap.getOrDefault(val, 0) + 1);

        for (int j = 0; j < m - 1; j++) {
            for (int i = 0; i < n; i++) {
                int val = grid[i][j];

                left += val;

                leftMap.put(val, leftMap.getOrDefault(val, 0) + 1);
                rightMap.put(val, rightMap.get(val) - 1);
                if (rightMap.get(val) == 0) rightMap.remove(val);
            }

            long right = total - left;

            if (left == right) return true;

            long diff = Math.abs(left - right);

            if (left > right) {
                if (canRemove(grid, diff, 0, n - 1, 0, j, leftMap)) return true;
            } else {
                if (canRemove(grid, diff, 0, n - 1, j + 1, m - 1, rightMap)) return true;
            }
        }

        return false;
    }

    // Check if we can remove a cell with value = diff
    private boolean canRemove(int[][] grid, long diff,
                              int r1, int r2, int c1, int c2,
                              Map<Integer, Integer> map) {

        if (diff > 100000) return false;

        int d = (int) diff;
        if (!map.containsKey(d)) return false;

        int rows = r2 - r1 + 1;
        int cols = c2 - c1 + 1;

        // ✅ Case 1: Proper 2D → always safe
        if (rows > 1 && cols > 1) {
            return true;
        }

        // ❗ Case 2: Single row → only edges allowed
        if (rows == 1) {
            return grid[r1][c1] == d || grid[r1][c2] == d;
        }

        // ❗ Case 3: Single column → only edges allowed
        if (cols == 1) {
            return grid[r1][c1] == d || grid[r2][c1] == d;
        }

        return false;
    }
}