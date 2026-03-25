class Solution {
    public int maxFrequency(int[] nums, int k) {
        long n = nums.length;
        Arrays.sort(nums);
        int l = 0, r = 0;
        long res = 0, total = 0;
        while(r < n) {
            total += nums[r];
            while((long) nums[r] * (r - l + 1) > total + k) {
                total -= nums[l];
                l++;               
            }
            res = Math.max(res, r - l + 1);
            r++;
        }

        return (int)res;
    }
}