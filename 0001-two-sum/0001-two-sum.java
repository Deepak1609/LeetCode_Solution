class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
       for(int i = 0; i < n; i++) {
        int res = target - nums[i];
        if(mp.containsKey(res)) {
            return new int[] {mp.get(res),i};
        }
        mp.put(nums[i], i);
       } 
       return new int[] {-1,-1};
}
}