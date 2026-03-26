class Solution {
    public int findMaxLength(int[] nums) {
        
        int n = nums.length;
        int sum = 0;
        int maxL = 0;

        Map <Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for(int i = 0; i < n; i++) {
             int z = 0, o = 0;
           if(nums[i] == 0) {
            sum += -1;
           }
           else {
            sum += 1;
           }
           if(map.containsKey(sum)) {
            int prevIndex = map.get(sum);
            maxL = Math.max(maxL, i - prevIndex);
           }
           else {
            map.put(sum, i);
           }
        }
        return maxL;
    }
}