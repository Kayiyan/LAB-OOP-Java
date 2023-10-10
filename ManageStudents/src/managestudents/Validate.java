package managestudents;

import java.text.ParseException;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Validate {

    Scanner sc = new Scanner(System.in);

    public int inputInt(String msg, int min, int max) {
        System.out.print(msg);

        //force user input exectly integer number
        while (true) {
            String input = sc.nextLine();
            try {
                int number = Integer.parseInt(input);
                // check the range
                if (number > max || number < min) {
                    System.out.print("Please enter number in range " + min + " " + max + ": ");
                    continue;
                }
                return number;

            } catch (Exception e) {
                System.out.print("Please enter an integer number: ");

            }

        }

    }

    public double inputDouble(String msg, double min, double max) {
        System.out.print(msg);

        while (true) {
            String input = sc.nextLine();
            try {
                double number = Double.parseDouble(input);
                // check the range
                if (number > max || number < min) {
                    System.out.print("Please enter number in range: " + min + " " + max);
                    continue;
                }
                return number;

            } catch (Exception e) {
                System.out.print("Please enter an right number: ");

            }

        }
    }

    public String inputString(String msg) {
        System.out.print(msg);
        // check non-empty string input
        while (true) {
            String input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.print("Can not enter an empty string");
                continue;
            }
            return input;
        }

    }

    public boolean checkYesNo(String msg) {
        System.out.println(msg);
        while (true) {
            String result = sc.nextLine();

            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please enter y/Y or n/N");
            System.out.println("Enter again: ");
        }
    }

    public boolean checkUD(String msg) {
        System.out.println(msg);
        while (true) {
            String result = sc.nextLine();

            if (result.equalsIgnoreCase("U")) {
                return true;
            } else if (result.equalsIgnoreCase("D")) {
                return false;
            } else {
                System.err.println("You only have permission update(U) and delete(D)");
            }
            System.out.println("Enter again: ");
        }
    }

    public String inputDate(String msg) throws ParseException {
        System.out.print(msg);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        while (true) {
            String input = sc.nextLine();
            try {
                Date date = dateFormat.parse(input);
                Date currentDate = Calendar.getInstance().getTime();
                if (currentDate.compareTo(date) < 0) {
                    System.out.println("Please input date that before current date");
                    continue;
                }
                return dateFormat.format(date);
            } catch (Exception e) {
                System.out.println("Please input valid date (dd/MM/yyyy)");
            }
        }
    }

    public String checkInputCourse(String msg) {
        System.out.print(msg);
        while (true) {
            String result = sc.nextLine();
            if (result.equalsIgnoreCase("java")
                    || result.equalsIgnoreCase(".net")
                    || result.equalsIgnoreCase("c/c++")) {
                return result;
            }
            System.out.println("There are only 3 course: Java,.Net,C/C++");
            System.out.println("Enter again: ");
        }

    }

}
