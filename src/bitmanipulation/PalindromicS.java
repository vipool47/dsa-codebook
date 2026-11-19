package bitmanipulation;

/*
You are given a string s consisting of lowercase English letters.

Construct a binary string by replacing each character in
s with the 8-bit binary representation of its ASCII value,
including leading zeros, while preserving the original order of the characters.

Return true if the resulting binary string is a palindrome. Otherwise, return false.
 */
public class PalindromicS {
        public boolean isPalindromic(String s) {

            // This will store the complete binary representation
            // of all characters in the string.
            StringBuilder bin = new StringBuilder();

            // Go through every character of the input string
            for (char c : s.toCharArray()) {

                // Convert the character to its ASCII/Unicode integer value
                // and then convert that integer into binary.
                //
                // Example:
                // 'A' -> 65 -> "1000001"
                String bits = String.format(
                                "%8s",                    // Make the string 8 characters wide
                                Integer.toBinaryString(c) // Convert character to binary
                        )
                        .replace(' ', '0');               // Replace spaces with 0s

                // Add the 8-bit binary representation to our result
                bin.append(bits);
            }

            // Example:
            // s = "AB"
            //
            // A = 65 = 01000001
            // B = 66 = 01000010
            //
            // bin = "0100000101000010"

            // Two pointers:
            // left starts from beginning
            // right starts from end
            int left = 0;
            int right = bin.length() - 1;

            // Compare characters from both ends
            while (left < right) {

                // If corresponding bits are different,
                // it cannot be a palindrome.
                if (bin.charAt(left) != bin.charAt(right)) {
                    return false;
                }

                // Move towards the center
                left++;
                right--;
            }

            // If every pair matched, it is a palindrome
            return true;
        }
}
