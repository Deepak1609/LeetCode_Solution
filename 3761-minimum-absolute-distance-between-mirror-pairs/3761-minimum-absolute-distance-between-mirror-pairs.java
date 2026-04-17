class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            // Step 1: Check if current number was seen as reverse before
            if (mp.containsKey(nums[i])) {
                result = Math.min(result, i - mp.get(nums[i]));
            }

            // Step 2: Compute reverse
            int rev = reverse(nums[i]);

            // Step 3: Store reverse as key
            mp.put(rev, i);
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    int reverse(int n) {
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + (n % 10);
            n /= 10;
        }
        return rev;
    }
}