package string.medium;

/*
You are given a 0-indexed binary string s having an even length.

A string is beautiful if it's possible to partition it into one or more substrings such that:

    Each substring has an even length.
    Each substring contains only 1's or only 0's.

You can change any character in s to 0 or 1.

Return the minimum number of changes required to make the string s beautiful.

Input: s = "1001"
Output: 2
Explanation: We change s[1] to 1 and s[3] to 0 to get string "1100".
It can be seen that the string "1100" is beautiful because we can partition it into "11|00".
It can be proven that 2 is the minimum number of changes needed to make the string beautiful.
*/
public class MinimumNumberOfStringsToMakeBinary {
    // --- Optimal Approach --- (After some hints)
    public int minChanges(String s) {
        int result = 0;

        // check every two characters in the string and if they are different, we need to change one of them
        for(int i=0; i<s.length(); i+=2){
            // if the current character is different from the next character, we need to change one of them
            if(s.charAt(i) != s.charAt(i+1)){
                result++;
            }
        }

        return result;
    }

    // --------- Better Approach --------- (My own approach)
    public int minChangesBetter(String s) {
        int result = 0;
        int count = 0;
        char prevChar = s.charAt(0);

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            // if the current character is different from the previous character and count is 1, we need to change it
            if(ch != prevChar && count == 1){
                result++;
                count = 0;
            }
            // if the current character is the same as the previous character and count is 1, we can reset count
            else if(ch == prevChar && count == 1){
                count = 0;
            }
            // if the current character is different from the previous character and count is 0, we can set prevChar to the current character and increment count
            else{
                prevChar = s.charAt(i);
                count++;
            }
        }

        return result;
    }
}
