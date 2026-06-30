class Solution {
   public static int numberOfSubstrings(String s) {
        int[] freq = new int[3];
        int count = 0;
        int currCount = 0;
        int left = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
            if (freq[ch - 'a'] == 1) {
                currCount++;
            }
            while (currCount == 3) {
                count += (n - i);
                char c = s.charAt(left);
                freq[c - 'a']--;
                if (freq[c - 'a'] == 0) {
                    currCount--;
                }
                left++;
            }
        }

        return count;
    }
}