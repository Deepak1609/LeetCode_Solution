class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length - 1;
        while(n>=0)
        {
            if(digits[n]==9)
            {
                digits[n]=0;
            }
            else
            {
                digits[n] += 1;
                return digits;
            }
            n--;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;  // e.g., [9,9] → [1,0,0]
        return result;
         
    }
}