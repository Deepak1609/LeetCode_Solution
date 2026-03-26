class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        for(int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while(sum >= target) {
                minLen = Math.min(minLen , right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;


        // int n = nums.length;
        // int minLen = Integer.MAX_VALUE;
        // for(int i = 0; i <n; i++) {
        //     int sum = 0;
        //     for(int j = i; j <n; j++) {
        //         sum += nums[j];
        //         if(sum >=  target){
        //             minLen = Math.min(minLen, j - i + 1);
        //             break;
        //         }
        //     }
        // }
        // return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}