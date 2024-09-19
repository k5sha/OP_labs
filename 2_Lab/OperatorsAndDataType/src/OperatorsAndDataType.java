/**
 *         Math.pow() - Степінь
 *         Math.E - Експонента
 *         Math.log10() - Десятковий логарифм
 *         Math.sqrt() - Корінь квадратний
 *         Math.abs() - Модуль
 *         Math.atan() - Арктангенс
 *         Math.cosh() -  Гіперболічний косинус
 *         Math.sinh() -  Гіперболічний синус
 */

public class OperatorsAndDataType {

    public static double task_2(double a, double b, double c, double d) {
        return  ( (Math.pow(Math.E,a) + 3 * Math.log10(c)) / Math.sqrt(Math.pow(b,c)) ) * Math.abs(Math.atan(d));
    }

    public static double task_12(double a, double b, double c, double d) {
        return 6 * Math.pow(Math.sin(Math.abs(2 * a)), Math.log10(b)) + Math.sqrt(c * Math.cosh(-d));
    }

    public static double task_22(double a, double b, double c, double d) {
        return Math.pow(4 * Math.sinh(Math.sqrt(Math.abs(a / b))) + 3 * Math.asin(c), d);
    }

    public static void printResult(double result){
        if(Double.isNaN(result))
            System.out.println("Не можливо обрахувати, змініть вхідні параметри");
        else
            System.out.println(result);
    }

    public static void main(String[] args) {
        //  Task 2
        double result = task_2(2.34, 0.756, 2.23, -1.653);
        printResult(result);

        //  Task 12
        result = task_12(1.478, 9.26, 0.68, 2.24);
        printResult(result);

        //  Task 22
        result = task_22(1.23, -0.34, 0.707, 2.312);
        printResult(result);

        //  Task 22 - Test case for NaN result
        result = task_12(0, 0, -10, 0);
        printResult(result);
    }
}
