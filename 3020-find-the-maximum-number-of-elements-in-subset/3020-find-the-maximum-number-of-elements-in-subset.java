class Solution {
    public int maximumLength(int[] nums) {
        Map<Long,Integer> freq = new HashMap<>();
        for(int x : nums) {
            freq.put((long) x, freq.getOrDefault((long)x, 0)+1);
        }

        int ans = 1;

        // for 1 case
        if(freq.containsKey(1L)){
            int ones = freq.get(1L);
            ans = Math.max(ans, ones % 2 == 0 ? ones - 1 : ones);
        }

        for(long start : freq.keySet()){
            if(start == 1) {
                continue;
            }
            long curr = start;
            int pair = 0;
            while(freq.getOrDefault(curr, 0)>=2) {
                long next = curr * curr;
                if(!freq.containsKey(next)) {
                    break;
                }
                pair++;
                curr = next;
            }
            int len;
            if(pair == 0) {
                len = 1;
            }
            else {
                len = pair * 2 + 1;
            }
            ans = Math.max(ans, len);
        }
        return ans;
    }
}