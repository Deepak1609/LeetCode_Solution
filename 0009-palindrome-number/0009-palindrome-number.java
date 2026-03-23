class Solution {
    public boolean isPalindrome(int x) {
        int y = x;
        int ans = 0;
        while(x > 0) {
            int r = x % 10;
            ans = ans * 10 + r;
            x /= 10;
        }
        if(y == ans){
            return true;
        }
        else{
            return false;
        }
        
    }
}