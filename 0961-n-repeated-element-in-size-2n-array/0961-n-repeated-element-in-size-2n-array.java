class Solution {
    public int repeatedNTimes(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len - 2; i++) {
            if(nums[i] == nums[i+1] || nums[i]==nums[i+2]){
               return nums [i];
            }
        }
        return nums[len - 1];
    }
}