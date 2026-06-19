class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int gain1[] = new int[n + 1];
        gain1[0] = 0;
        int maxi = gain1[0];
        for(int i = 0, j = 1; i < n; i++) {
            gain1[j] = gain1[i] + gain[i];
            maxi = Math.max(gain1[j], maxi);
            j++;
        }
        return maxi;
    }
}