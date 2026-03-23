class Solution {
    public int reverse(int x) {
        int ans = 0;
        // boolean flag = false;
        // if(x < 0) {
        //     flag = true;
        //     x = Math.abs(x);
        // }
        while(x != 0) {
            int r = x % 10;
            x /= 10;
            // Check overflow BEFORE updating ans
            if (ans > Integer.MAX_VALUE / 10 || 
               (ans == Integer.MAX_VALUE / 10 && r > 7)) {
                return 0;
            }

            if (ans < Integer.MIN_VALUE / 10 || 
               (ans == Integer.MIN_VALUE / 10 && r < -8)) {
                return 0;
            }

            ans = ans * 10 + r;
         
        }
        // if(flag == true) {
        //     return (-ans);
        // }
        return ans;
    }
}