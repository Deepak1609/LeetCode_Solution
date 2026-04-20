class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int i = 0;
        int result = Integer.MIN_VALUE;
        while(colors[i] == colors[ n-1]){
            i++;
        }
        result = Math.max(result,Math.abs(i - (n-1)));
        int j = n - 1;
        while(colors[0] == colors[j]) {
            j--;            
        }
        result = Math.max(result,Math.abs(j));
        return result;
    }
}