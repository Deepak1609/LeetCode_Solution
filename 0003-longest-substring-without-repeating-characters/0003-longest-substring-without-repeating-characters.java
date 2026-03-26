class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int maxL = 0;
        while(right < n )
        {
            char ch = s.charAt(right);
            if(!set.contains(ch)) {
                set.add(ch);
                maxL = Math.max(maxL, right - left + 1);
                right++;
            }
            else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxL;
        


        // int n = s.length();
        // int maxL = 0;
        // for(int i = 0; i <n ; i++) {
        //     Set<Character> set = new HashSet<>();
        //     for(int j = i; j < n; j++) {
        //         char ch = s.charAt(j);
        //         if(set.contains(ch)) {
        //             break;
        //         }
        //         set.add(ch);
        //         maxL = Math.max(maxL, j - i + 1);
        //     }
        // }
        // return maxL;
    }
}