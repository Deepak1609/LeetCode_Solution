class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int k = 0;
        while(k < n) {
            if(nums[k] == val) {
                // int t = nums[i];
                nums[k] = nums[n - 1];
                n--;
            }
            else {
                k++;
            }
        }
        return n;
    }
} 