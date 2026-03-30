class Solution {
    public boolean checkStrings(String s1, String s2) {
        int [] e1 = new int[26];
        int [] o1 = new int[26];
        int [] e2 = new int[26];
        int [] o2 = new int[26];

        int n = s1.length();

        for(int i = 0; i <n; i++) {
            if(i % 2 == 0) {
                e1[s1.charAt(i) - 'a']++;
                e2[s2.charAt(i) - 'a']++;
            }
            else {
                o1[s1.charAt(i) - 'a']++;
                o2[s2.charAt(i) - 'a']++;
            }
        }
        return Arrays.equals(e1,e2) && Arrays.equals(o1,o2);
    }
}