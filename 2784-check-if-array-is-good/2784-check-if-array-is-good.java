class Solution {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        int num = nums.length;
        int max = 0;
        for(int n : nums) {
            max = Math.max(n, max);
        }

        if(num != max + 1) {
            return false;
        }

        int [] freq =  new int [max + 1];

        for(int n : nums) {
            if(n > max || n < 1) {
                return false;
            }

            freq[n]++;
        }

        for(int i = 1 ; i < max; i++) {
            if(freq[i] != 1) {
                return false;
            }
        }
        return freq[max] == 2;
    }
}