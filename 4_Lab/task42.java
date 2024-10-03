import java.util.Arrays;
/**
 *
*/

public class task42 {
    /**
     * Знаходить середні значення елементів масиву які кратні 3
     */
    public static int average_elem_massive(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Масив не повинен бути нульовим або порожнім");
        }
        int sum = 0;
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 3 == 0 ){
                sum += array[i];
                count++;
            }

        }
        return sum / count;
    }
    public static void main(String[] args) {
        int[][] test_arrays = {
                {1, -2, 3, -4, 3},
                {-1, -5, -2, -3},
                {7, 3, -8, 1, 2},
                {0, 0, 0},
                {10, -10, 5, -15},
                {-1, 2, 3, 4, -5}
        };
        for (int[] array : test_arrays) {
            try{
                int  average_elem_massive = average_elem_massive(array);
                System.out.println("Масив: " + Arrays.toString(array) + " середній_елемент_масиву: " + average_elem_massive);
            } catch (Exception e) {
                System.out.println("Array: " + Arrays.toString(array) + " | Помилка: " + e.getMessage());
            }

        }
    }
}


