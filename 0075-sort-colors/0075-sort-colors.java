class Solution {
    public void sortColors(int[] nums) {
        // Initialize three pointers: low and mid at 0, high at the end
        int low = 0, mid = 0, high = nums.length - 1;
        while(mid <= high) {
         // If current element is 0, swap with low and move both low and mid forward
            if(nums[mid] == 0)
            {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                mid++;
                low++;
            }
            // If current element is 1, just move mid forward
            else if(nums[mid] == 1) {
                mid++;
            }
            // If current element is 2, swap with high and move only high backward

            else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high --;

            }

        }
        
    }
}