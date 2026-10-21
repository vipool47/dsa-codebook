package patterns.star;
/*
Tips:
    1. Draw pattern → count rows & columns
    2.Break into:
        spaces
        stars
    3.Convert into formula:
        spaces → n - i
        stars → i or 2*i-1
    4.For hollow → use boundary condition
 */
public class Diamond {
    // pyramid + inverted pyramid
    public static void print() {
        int n = 4;

        // upper part
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n - i; j++) System.out.print(" ");
            for (int j = 1; j <= i; j++) System.out.print("* ");

            System.out.println();
        }

        // lower part
        for (int i = n - 1; i >= 1; i--) {

            for (int j = 1; j <= n - i; j++) System.out.print(" ");
            for (int j = 1; j <= i; j++) System.out.print("* ");

            System.out.println();
        }
    }

    public static void main(String[] args) {
        print();
    }

}
