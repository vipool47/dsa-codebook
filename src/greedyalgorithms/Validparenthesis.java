package greedyalgorithms;
/*
 Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

Input: s = "(*))"
Output: true
 */


public class Validparenthesis {
    public boolean checkValidString(String s) {
        int min = 0; // Minimum possible open '(' brackets
        int max = 0; // Maximum possible open '(' brackets

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                // '(' always increases both min and max
                min++;
                max++;
            } else if (ch == ')') {
                // ')' decreases both
                min--;
                max--;
            } else if (ch == '*') {
                // '*' can be '(', ')' or empty
                // So we consider all 3 possibilities:
                // - If '*' is ')', min decreases
                // - If '*' is '(', max increases
                min--;
                max++;
            }

            // If at any point, max becomes negative, too many ')'
            if (max < 0) {
                return false;
            }

            // min should never be less than 0, because we can't have negative open brackets
            if (min < 0) {
                min = 0;
            }
        }

        // If min is zero, it means we found a valid way to balance
        return min == 0;
    }
    public static void main(String[] args) {
        Validparenthesis sol = new Validparenthesis();

        String[] testCases = {
                "()",        // true
                "(*)",       // true
                "(*))",      // true
                "((*)",      // true
                "(((******))", // true
                "((())",     // false
                ")*(",       // false
                "*",         // true
                "(((((*)))**" // false
        };

        for (String s : testCases) {
            System.out.println("Input: \"" + s + "\" -> " + sol.checkValidString(s));
        }
    }
}
