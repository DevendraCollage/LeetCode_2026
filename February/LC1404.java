class Solution {
    public int numSteps(String s) {
        int ans = 0, carry = 0;
        char arr[] = s.toCharArray();

        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] - '0' + carry == 1) {
                carry = 1;
                ans += 2;
            } else {
                ans++;
            }
        }

        return ans + carry;
    }
}