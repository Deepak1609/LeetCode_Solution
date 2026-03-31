class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int len = n + m - 1;

        char[] word = new char[len];
        boolean[] fixed = new boolean[len];
        Arrays.fill(word, '?');

        // Step 1: Apply 'T'
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    int idx = i + j;
                    if (word[idx] != '?' && word[idx] != str2.charAt(j)) {
                        return "";
                    }
                    word[idx] = str2.charAt(j);
                    fixed[idx] = true;
                }
            }
        }

        // Step 2: Fill remaining with 'a'
        for (int i = 0; i < len; i++) {
            if (word[i] == '?') word[i] = 'a';
        }

        // Step 3: Handle 'F'
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                boolean match = true;

                for (int j = 0; j < m; j++) {
                    if (word[i + j] != str2.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    boolean broken = false;

                    // try to break using NON-FIXED positions
                    for (int j = m - 1; j >= 0; j--) {
                        int idx = i + j;

                        if (fixed[idx]) continue; // 🔥 critical

                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c != str2.charAt(j)) {
                                word[idx] = c;
                                broken = true;
                                break;
                            }
                        }

                        if (broken) break;
                    }

                    if (!broken) return "";
                }
            }
        }

        return new String(word);
    }
}