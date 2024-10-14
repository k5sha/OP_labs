/**
 * Lab 03, Task 2
 *
 * @author Group 12
 */
public class Main {

    public static void main(String[] args) {
        printResults(3, -1, 1);
        printResults(5, -2, 1);
        printResults(10, 1, 1);
        printResults(20, 0.1, 1);
        printResults(25, 5, 1);
        printResults(26, 1, 1);
        printResults(2, 1, 1);
        printResults(25, -1, 0);
        printResults(0, Double.MAX_VALUE, 1);
        printResults(1, Double.MAX_VALUE, 1);
        printResults(1, Double.NaN, 1);
        printResults(25, Double.NaN, 1);
        printResults(25, 1, Double.NaN);
        printResults(25, Double.MAX_VALUE, Double.MAX_VALUE);
        printResults(25, -Double.MAX_VALUE, 1);
        printResults(25, 0, 1);
    }

    /**
     * Обчислює суму за формулою.
     *
     * @param k верхня межа для суми.
     * @param t аргумент функції.
     * @param s третій параметр функції.
     * @return обчислена сума.
     */
    public static double calculateSum(int k, double t, double s) {
        double sum = 0;
        if (k <= 2 || k > 25) {
            throw new IllegalArgumentException("Значення k повинно бути в межах 2 < k <= 25.");
        }
        for (int i = 1; i <= k; i++) {
            double logArgument = -t * i;
            if (logArgument <= 0) {
                throw new IllegalArgumentException("Значення t та i не можуть бути такими, щоб -t * i <= 0 для логарифма.");
            }
            sum += Math.log(logArgument) + Math.cos(Math.sqrt(s / (i * i)));
        }
        return sum;
    }

    /**
     * Допоміжний метод для виведення результатів.
     *
     * @param k верхня межа для суми.
     * @param t аргумент функції.
     * @param s третій параметр функції.
     */
    static void printResults(double k, double t, double s) {
        System.out.print("k: " + k + ", t: " + t + ", i: 1"  + ", s: " + s + " result: ");
        try {
            double result = calculateSum((int) k, t, s);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}
