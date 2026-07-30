class Solution {
    public int minimumPushes(String word) {
        int result = 0;
        for(int i = 0; i < word.length(); i++) {
            result += (i/8) + 1;
        }
        return result;
        
    }
}