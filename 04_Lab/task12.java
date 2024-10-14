/**
 * Lab 04, Task 12
 *
 * @author Group 12
 */
public class task12 {

    /**
     * Знаходить максимальний за модулем елемент масиву
     * @param array масив цілих чисел
     * @return максимальний за модулем елемент
     */
    public static int maxAbsValue(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        int maxAbs = Math.abs(array[0]);

        for (int num : array) {
            int absValue = Math.abs(num);
            if (absValue > maxAbs) {
                maxAbs = absValue;
            }
        }

        return maxAbs;
    }

    public static void main(String[] args) {
        int[][] testArrays = {
                {1, -2, 3, -4, 3},
                {-1, -5, -2, -3},
                {7, 3, -8, 1, 2},
                {0, 0, 0},
                {10, -10, 5, -15},
                {Integer.MIN_VALUE, Integer.MAX_VALUE},
                {-1, 2, 3, 4, -5}
        };

        for (int[] array : testArrays) {
            try {
                int maxAbsValue = maxAbsValue(array);
                System.out.println("Масив: " + java.util.Arrays.toString(array) +
                        " | Максимальне значення модулю: " + maxAbsValue);
            } catch (IllegalArgumentException e) {
                System.out.println("Array: " + java.util.Arrays.toString(array) +
                        " | Помилка: " + e.getMessage());
            }
        }
    }
}
