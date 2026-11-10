package string.medium;

/*
You are given a string s consisting of lowercase English letters and the special characters: *, #, and %.

Build a new string result by processing s according to the following rules from left to right:

    If the letter is a lowercase English letter append it to result.
    A '*' removes the last character from result, if it exists.
    A '#' duplicates the current result and appends it to itself.
    A '%' reverses the current result.

Return the final string result after processing all characters in s.
*/
public class ProcessStringWithSpecialOpsI {
    public String processStr(String s) {
        
        StringBuilder result = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (Character.isLowerCase(ch)) {
                result.append(ch);
            }
            else if (ch == '*' && result.length() > 0) {
                result.deleteCharAt(result.length() - 1);
            }
            else if (ch == '#') {
                result.append(result);
            }
            else if (ch == '%') {
                result.reverse();
            }
        }

        return result.toString();
    }
}
