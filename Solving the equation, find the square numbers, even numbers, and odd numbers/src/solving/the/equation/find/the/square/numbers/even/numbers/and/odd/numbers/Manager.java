package solving.the.equation.find.the.square.numbers.even.numbers.and.odd.numbers;

import java.util.Scanner;
import java.util.ArrayList;

public class Manager {

    private Scanner sc = new Scanner(System.in);
    private ArrayList<Double> coefficients = new ArrayList<>();

    public int inutInt(String msg, int min, int max) {
        while (true) {
            System.out.println(msg);
            String input = sc.nextLine();
            try {
                int result = Integer.parseInt(input);
                if (result < min || result > max) {
                    System.out.println("Please inut between " + min + " and " + max + ":");
                    continue;
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input an integer number:");
            }
        }
    }

    public double inputDouble(String msg) {
        while (true) {
            System.out.println(msg);
            String input = sc.nextLine();
            try {
                double result = Double.parseDouble(input);
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input double");
                System.err.println("Please enter again!");
            }

        }
    }

    public boolean isOdd(double number) {
        return number % 2 != 0;
    }

    public boolean isPerfectSquare(double number) {
        double sqrt = (double) Math.sqrt(number);
        return sqrt == (int) sqrt;
    }

    public ArrayList<Double> calculateEquation(double a, double b) {
        if (a == 0) {
            return null;
        }
        double x = -b / a;
        ArrayList<Double> solutions = new ArrayList<>();
        solutions.add(x);
        return solutions;
    }

    public ArrayList<Double> calculateQuadraticEquation(double a, double b, double c) {
        if (a == 0) {
            return null;
        }
        double discriminant = b * b - 4 * a * c;
        ArrayList<Double> solutions = new ArrayList<>();

        if (discriminant < 0) {
            return null;
        } else if (discriminant == 0) {
            double x1 = -b / (2 * a);
            solutions.add(x1);
        } else {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            solutions.add(x1);
            solutions.add(x2);
        }
        return solutions;
    }

    public void displayOddEvenSquareNumbers(double... coefficients) {
        System.out.println("Odd, Even, and Square Numbers:");
        for (double coeff : coefficients) {
            if (isPerfectSquare(coeff)) {
                System.out.println("Square: " + coeff);
            }
            if (isOdd(coeff)) {
                System.out.println("Odd: " + coeff);
            } else {
                System.out.println("Even: " + coeff);
            }
        }
    }

    public void calcSuperlativeEquation() {
        double a = inputDouble("Enter A:");
        double b = inputDouble("Enter B:");

        ArrayList<Double> solutions = calculateEquation(a, b);

        if (solutions == null) {
            System.out.println("No solution.");
        } else {
            System.out.println("Solutions: " + solutions);
            displayOddEvenSquareNumbers(a, b);
        }
    }
    
    public void calcQuadraticEquation(){
        double a = inputDouble("Enter A:");
        double b = inputDouble("Enter B:");
        double c = inputDouble("Enter c:");
        
        ArrayList<Double> solutions = calculateQuadraticEquation(a, b, c);
        
         if (solutions == null) {
                System.out.println("No solution.");
            } else {
                System.out.println("Solutions: " + solutions);
                displayOddEvenSquareNumbers(a, b, c);
            }
    }

}
