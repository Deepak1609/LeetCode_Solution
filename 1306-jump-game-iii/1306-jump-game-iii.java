class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        if( start < 0 || start >= n || arr[start] < 0) {
            return false;
        }
        if(arr[start]==0) {
            return true;
        }
        arr[start] *= - 1;
        boolean a = canReach(arr, start + arr[start]);
        boolean b = canReach(arr, start - arr[start]);
        return a || b;    
    }
}