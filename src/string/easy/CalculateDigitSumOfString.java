package string.easy;

/*
You are given a string s consisting of digits and an integer k.

A round can be completed if the length of s is greater than k. In one round, do the following:

    Divide s into consecutive groups of size k such that the first k characters are in the first group, the next k characters are in the second group, and so on. Note that the size of the last group can be smaller than k.
    Replace each group of s with a string representing the sum of all its digits. For example, "346" is replaced with "13" because 3 + 4 + 6 = 13.
    Merge consecutive groups together to form a new string. If the length of the string is greater than k, repeat from step 1.

Return s after all rounds have been completed.

Input: s = "11111222223", k = 3
Output: "135"
Explanation: 
- For the first round, we divide s into groups of size 3: "111", "112", "222", and "23".
  ​​​​​Then we calculate the digit sum of each group: 1 + 1 + 1 = 3, 1 + 1 + 2 = 4, 2 + 2 + 2 = 6, and 2 + 3 = 5. 
  So, s becomes "3" + "4" + "6" + "5" = "3465" after the first round.
- For the second round, we divide s into "346" and "5".
  Then we calculate the digit sum of each group: 3 + 4 + 6 = 13, 5 = 5. 
  So, s becomes "13" + "5" = "135" after second round. 
Now, s.length <= k, so we return "135" as the answer.

*/
public class CalculateDigitSumOfString {
    public String digitSum(String s, int k) {

        while (s.length() > k) {
            // StringBuilder to build the next string after summing the digits of each group
            StringBuilder next = new StringBuilder();

            // Loop through the string in increments of k to create groups
            for (int i = 0; i < s.length(); i += k) {
                // Get the current group of size k (or less if at the end of the string)
                // Math.min is used to ensure we don't go out of bounds if the last group is smaller than k
                String group = s.substring(i, Math.min(i + k, s.length()));

                int sum = 0;

                // Loop through each character in the group to calculate the sum of its digits
                for (int j = 0; j < group.length(); j++) {
                    sum += group.charAt(j) - '0';
                }

                // Append the sum of the current group to the next string
                next.append(sum);
            }

            // Update s to be the newly formed string after processing all groups
            s = next.toString();
        }

        return s;
    }
}


/*
Dry Run :
input s = "11111222223" and k = 3.

1. Initial string: s = "11111222223", k = 3
2. First round:
   - String group1 = substring of s from index 0 to 3: "111" -- (Math.min(0 + 3, 11) = 3)
   - String group2 = substring of s from index 3 to 6: "112" -- (Math.min(3 + 3, 11) = 6)
   - String group3 = substring of s from index 6 to 9: "222" -- (Math.min(6 + 3, 11) = 9)
   - String group4 = substring of s from index 9 to 11: "23" -- (Math.min(9 + 3, 11) = 11)
   - So the groups are: "111", "112", "222", "23"
   - Calculate digit sums:
     - "111" -> 1 + 1 + 1 = 3
     - "112" -> 1 + 1 + 2 = 4
     - "222" -> 2 + 2 + 2 = 6
     - "23"  -> 2 + 3 = 5
   - New string after first round: s = "3465"
3. Second round:
   - Divide into groups: "346", "5"
   - Calculate digit sums:
     - "346" -> 3 + 4 + 6 = 13
     - "5"   -> 5
   - New string after second round: s = "135"
4. Now, s.length() = 3 which is equal to k, so we stop and return "135" as the final result.
*/