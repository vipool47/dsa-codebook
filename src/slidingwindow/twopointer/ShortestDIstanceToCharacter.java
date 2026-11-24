package slidingwindow.twopointer;

public class ShortestDIstanceToCharacter {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] result = new int[n];
        int firstChar = -1;

        // Left to right
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                firstChar = i;
            }

            if (firstChar == -1) {
                result[i] = n;
            } else {
                result[i] = i - firstChar;
            }
        }

        // Right to left
        int prev = -1;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                prev = i;
            }

            if (prev != -1) {
                result[i] = Math.min(result[i], prev - i);
            }
        }

        return result;
    }
}
