import static java.lang.Math.sqrt;

public class task9 {

    private static boolean isEven(double number){
        return number % 2 == 0;
    }

    private static double oddSum(double t, double l){
        if(t * l < 0)
            throw new IllegalArgumentException("t multiplied by l must be more or equal to zero (when l is odd)");

        return sqrt(t * l) * t;
    }

    private static double evenSum(double t, double l){
        if(t <= 0)
            throw new IllegalArgumentException("t must be more than zero (when l is even)");

        return ( l / sqrt(t) ) * t;
    }

    public static double calculate(double t, double l){
        return isEven(l) ? evenSum(t, l) : oddSum(t, l);
    }

    public static void printResult(double t, double l){
        System.out.print("t:" + t + "\t\t\tl:" + l + "\t\t\tresult: ");

        try {
            double result = calculate(t, l);
            System.out.println(result);
        }catch (IllegalArgumentException ex){
            System.out.println("EXCEPTION! "+ex.getMessage());
        }
    }

    public static void main(String[] args) {
        printResult(0, 0);
        printResult(0, 1);
        printResult(1, 0);
        printResult(1, 1);
        printResult(2, 1);
        printResult(1, 2);
        printResult(2, -10);
        printResult(20, 20);
        printResult(21, 21);
        printResult(1, 10);
        printResult(-1, 10);
        printResult(0, Double.MAX_VALUE);
        printResult(1, Double.MAX_VALUE);
        printResult(1, Double.NaN);

        // additional use-case (oddSum wrong input parameters)
        printResult(-1, 9);
    }
}
