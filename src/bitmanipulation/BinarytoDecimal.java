package bitmanipulation;

public class BinarytoDecimal {
    /*  This is typically used when converting from binary to decimal. For example, if you're iterating through a binary number like
"1101": ( give index from back like 0,1,2,3)
The rightmost '1' would be: 1 × 2⁰ = 1
The '0' would be: 0 × 2¹ = 0
The '1' would be: 1 × 2² = 4
The leftmost '1' would be: 1 × 2³ = 8 */

    public static int convertToDecimal(String s) {
        int n = s.length();
        int power = 0;
        double res = 0;
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            int digit = ch - '0';

            res += digit * Math.pow(2, power);
            power++;

        }
        return (int) res;

    }

    public static void main(String[] args) {
        System.out.println(convertToDecimal("1101"));
    }


}
