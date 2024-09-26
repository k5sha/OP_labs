import static java.lang.Math.sqrt;

/**
 * Детальніше чому рішень до завдання 9 - два (task9.java і task9_alternative.java)
 * описано у task9.java
 */

public class task9_alternative {

    /**
     * Допоміжний метод, який перевіряє число на парність
     */
    private static boolean isEven(double number){
        return number % 2 == 0;
    }

    /**
     * Здійснення обрахунків для випадку непарного l.
     * Сума (t разів) коренів добутку t і l.
     *
     * Використано i <= t, оскільки сигма-вираз включає в себе значення t.
     *
     * @return якщо t * l менше нуля  → помилка, інакше → результат
     */
    private static double oddSum(double t, double l){
        if(t * l < 0)
            throw new IllegalArgumentException("t multiplied by l must be more or equal to zero (when l is odd)");

        double result = 0;
        for(double i = 1; i <= t; i++){
            result += sqrt(t * l);
        }

        return result;
    }

    /**
     * Здійснення обрахунків для випадку парного l.
     * Сума (t разів) коренів добутку t і l.
     *
     * Використано i <= t, оскільки сигма-вираз включає в себе значення t.
     *
     * @return якщо t менший або рівний нулю → помилка, інакше → результат
     */
    private static double evenSum(double t, double l){
        if(t <= 0)
            throw new IllegalArgumentException("t must be more than zero (when l is even)");

        double result = 0;
        for(double i = 1; i <= t; i++){
            result += l / sqrt(t);
        }

        return result;
    }

    /**
     * Метод, що дає розв'язок на завдання 9.
     *
     * Як на мене, тернарний оператор виглядає дуже зручно в цьому випадку.
     * Це набагато краще ніж кілька строк з if-ом.
     */
    public static double calculate(double t, double l){
        return isEven(l) ? evenSum(t, l) : oddSum(t, l);
    }

    /**
     * Допоміжний метод, що виводить у консоль
     * вхідні аргументи, результат і обробляє помилки
     */
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

        // additional use-case (calls oddSum with wrong input parameters)
        printResult(-1, 9);
    }
}
