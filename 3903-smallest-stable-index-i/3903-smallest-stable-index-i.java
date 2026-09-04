class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        // Step 1: suffix min array
        int[] suffixMini = new int[n];
        suffixMini[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMini[i] = Math.min(suffixMini[i + 1], nums[i]);
        }

        // Step 2: prefix max on the fly
        int prefixMaxi = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            prefixMaxi = Math.max(prefixMaxi, nums[i]);

            if (prefixMaxi - suffixMini[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}