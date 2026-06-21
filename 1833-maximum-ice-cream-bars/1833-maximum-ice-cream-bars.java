class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int result = 0;
        int n = costs.length;
        Arrays.sort(costs);
        for(int i = 0; i < n; i++) {
            if(coins > 0 && costs[i]<= coins) {

                result++;
                coins -= costs[i];
            }
            else{
                break;
            }
        }
        return result;

        
    }
}