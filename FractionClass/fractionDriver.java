
/**
 * Write a description of class fractionDriver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class fractionDriver {
    public static void main(String[] args) {
        fraction half = new fraction(1, 2);
        fraction third = new fraction(9, 6);
        fraction sum = fraction.add(half, third);

        System.out.println("Half: " + half.toString());
        System.out.println("Third: " + third.toString());
        System.out.println("Sum: " + sum.toString());
        System.out.println("Sum as decimal: " + sum.toDouble());

        // Test additional methods
        fraction fractionFromString = new fraction("3/4");
        System.out.println("Fraction from String: " + fractionFromString.toString());

        fraction copyFraction = new fraction(half);
        System.out.println("Copy of Half: " + copyFraction.toString());

        // Test mutator methods
        half.setNum(3);
        half.setDenom(4);
        System.out.println("Modified Half: " + half.toString());

        // Test static methods
        fraction product = fraction.multiply(half, third);
        System.out.println("Product: " + product.toString());

        fraction quotient = fraction.divide(half, third);
        System.out.println("Quotient: " + quotient.toString());

        fraction difference = fraction.subtract(half, third);
        System.out.println("Difference: " + difference.toString());
    }
}

