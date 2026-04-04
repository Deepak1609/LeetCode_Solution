class Solution {
    void reverseArray(int[] nums, int start, int end) {
        // Swap elements until start meets end
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        // Normalize k if greater than n
        k = k % n;
        // Step 1: reverse entire array
        reverseArray(nums, 0, n - 1);

        // Step 2: reverse first k elements
        reverseArray(nums, 0, k - 1);

        // Step 3: reverse remaining n-k elements
        reverseArray(nums, k, n - 1);
    }
}