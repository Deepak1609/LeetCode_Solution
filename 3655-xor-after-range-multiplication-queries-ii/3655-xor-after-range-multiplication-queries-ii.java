class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int MOD = 1_000_000_007;
        int B = (int) Math.sqrt(n) + 1;

        // bucket[k][rem] → list of queries
        List<int[]>[][] bucket = new ArrayList[B][B];
        for (int i = 0; i < B; i++) {
            for (int j = 0; j < B; j++) {
                bucket[i][j] = new ArrayList<>();
            }
        }

        List<int[]> large = new ArrayList<>();

        for (int[] q : queries) {
            int k = q[2];
            if (k < B) {
                int rem = q[0] % k;
                bucket[k][rem].add(q);
            } else {
                large.add(q);
            }
        }

        // Handle large k directly
        for (int[] q : large) {
            int l = q[0], r = q[1], k = q[2], v = q[3];
            for (int i = l; i <= r; i += k) {
                nums[i] = (int)((1L * nums[i] * v) % MOD);
            }
        }

        // Handle small k
        for (int k = 1; k < B; k++) {
            for (int rem = 0; rem < k; rem++) {

                List<Integer> positions = new ArrayList<>();
                for (int i = rem; i < n; i += k) {
                    positions.add(i);
                }

                int m = positions.size();
                long[] diff = new long[m + 1];
                Arrays.fill(diff, 1);

                // Apply queries
                for (int[] q : bucket[k][rem]) {
                    int l = q[0], r = q[1], v = q[3];

                    // binary search on positions
                    int left = lowerBound(positions, l);
                    int right = upperBound(positions, r) - 1;

                    if (left <= right) {
                        diff[left] = (diff[left] * v) % MOD;
                        if (right + 1 < m) {
                            long inv = modInverse(v, MOD);
                            diff[right + 1] = (diff[right + 1] * inv) % MOD;
                        }
                    }
                }

                // prefix multiply
                long mul = 1;
                for (int i = 0; i < m; i++) {
                    mul = (mul * diff[i]) % MOD;
                    int idx = positions.get(i);
                    nums[idx] = (int)((nums[idx] * mul) % MOD);
                }
            }
        }

        int ans = 0;
        for (int x : nums) ans ^= x;
        return ans;
    }

    private int lowerBound(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private int upperBound(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) > target) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private long modInverse(long a, int mod) {
        return power(a, mod - 2, mod);
    }

    private long power(long a, long b, int mod) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }
}