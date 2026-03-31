class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        char[] word = new char[n + m - 1];

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (word[i + j] != '\u0000' && word[i + j] != str2.charAt(j)) {
                        return "";
                    } else {
                        word[i + j] = str2.charAt(j);
                    }
                }
            }
        }

        for (int i = 0; i < word.length; i++) {
            if (word[i] == '\u0000') {
                word[i] = 'a';
            }
        }

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                continue;
            }
            boolean match = true;
            for (int j = 0; j < m; j++) {
                if (word[i + j] != str2.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match == true) {
                boolean fixed = false;
                for (int j = m - 1; j >= 0; j--) {
                    if (setByT(i, j, str1, m) == false) {
                        char change = str2.charAt(j) == 'a' ? 'b' : 'a';
                        word[i + j] = change;
                        fixed = true;
                        break;
                    }
                }

                if (fixed == false) {
                    return "";
                }
            }
        }

        return new String(word);
    }

    boolean setByT(int i, int j, String str1, int m) {
        int first = Math.max(0, i + j - m + 1);
        int last = Math.min(i + j, str1.length() - 1);

        for (int ind = first; ind <= last; ind++) {
            if (str1.charAt(ind) == 'T')
                return true;
        }

        return false;
    }
}