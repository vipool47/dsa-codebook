/*
A parentheses string is valid if and only if:
    It is the empty string,
    It can be written as AB (A concatenated with B),
    where A and B are valid strings, or
    It can be written as (A), where A is a valid string.
You are given a parentheses string s. In one move, you can insert a parenthesis
at any position of the string.

Return the minimum number of moves required to make s valid.

Input: s = "())"
Output: 1
*/


package stack.medium;
import java.util.Stack;

public class MinimumAddToMakeParenthessesValid {
    // Optimal Solution
    public int minAddToMakeValid(String s) {
        int result = 0;
        int openB = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                openB++;
            }
            else if(ch == ')' && openB > 0){
                 openB--;
            }
            else{
                result++;
            }
        }

        return openB + result;
    }

    // Stack Solution
        public int minAddToMakeValidStack(String s) {
            int result = 0;
            Stack<Character> st = new Stack<>();

            for(int i=0; i<s.length(); i++){
                char ch = s.charAt(i);

                if(ch == '('){
                    st.push(ch);
                }
                else if(ch == ')' && !st.isEmpty()){
                    st.pop();
                }
                else{
                    result++;
                }
            }

            return st.size() + result;
        }
}
