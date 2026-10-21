package zStarterPack;
import java.util.*;

public class BasicArray {
    // 1. Second largest (single pass, handles duplicates)
    static int secondLargest(int[] arr) {
        long largest = Long.MIN_VALUE;   // long so Integer.MIN_VALUE can still be a valid answer
        long second = Long.MIN_VALUE;

        for (int x : arr) {
            if (x > largest) {
                second = largest;
                largest = x;
            } else if (x > second && x != largest) {
                second = x;
            }
        }
        if (second == Long.MIN_VALUE) {
            throw new IllegalArgumentException("No second largest element");
        }
        return (int) second;
    }

    // 2. Sort array (bubble sort with early exit; use Arrays.sort() in real code)
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;   // already sorted
        }
    }

    // 3. Find missing number (array holds 1..n with one number missing)
    static int findMissing(int[] arr) {
        int n = arr.length + 1;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int x : arr) actualSum += x;
        return expectedSum - actualSum;
    }

    // 4. Find duplicates (using a frequency map, returns elements with count > 1)
    static List<Integer> findDuplicates(int[] arr) {
        Map<Integer, Integer> freq = new LinkedHashMap<>();
        for (int x : arr) {
            freq.merge(x, 1, Integer::sum);
        }
        List<Integer> duplicates = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            if (e.getValue() > 1) duplicates.add(e.getKey());
        }
        return duplicates;
    }

    // 5. Frequency of elements
    static Map<Integer, Integer> frequency(int[] arr) {
        Map<Integer, Integer> freq = new LinkedHashMap<>();
        for (int x : arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        return freq;
    }

    // 6. Two Sum (returns indices of the two numbers that add up to target)
    static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> seen = new HashMap<>();   // value -> index
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (seen.containsKey(complement)) {
                return new int[] { seen.get(complement), i };
            }
            seen.put(arr[i], i);
        }
        return new int[] { -1, -1 };   // no pair found
    }

    // 7a. Merge two arrays (simple concatenation)
    static int[] mergeArrays(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    // 7b. Merge two SORTED arrays into one sorted array (two pointers)
    static int[] mergeSorted(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) result[k++] = a[i++];
            else result[k++] = b[j++];
        }
        while (i < a.length) result[k++] = a[i++];
        while (j < b.length) result[k++] = b[j++];

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 12, 35, 1, 10, 34, 1, 35 };

        System.out.println("1. Second largest: " + secondLargest(nums));

        int[] toSort = { 64, 25, 12, 22, 11 };
        bubbleSort(toSort);
        System.out.println("2. Sorted: " + Arrays.toString(toSort));

        int[] withMissing = { 1, 2, 4, 5, 6 };
        System.out.println("3. Missing number: " + findMissing(withMissing));

        System.out.println("4. Duplicates: " + findDuplicates(nums));

        System.out.println("5. Frequency: " + frequency(nums));

        int[] twoSumArr = { 2, 7, 11, 15 };
        System.out.println("6. Two Sum (target 9): " + Arrays.toString(twoSum(twoSumArr, 9)));

        int[] a = { 1, 3, 5, 7 };
        int[] b = { 2, 4, 6, 8 };
        System.out.println("7a. Merged: " + Arrays.toString(mergeArrays(a, b)));
        System.out.println("7b. Merged sorted: " + Arrays.toString(mergeSorted(a, b)));
    }
}
