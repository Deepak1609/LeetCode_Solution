class Solution {
    public int totalWaviness(int num1, int num2) {
        int result = 0;
        for(int i = num1; i <= num2; i++) {
            result += findWaveness(i);

        }
        return result;
        
    }
    private int findWaveness(int n) {
         String s = Integer.toString(n);

        int cnt = 0;

        for (int i = 1; i < s.length() - 1; i++) {
            char cur = s.charAt(i);

            if ((cur > s.charAt(i - 1) && cur > s.charAt(i + 1)) ||
                (cur < s.charAt(i - 1) && cur < s.charAt(i + 1))) {
                cnt++;
            }
        }

        return cnt;    
    }
}