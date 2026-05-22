class Solution {
    public int maxProfit(int[] prices) {
        int n = Integer.MAX_VALUE;
        int s = 0;
        for(int p : prices) {
            n = Math.min(n, p);
            s = Math.max(s, p - n);

        }
        return s;
        
    }
}