/*Обчислити нескінченну суму ∑(1/i^2) от i=1 до нескіченості із заданою точністю ε (ε>0).
Вважати, що необхідна точність досягнута, якщо черговий доданок виявився по модулю меншим, ніж ε.
Цей і всі наступні доданки можна не враховувати*/

import java.util.Scanner;

public class task11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double epsilon = 0.0;
        do {
            System.out.print("Введіть точність ε (більше 0): ");
            if (scan.hasNextDouble()) {
                epsilon = scan.nextDouble();
                if (epsilon <= 0) {
                    System.out.println("Точність має бути позитивним числом.");
                }
            } else {
                System.out.println("Некоректне введення. Будь ласка, введіть число.");
                scan.next();
            }
        } while (epsilon <= 0);


        double sum = 0.0;
        int i = 1;
        double term;

        do {
            term = 1.0 / (i * i);
            sum += term;
            i++;
        } while (term >= epsilon);

        System.out.printf("Сума ряду з точністю %.10f: %.10f", epsilon, sum);
    }
}
