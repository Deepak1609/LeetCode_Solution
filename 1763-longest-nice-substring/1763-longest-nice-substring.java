class Solution {
    public String longestNiceSubstring(String s) {
         if (s.length() < 2) return "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // check if both cases exist
            if (s.indexOf(Character.toLowerCase(c)) == -1 ||
                s.indexOf(Character.toUpperCase(c)) == -1) {

                // split and recurse
                String left = longestNiceSubstring(s.substring(0, i));
                String right = longestNiceSubstring(s.substring(i + 1));

                return left.length() >= right.length() ? left : right;
            }
        }

        // whole string is nice
        return s;
        
    }
}