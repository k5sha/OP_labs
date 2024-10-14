import java.util.Arrays;

public class task65 {

    /**
     * Формує новий масив, елементи якого це елементи старого масиву у зворотному порядку
     * @param originalArray масив цілих чисел
     * @return обернений масив
     */
    public static int[] reverse(int[] originalArray){
        if(originalArray == null)
            throw new IllegalArgumentException("Масив має бути присутнім (не бути null)");

        int[] reversedArray = new int[originalArray.length];

        for (int i = 0; i < originalArray.length; i++) {
            reversedArray[i] = originalArray[originalArray.length - i - 1];
        }

        return reversedArray;
    }

    public static void main(String[] args) {
        int[] reversedArray;
        int[][] testArrays = {
                {1, -2, 3, -4, 3},
                {-1, -5, -2, -3},
                {7, 3, -8, 1, 2},
                {0, 0, 0},
                {10, -10, 5, -15},
                {Integer.MIN_VALUE, Integer.MAX_VALUE},
                {-1, 2, 3, 4, -5},
                null
        };

        for (int[] array : testArrays) {
            try {
                reversedArray = reverse(array);
                System.out.println("Масив: " + Arrays.toString(array)+
                        "   |   Обернений масив: " + Arrays.toString(reversedArray));
            } catch (IllegalArgumentException e) {
                System.out.println("Array: " + Arrays.toString(array) +
                        "   |   Помилка: " + e.getMessage());
            }
        }
    }
}
