class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> m = new HashMap<>();

        // counting frequency of each number 
        for(int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }

        int maximumLength = 0;

        for(int key : m.keySet()) {
            if(m.containsKey(key + 1)) {
                int length = m.get(key) + m.get(key + 1);
                maximumLength = Math.max(maximumLength , length);
            }
        }
        return maximumLength;
    }
}