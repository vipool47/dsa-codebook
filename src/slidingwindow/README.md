# Sliding Window – Counting Subarrays (At Most / Exactly K)

## Core Idea (Very Important)

Many “count subarray” problems are easier when converted into:

> **Exactly K = AtMost(K) − AtMost(K − 1)**

This avoids brute force and gives **O(n)** time.

---

## When to Use This Pattern

Use this pattern when:

* Array elements are **binary** (0/1) or can be **mapped to binary**
* Condition is based on **count** (odd numbers, ones, distinct elements)
* Asked for **number of subarrays**

Examples:

* Binary Subarray Sum
* Nice Subarrays (exactly K odd numbers)
* Subarrays with at most K distinct integers

---

## Universal Template (Java)

```java
class Solution {

    public int solveExactlyK(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int left = 0, count = 0, sum = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += transform(nums[right]);

            while (sum > k) {
                sum -= transform(nums[left]);
                left++;
            }

            count += right - left + 1;
        }
        return count;
    }

    private int transform(int num) {
        // customize based on problem
        return num;
    }
}
```

---

## Transformation Rules

This is the **key trick**.

| Problem               | transform(x)     |
| --------------------- | ---------------- |
| Binary Subarray Sum   | `x`              |
| Nice Subarrays        | `x % 2`          |
| At most K odd numbers | `x % 2`          |
| At most K zeros       | `x == 0 ? 1 : 0` |

---

## Binary Subarray Sum

**LeetCode 930**

```java
transform(x) = x
```

Reason:

* Array already contains `0` and `1`
* Sum directly represents count of ones

---

## Count Nice Subarrays

**LeetCode 1248**

```java
transform(x) = x % 2
```

Reason:

* Odd → 1
* Even → 0
* Problem reduces to binary subarray sum

---

## Why `AtMost` Works

For each `right`:

* Window `[left … right]` has `sum ≤ k`
* All subarrays ending at `right` starting from `left` are valid
* Number of such subarrays = `right - left + 1`

This is why we add:

```java
count += right - left + 1;
```

---

## Common Mistakes (Very Important)

❌ Returning 0 when `k == 0`
✔ Let sliding window naturally count valid subarrays

❌ Using brute force for “exactly K”
✔ Always convert to `AtMost(K) - AtMost(K-1)`

❌ Forgetting transformation step
✔ Always ask: *What should be counted?*

---

## Related LeetCode Problems (Must Practice)

* 930. Binary Subarray Sum
* 1248. Count Number of Nice Subarrays
* 992. Subarrays with K Different Integers
* 713. Subarray Product Less Than K
* 1004. Max Consecutive Ones III
* 904. Fruit Into Baskets

---

---

## Revision Questions

See [REVISION.md](./REVISION.md) for the must-practice problem set and pattern review for this topic.
