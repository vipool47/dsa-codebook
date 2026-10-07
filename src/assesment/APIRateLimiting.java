package assesment;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
Problem Statement:

You are given n servers, where capacity[i] represents the number of API requests
the i-th server can process in one second, and an integer requests representing
the total number of requests that must be processed.

In each second, you can choose one server to process requests.

The following rules apply:

1. If a server with current capacity c is selected, it processes up to c requests during that second.
2. Immediately after being selected, its capacity becomes floor(c / 2).
3. The capacities of all other servers remain unchanged.
4. Repeat this process until the total number of processed requests reaches or exceeds requests.

Determine the minimum number of seconds required to process all requests.

Example:

Input: n = 5 capacity = [3, 1, 7, 2, 4] requests = 15
Output: 4

Explanation:

- Second 1: Select capacity 7. Process 7 requests. Its capacity becomes 3. Remaining requests: 8.
- Second 2: Select capacity 4. Process 4 requests. Its capacity becomes 2. Remaining requests: 4.
- Second 3: Select capacity 3. Process 3 requests. Its capacity becomes 1. Remaining requests: 1.
- Second 4: Select capacity 3. Only 1 request remains, so processing stops when the total reaches 15.

Therefore, the minimum number of seconds required is 4.

Constraints: n2 will fail
 */
public class APIRateLimiting {
    public static int getMinSeconds(
            List<Integer> capacity, long requests) {

        // Max-heap: largest capacity first
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.addAll(capacity);

        int seconds = 0;

        while (requests > 0) {
            int current = maxHeap.poll();

            requests -= current;

            maxHeap.offer(current / 2);
            seconds++;
        }

        return seconds;
    }
}
