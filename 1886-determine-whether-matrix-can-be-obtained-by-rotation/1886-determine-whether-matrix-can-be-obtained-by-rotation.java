class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        // number of times matix rotation 0, 90, 180, 270
        for(int k = 0; k < 4; k++) {
            if(isEqual(mat, target)) {
                return true;
            }
            rotateArray(mat);
        }
        return false;
    }

    private void rotateArray(int[][] mat) {
        int n = mat.length;

        // 1. first will transpose and then reverse will get the one rotation

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;

            }
        }

        // now reverse each row

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][n - 1 - j];
                mat[i][n - 1 - j] = temp;
            }
        }
    }

    private boolean isEqual(int[][] a, int[][] b) {
        int n = a.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}