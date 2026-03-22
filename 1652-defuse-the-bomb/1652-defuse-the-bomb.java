class Solution {
    public int[] decrypt(int[] code, int k) {
       int n = code.length;
       int [] result = new int [n];
       
       // 1.  when K == 0

       if(k == 0) {
        return result;
       }

       int sum = 0;
       int start, end;
       // 2. when k is positive
       if( k > 0) {
        start = 1;
        end = k;
       }
       // 3.  when k is negative
       else {
        start = n + k;
        end = n - 1;
        k = - k;
       }

       // initial sum window
       for(int i = start; i <= end ; i++) {
        sum += code[i % n];
       }

       // sliding window

       for(int i = 0; i < n ; i++) {
        result [i] = sum;

        // remove outgoing element
        sum -= code[start % n];

        // move window forward
        start++;
        end++;

        // add incoming element
        sum += code[end % n];
       }
       return result;
    }
}