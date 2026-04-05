class Solution {
    public boolean judgeCircle(String moves) {
        int n = moves.length();
        int u = 0, d = 0, r = 0, l = 0;
        for(char s : moves.toCharArray()) {
         if(s== 'U') {
            u++;;
         }
         if(s == 'D') {
            d++;
         }
         if(s == 'L') {
            l++;
         }
         if(s == 'R') {
            r++;;
         }
        }
        if((u == d) && (l == r)) {
            return true;
        }
        else {
            return false;
        }
        
    }
}