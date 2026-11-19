package bitmanipulation;

public class CountingBits {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            int count = 0;   // To store number of set bits (1s)
            int num = i;     // Copy of current number

            // Count set bits using bitwise operations
            while (num > 0) {
                // (num & 1) checks if the last bit is 1
                // If last bit is 1, add 1 to count
                count = count + (num & 1);

                // Right shift num by 1 to check next bit
                num >>= 1;
            }

            ans[i] = count;
        }

        return ans;
    }

}
