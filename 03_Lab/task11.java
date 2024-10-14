/*Обчислити нескінченну суму ∑(1/i^2) от i=1 до нескіченості із заданою точністю ε (ε>0).
Вважати, що необхідна точність досягнута, якщо черговий доданок виявився по модулю меншим, ніж ε.
Цей і всі наступні доданки можна не враховувати*/

import static java.lang.Math.abs;

/**
 *
 */
public class task11{

    /**
     * Метод для обчислення суми ряду
     * @param epsilon має бути більшим нуля
     * @return якщо epsilon менше або рівний нулю → помилка, інакше → результат
     */
    public static double calculateSum(double epsilon) {
        // Перевірка на коректність вхідного параметра
        if (epsilon <= 0)
            throw new IllegalArgumentException("Параметр epsilon повинен бути більше 0");

        if(Double.isNaN(epsilon))
            throw new IllegalArgumentException("Параметр epsilon повинен бути визначеним");

        if(epsilon == Double.MIN_VALUE)
            throw new IllegalArgumentException("Виконання операції займе завелику кількість часу");

        double sum = 0.0;
        double term;
        int i = 1;

        // Додавання членів ряду, поки вони більші, ніж epsilon
        do {
            term = 1.0 / (i * i);
            sum += term;
            i++;
        } while (abs(term) >= epsilon);

        return sum;
    }

    /**
     * Метод перевіряє аргументи і параметри функції та у разі їх помилковості аварійно
     *     закінчуває свою роботу шляхом викидання стандартного виключення IllegalArgumentException
     */
    public static void printResult(double epsilon) {
        System.out.print("Epsilon = "+epsilon + "\t\t\tresult = ");
        try {
            double result = calculateSum(epsilon);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        printResult(0);
        printResult(1);
        printResult(2);
        printResult(-10);
        printResult(0.1);
        printResult(Double.MAX_VALUE);
        printResult(Double.MIN_VALUE);
        printResult(Double.POSITIVE_INFINITY);
        printResult(Double.NEGATIVE_INFINITY);
        printResult(Double.NaN);
    }
}
