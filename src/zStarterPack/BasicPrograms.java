package zStarterPack;

import java.util.*;

public class BasicPrograms {
    // 1. Reverse a String
    static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    // 2. Palindrome (ignores case and non-alphanumeric characters)
    static boolean isPalindrome(String s) {
        String clean = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int left = 0, right = clean.length() - 1;
        while (left < right) {
            if (clean.charAt(left++) != clean.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    // 3. Prime number (checks divisors up to sqrt(n))
    static boolean isPrime(int n) {
        if (n < 2)
            return false;
        if (n == 2)
            return true;
        if (n % 2 == 0)
            return false;
        for (int i = 3; (long) i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    // 4. Factorial (long works up to 20!)
    static long factorial(int n) {
        if (n < 0)
            throw new IllegalArgumentException("n must be >= 0");
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // 5. Fibonacci: first n terms
    static List<Long> fibonacci(int n) {
        List<Long> series = new ArrayList<>();
        long a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            series.add(a);
            long next = a + b;
            a = b;
            b = next;
        }
        return series;
    }

    // 6. Even / Odd
    static String evenOrOdd(int n) {
        return (n % 2 == 0) ? "Even" : "Odd";
    }

    // 7. Count characters: vowels, consonants, digits, spaces, and frequency of
    // each character
    static void countCharacters(String s) {
        int vowels = 0, consonants = 0, digits = 0, spaces = 0, others = 0;
        Map<Character, Integer> freq = new LinkedHashMap<>();

        for (char c : s.toCharArray()) {
            freq.merge(c, 1, Integer::sum);

            char lower = Character.toLowerCase(c);
            if ("aeiou".indexOf(lower) >= 0)
                vowels++;
            else if (Character.isLetter(c))
                consonants++;
            else if (Character.isDigit(c))
                digits++;
            else if (Character.isWhitespace(c))
                spaces++;
            else
                others++;
        }

        System.out.println("Length     : " + s.length());
        System.out.println("Vowels     : " + vowels);
        System.out.println("Consonants : " + consonants);
        System.out.println("Digits     : " + digits);
        System.out.println("Spaces     : " + spaces);
        System.out.println("Others     : " + others);
        System.out.println("Frequency  : " + freq);
    }

    // 8. Find max / min
    static int[] findMaxMin(int[] arr) {
        int max = arr[0], min = arr[0];
        for (int x : arr) {
            if (x > max)
                max = x;
            if (x < min)
                min = x;
        }
        return new int[] { max, min };
    }

    // 9. Remove duplicates (keeps original order)
    static int[] removeDuplicates(int[] arr) {
        Set<Integer> unique = new LinkedHashSet<>();
        for (int x : arr) {
            unique.add(x);
        }
        return unique.stream().mapToInt(Integer::intValue).toArray();
    }

    // 10. Find duplicate numbers
    static Set<Integer> findDuplicates(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new LinkedHashSet<>();
        for (int x : arr) {
            if (!seen.add(x)) { // add() returns false if already present
                duplicates.add(x);
            }
        }
        return duplicates;
    }

    static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        System.out.println("1. Reverse: " + reverse("hello"));

        System.out.println("2. Palindrome: " + isPalindrome("A man, a plan, a canal: Panama"));

        System.out.println("3. Prime: 29 -> " + isPrime(29) + ", 30 -> " + isPrime(30));

        System.out.println("4. Factorial of 5: " + factorial(5));

        System.out.println("5. Fibonacci (10 terms): " + fibonacci(10));

        System.out.println("6. 7 is " + evenOrOdd(7) + ", 10 is " + evenOrOdd(10));

        System.out.println("7. Count characters:");
        countCharacters("Hello World 123");

        int[] nums = { 4, 9, 2, 9, 7, 4, 1, 7, 7 };
        int[] maxMin = findMaxMin(nums);
        System.out.println("8. Max: " + maxMin[0] + ", Min: " + maxMin[1]);

        System.out.println("9. Without duplicates: " + Arrays.toString(removeDuplicates(nums)));

        System.out.println("10. Duplicates: " + findDuplicates(nums));
    }
}
