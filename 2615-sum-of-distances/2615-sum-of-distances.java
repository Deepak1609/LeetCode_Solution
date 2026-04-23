class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long [] result = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Step 1: Group indices
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // Step 2: Process each group
        for (List<Integer> list : map.values()) {
            int size = list.size();
            long[] prefix = new long[size];

            // Prefix sum of indices
            prefix[0] = list.get(0);
            for (int i = 1; i < size; i++) {
                prefix[i] = prefix[i - 1] + list.get(i);
            }

            long total = prefix[size - 1];

            for (int i = 0; i < size; i++) {
                int index = list.get(i);

                // Left contribution
                long left = (long) index * i - (i > 0 ? prefix[i - 1] : 0);

                // Right contribution
                long right = (total - prefix[i]) - (long) index * (size - i - 1);

                result[index] = left + right;
            }
        }

        return result;




        
    }
}