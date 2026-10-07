package hashmap.medium;

import java.util.HashMap;
import java.util.Map;
/*
You are given a string word. A letter c is called special if it 
appears both in lowercase and uppercase in word, and every lowercase
occurrence of c appears before the first uppercase occurrence of c.
Return the number of special letters in word.

Input: word = "aaAbcBC"
Output: 3

Input: word = "AbBCab"
Output: 0
*/
public class CountTheNumberOfSpecialCharacters {
    // --- Better Solution ---
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        Map<Character, Integer> map = new HashMap<>();

        // store first occurrence of each characters
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);

            if (!map.containsKey(ch)) {
                map.put(ch, i);
            }
        }

        // Store last occurrence of lowercase characters
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);

            if (Character.isLowerCase(ch)) {
                map.put(ch, i);
            }
        }

        int count = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char ch = entry.getKey();

            if (Character.isUpperCase(ch)) {
                char lower = Character.toLowerCase(ch);

                // Check if the lowercase character exists and
                // its last occurrence is after the first occurrence of the uppercase character
                if (map.containsKey(lower) && map.get(lower) < entry.getValue()) {
                    count++;
                }
            }
        }

        return count;
    }
}
