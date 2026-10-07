package assesment;

import java.util.*;

/*
# Dynamic Resource Allocation — Reconstructed IBM Assessment Question

## Problem Statement

Given two integers, `inc` and `dec`, and a list of integers `request` of size
\(n\), calculate the result for each element based on its rank and the number
of elements sharing that rank.

### 1. Calculate `rank[i]`

For each element `request[i]`:

- Count each distinct value strictly greater than `request[i]` once.
- Add the number of other occurrences of the same value.

Therefore,

$$
\text{rank}[i] =
\text{distinctGreater}(\text{request}[i])
+ \text{frequency}(\text{request}[i]) - 1
$$

### 2. Calculate `sameRank[i]`

`sameRank[i]` is the number of elements in the original list whose calculated
rank equals `rank[i]`.

### 3. Calculate the Result

The reconstructed formula is:
\text{result}[i] =
\text{inc} \times (n-1+\text{rank}[i])
+ \text{dec} \times \text{sameRank}[i]


Return the resulting list in the original input order.

---

## Example

### Input
inc = 2
dec = 3
request = [2, 4, 3, 5, 3]


### Step 1: Calculate Ranks

| Value | Distinct greater values | Other equal occurrences | Rank |
|---:|---|---:|---:|
| 2 | 3, 4, 5 | 0 | 3 |
| 4 | 5 | 0 | 1 |
| 3 | 4, 5 | 1 | 3 |
| 5 | None | 0 | 0 |
| 3 | 4, 5 | 1 | 3 |

The resulting ranks are:
[3, 1, 3, 0, 3]


### Step 2: Calculate Same-Rank Counts

- Rank `3` appears 3 times.
- Rank `1` appears 1 time.
- Rank `0` appears 1 time.

Therefore:
sameRank = [3, 1, 3, 1, 3]


### Step 3: Calculate Results

For the first element, `2`:
2(5-1+3)+3(3)=23

For the element `4`:
2(5-1+1)+3(1)=13

For the element `5`:
2(5-1+0)+3(1)=11

### Expected Output
[23, 13, 23, 11, 23]


## Complexity Analysis

- **Time Complexity:** \(O(n \log n)\), due to sorting distinct values.
- **Space Complexity:** \(O(n)\), for the frequency maps and distinct values.

## Key Concepts to Remember

1. `HashMap` — count occurrences of each value.
2. `TreeSet` — remove duplicates and sort values in descending order.
3. `rankMap` — map each value to its calculated rank.
4. `rankFrequency` — count how many elements share each rank.
5. Apply the formula while preserving the original input order.

## Important Observation

The rank formula combines two different counts:

- Distinct values strictly greater than the current value.
- Other occurrences of the same value.

Do not confuse `rank[i]` with `sameRank[i]`; they represent different quantities.

> [!warning] Verification needed
> This solution follows the reconstructed definitions and formula.
The original IBM assessment may have used a different formula or
additional requirements. Verify against the original statement if
it becomes available.
 */
public class DynamicResourceAllocation {

    public static List<Integer> dynamicResourceAllocation(
            int inc,
            int dec,
            List<Integer> request) {

        int n = request.size();

        // Step 1: Count frequency of each value
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int x : request) {
            frequency.put(x, frequency.getOrDefault(x, 0) + 1);
        }

        // Step 2: Get distinct values in descending order
        TreeSet<Integer> distinct =
                new TreeSet<>(Collections.reverseOrder());

        distinct.addAll(request);

        // Step 3: Calculate rank for each distinct value
        Map<Integer, Integer> rankMap = new HashMap<>();

        int greater = 0;

        for (int x : distinct) {
            rankMap.put(
                    x,
                    greater + frequency.get(x) - 1
            );

            greater++;
        }

        // Step 4: Count elements sharing each rank
        Map<Integer, Integer> rankFrequency = new HashMap<>();

        for (int x : request) {
            int rank = rankMap.get(x);

            rankFrequency.put(
                    rank,
                    rankFrequency.getOrDefault(rank, 0) + 1
            );
        }

        // Step 5: Calculate results in original order
        List<Integer> result = new ArrayList<>();

        for (int x : request) {
            int rank = rankMap.get(x);
            int sameRank = rankFrequency.get(rank);

            int cost = inc * (n - 1 + rank)
                    + dec * sameRank;

            result.add(cost);
        }

        return result;
    }
}
