import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Step 1: store indices
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int minDist = Integer.MAX_VALUE;

        // Step 2: process each value
        for (List<Integer> list : map.values()) {
            if (list.size() < 3) continue;

            for (int i = 0; i + 2 < list.size(); i++) {
                int left = list.get(i);
                int right = list.get(i + 2);

                int dist = 2 * (right - left);
                minDist = Math.min(minDist, dist);
            }
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}