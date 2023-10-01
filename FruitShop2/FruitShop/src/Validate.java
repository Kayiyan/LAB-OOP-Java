
import java.util.Scanner;

public class Validate {
    Scanner sc = new Scanner(System.in);

    public int inputInt(String msg,int min,int max){
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
    public double inputDouble(String msg,double min,double max) {
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

    public boolean checkInputYN(String msg){
        System.out.println(msg);
        while(true){
            String result = sc.nextLine();

            if(result.equalsIgnoreCase("Y")) return true;
            if(result.equalsIgnoreCase("N")) return false;
            System.err.println("Please enter y/Y or n/N");
            System.out.println("Enter again: ");
        }
    }
}
