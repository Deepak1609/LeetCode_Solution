class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int idx = queries[q];
            int val = nums[idx];

            List<Integer> list = map.get(val);

            if (list.size() == 1) {
                ans[q] = -1;
                continue;
            }

            int pos = Collections.binarySearch(list, idx);

            int res = Integer.MAX_VALUE;

            int prevIndex = list.get((pos - 1 + list.size()) % list.size());
            int dist1 = Math.abs(idx - prevIndex);
            res = Math.min(res, Math.min(dist1, n - dist1));

            int nextIndex = list.get((pos + 1) % list.size());
            int dist2 = Math.abs(idx - nextIndex);
            res = Math.min(res, Math.min(dist2, n - dist2));

            ans[q] = res;
        }

        // 🔥 Convert int[] → List<Integer>
        List<Integer> result = new ArrayList<>();
        for (int x : ans) {
            result.add(x);
        }

        return result;
    }
}