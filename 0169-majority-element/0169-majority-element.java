class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int num : nums) {
            mp.put(num, mp.getOrDefault(num , 0)+1);

            if(mp.get(num)> n/ 2) {
                return num;
            }
        }
        return -1;

        
    }
}