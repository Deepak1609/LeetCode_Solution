class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int res = 0;
        int l = 0, r = n - 1;
        while(l < r) {
            int area = (r - l) * Math.min(height[l], height[r]);
            res = Math.max(res, area);

            if(height [l] < height [r]) {
                l += 1;
            }
            else {
                r -= 1;
            }
        }
        return res;



        // int n = height.length;
        // int ans = 0;
        // for(int i = 0; i <n; i++) {
        //     for(int  j = 0; j <n; j++) {
        //         int area = (j - i) * Math.min(height[i], height[j]);
        //         ans = Math.max(area, ans);
        //     }
        // }
        // return ans;


    }
}