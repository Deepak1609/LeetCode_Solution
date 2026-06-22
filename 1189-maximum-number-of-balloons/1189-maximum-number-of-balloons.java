class Solution {
    public int maxNumberOfBalloons(String text) {
        int n = text.length();
        int[] freq = new int[26];
        for(char ch: text.toCharArray()){
            freq[ch - 'a']++;
        }
        return Math.min(
            Math.min(freq['b' - 'a'], freq['a'-'a']),
            Math.min(Math.min(freq['l' - 'a']/2, freq['o' - 'a'] / 2), freq['n'-'a'])
                );
        // Map<String, Integer> map = new HashMap<>();



        
    }
}