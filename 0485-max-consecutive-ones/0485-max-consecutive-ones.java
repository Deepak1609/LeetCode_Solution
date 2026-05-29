class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int ones = 0,result = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] == 1) {
                ones++;
            }
            else{
                ones = 0;
            }
            result = Math.max(result, ones);
        }
        return result;
        
    }
}