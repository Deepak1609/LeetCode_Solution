class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int [] c = new int [A.length];
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();

        int common = 0;

        for(int i = 0; i < A.length; i++) {

            if(A[i] == B[i]) {
                common++;
            }
            else {
                if(setB.contains(A[i])) {
                    common++;
                }
                if(setA.contains(B[i])) {
                    common++;
                }
            }
            setA.add(A[i]);
            setB.add(B[i]);
            c[i] = common;
        }
        return c;
    }
}