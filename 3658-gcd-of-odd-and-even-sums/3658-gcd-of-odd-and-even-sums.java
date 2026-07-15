class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0;
        int sumEven = 0;

        for (int i = 1; i <= n * 2; i++) {
            if (i % 2 == 0) {
                sumEven += i;
            } else {
                sumOdd += i;
            }
        }

        return helperGcd(sumOdd, sumEven);
    }

    static int helperGcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return helperGcd(b, a % b);   // Missing return
    }
}