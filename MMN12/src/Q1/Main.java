package Q1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //ask if i need to get the number of terms before getting the coefficients and powers
        System.out.println("Enter the number of terms for the first polynomial:");
        int n1 = scanner.nextInt();
        double[] coefficients1 = new double[n1];
        int[] powers1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            System.out.println("Enter coefficient and power for term " + (i + 1) + ":");
            coefficients1[i] = scanner.nextDouble();
            powers1[i] = scanner.nextInt();
        }

        System.out.println("Enter the number of terms for the second polynomial:");
        int n2 = scanner.nextInt();
        double[] coefficients2 = new double[n2];
        int[] powers2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            System.out.println("Enter coefficient and power for term " + (i + 1) + ":");
            coefficients2[i] = scanner.nextDouble();
            powers2[i] = scanner.nextInt();
        }

        try {
            Polynom p1 = new Polynom(coefficients1, powers1);
            Polynom p2 = new Polynom(coefficients2, powers2);

            System.out.println("p1: " + p1);
            System.out.println("p2: " + p2);

            Polynom sum = p1.plus(p2);
            System.out.println("p1 + p2: " + sum);

            Polynom diff = p1.minus(p2);
            System.out.println("p1 - p2: " + diff);

            Polynom derivative = p1.derivative();
            System.out.println("Derivative of p1: " + derivative);

            System.out.println("p1 equals p2: " + p1.equals(p2));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}