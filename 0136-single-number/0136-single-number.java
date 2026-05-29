class Solution {
    public int singleNumber(int[] nums) {
        int xorr = 0;
        for(int i : nums) {
            xorr ^= i;
        }
        return xorr;
        
    }
}