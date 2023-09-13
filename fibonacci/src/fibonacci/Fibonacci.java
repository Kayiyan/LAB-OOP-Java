package fibonacci;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println("The 45 sequence fibonacci: ");
        fibonacci(1, 1, 0, 1);
    }

    private static int fibonacci(int test, int first, int second, int count) {
        if (test > 45) {
            return second;
        }
        System.out.println(second + "(" + count + ")");
        if(isFibonacci(second)){
            System.out.println("is fibonacci");
        }
        else{
            System.out.println("not a fibonacci");
        }
        return fibonacci(test + 1, second, second + first, count + 1);
    }

    private static boolean isFibonacci(int n) {
        if (n <= 1) {
            return true;
        }

        int a = 1;
        int b = 1;

        while (b < n) {
            int temp = a + b;
            a = b;
            b = temp;

        }
        return b == n;
    }
}


