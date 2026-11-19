package bitmanipulation;


/*
AND (&) checks bits
OR (|) sets bits
XOR (^) flips bits
<< multiplies by 2
>> divides by 2
 */
public class CountSetBits {
        public int hammingWeight(int n) {
            int count = 0;

            while (n != 0) {
                count = count + (n & 1);
                // n & (n - 1) removes the rightmost 1 bit. (so we can just do this and increase the count)
                n >>>= 1; // >>= normal shift works with positive : here used unsigned shift (if n is negative )
            }

            return count;
        }
}
