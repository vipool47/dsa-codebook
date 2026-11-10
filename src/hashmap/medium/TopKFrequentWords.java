package hashmap.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an array of strings words and an integer k, return the k most frequent strings.

Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively
*/
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {

        int n = words.length;

        // Step 1: Calculate frequency
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String str = words[i];
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        // Step 2: Convert entrySet into a list
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        // Step 3: Custom sorting
        list.sort((a, b) -> {

            // First priority: Frequency descending (if frequencies are different)
            if (!a.getValue().equals(b.getValue())) {
                return Integer.compare(b.getValue(), a.getValue());
            }

            // Second priority: Alphabetical ascending
            return a.getKey().compareTo(b.getKey());
        });

        // Step 4: Pick first K elements
        List<String> ans = new ArrayList<>();

        int count = 0;

        for (Map.Entry<String, Integer> entry : list) {

            ans.add(entry.getKey());
            count++;

            if (count == k) {
                break;
            }
        }

        return ans;
    }
}


/*
Time Complexity: O(n log n) - where n is the number of unique words. This is due to the sorting step.
Space Complexity: O(n) - for storing the frequency map and the list of entries.
*/