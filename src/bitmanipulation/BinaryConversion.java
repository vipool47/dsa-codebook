package bitmanipulation;

//  to the base 2
//  (7)10  to binary (11)2
/*  2|7  rem-1
    2|3  rem-1
    1

    so ans would be 111 (bottom to top)
*/
public class BinaryConversion {

    public static String countBinary(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();

        // Continue until n becomes 0
        while (n > 0) {
            sb.append(n % 2);
            n = n / 2;
        }
        sb = sb.reverse();

        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        System.out.println(countBinary(7));
    }


}
