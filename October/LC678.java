class Solution {
    Boolean[][] memo;

    public boolean checkValidString(String s) {

        memo = new Boolean[s.length()][s.length() + 1];

        return solve(s, 0, 0);
    }

    private boolean solve(String s, int index, int balance) {

        if (balance < 0) {
            return false;
        }

        if (index == s.length()) {
            return balance == 0;
        }

        if (memo[index][balance] != null) {
            return memo[index][balance];
        }

        char currentCharacter = s.charAt(index);

        boolean result;

        if (currentCharacter == '(') {

            result = solve(s, index + 1, balance + 1);
        }

        else if (currentCharacter == ')') {

            result = solve(s, index + 1, balance - 1);
        }

        else {

            boolean useAsOpening = solve(s, index + 1, balance + 1);

            boolean useAsClosing = solve(s, index + 1, balance - 1);

            boolean useAsEmpty = solve(s, index + 1, balance);

            result = useAsOpening ||
                    useAsClosing ||
                    useAsEmpty;
        }

        memo[index][balance] = result;

        return result;
    }

}