class Solution {
    public int minElement(int[] nums) {
        int n = nums.length;
        int mini =Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int sumDigit = 0;
            while(nums[i]>0) {
                int r = nums[i] % 10;
                sumDigit += r;
                nums[i] /= 10;
            }
            nums[i] = sumDigit;
            mini = Math.min(nums[i], mini);
        }
        return mini;
    }
}