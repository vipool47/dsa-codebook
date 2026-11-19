package array.medium;

import java.util.HashMap;
import java.util.Map;

/*
How many previous prefix sums equal currentPrefix - k?”
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        // Map to store: prefixSum -> how many times we've seen it
        Map<Integer, Integer> map = new HashMap<>();

        // Important:
        // We say prefix sum 0 has appeared once.
        // Why? Because if prefixSum itself equals k,
        // then prefixSum - k = 0 should count.
        map.put(0, 1);

        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {

            // Step 1: build prefix sum
            prefixSum += nums[i];

            // Step 2: we want prefixSum[j] such that:
            // prefixSum - prefixSum[j] = k
            // => prefixSum[j] = prefixSum - k
            int required = prefixSum - k;

            // Step 3: check how many times we've seen this required value
            // Each occurrence gives one valid subarray ending at index i
            if (map.containsKey(required)) {
                count += map.get(required);
            }

            // Step 4: record current prefixSum for future subarrays
            // if same preSum occurs increase the count (like we have seen it twice, ....)
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}

