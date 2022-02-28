package controller;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Factorials {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        menu();
    }

    public static void menu() throws InterruptedException {
        int option;
        do {
            try {
                System.out.println("""
                        Choose a option:
                        1. Run the program
                        2. Exit
                        """);
                option = scan.nextInt();
                switch (option) {
                    case 1 -> {
                        System.out.print("Enter number: ");
                        int num = scan.nextInt();
                        excercise(num);
                    }
                    case 2 -> System.exit(0);
                    default -> System.out.println("Select a correct option.");
                }
            } catch (InputMismatchException e) {
                System.err.println("You must enter a number.");
                scan.nextLine();
            }
            Thread.sleep(100); // Without this, the loop will end too fast and the text gets mixed up.
        } while (true);
    }

    public static void excercise(int num) {
        if (num >= 0 && num <= 50000) System.out.println("The factorial of " + num + " is: " + bigFactorial(num));
        else System.out.println("The number must be between 0 and 50000.");
        bigDivisors(bigFactorial(num));
    }

    public static BigInteger bigFactorial(int num) {
        BigInteger fact = BigInteger.ONE;
        for (int i = num; i > 0; i--) fact = fact.multiply(BigInteger.valueOf(i));
        return fact;
    }

    public static void bigDivisors(BigInteger factor) {
        BigInteger x = BigInteger.TWO;
        BigInteger numDivisors = BigInteger.ONE;
        BigInteger num = factor;
        while (x.multiply(x).compareTo(num) <= 0) {
            int pow = 0;
            while (num.mod(x).equals(BigInteger.ZERO)) {
                pow++;
                num = num.divide(x);
            }
            numDivisors = numDivisors.multiply(BigInteger.valueOf(pow + 1));
            x = x.add(BigInteger.ONE);
        }
        if (!num.equals(BigInteger.ONE)) numDivisors = numDivisors.multiply(BigInteger.valueOf(2));
        System.out.println("Number of divisors: " + numDivisors + "\n");
    }
}
