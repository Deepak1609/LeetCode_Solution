class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int ans = sum;

        for(int i = k; i < n; i++) {
            sum += nums[i]; // adding the next element in the sum by moving forward
            sum -= nums[i-k]; // removing the element from starting to maintain the window
            ans = Math.max(ans, sum);
        }
        return (double) ans/k;
    }
}