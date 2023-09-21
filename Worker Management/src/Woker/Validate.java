package Woker;

import java.util.Scanner;

public class Validate {
    Scanner sc = new Scanner(System.in);

    //check age input in range is integer
    public int age_Range(String msg,int min,int max){
        System.out.print(msg);

        //force user input exectly integer number
        while(true){
            String input = sc.nextLine();
            try{
                int number = Integer.parseInt(input);
                // check the range
                if(number > max || number < min){
                    System.out.print("Please enter number in range "+min+" "+max+": ");
                        continue;
                }
                    return number;

            }catch(Exception e){
                System.out.print("Please enter an integer number: ");

            }

        }

    }
    // check input salary
    public double input_Salary(String msg,double min,double max) {
        System.out.print(msg);

        //force user input exectly  number
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

    // check input string from user

    public String inputString(String msg){
        System.out.print(msg);
        // check non-empty string input
        while(true){
            String input = sc.nextLine();
            if(input.isEmpty()){
                System.out.print("Can not enter an empty string");
                continue;
            }
            return input;
        }

    }

    // check valid Date

//    public String inputDate(String msg){
//        System.out.print(msg);
//        // set date format
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        dateFormat.setLenient(false);
//
//        // force input date
//        while(true){
//            String input = sc.nextLine();
//            try {
//                Date date = dateFormat.parse(input);
//                // get current date
//                Date currentDate = Calendar.getInstance().getTime();
//                // check range date
//                if(currentDate.compareTo(date) < 0){
//                    System.out.print("Please enter date: ");
//                    continue;
//                }
//
//                return dateFormat.format(date);
//            }catch(Exception e){
//                System.out.println("Please enter valid date: ");
//            }
//        }
//    }
}
