/**
 * Lab 05, Task 8
 *
 * @author Group 12
 */
public class task8 {

    public static int[][] multiply(int[][] a, int[][] b) {

        if (a == null || b == null) {
            throw new NullPointerException("Матриці не можуть бути пустими");
        }

        if (a.length == 0 || b.length == 0 || a[0].length != b.length) {
            throw new IllegalArgumentException("Матриці не можуть бути помножені: неправильні розміри");
        }

        int rowsA = a.length;
        int colsA = a[0].length;
        int colsB = b[0].length;

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] a = {
                {1, 2},
                {3, 4}
        };
        int[][] b = {
                {5, 6},
                {7, 8}
        };

        testMultiplication(a, b);

        // Неправильні розміри
        int[][] c = {
                {1, 2, 3}
        };

        testMultiplication(a, c);

        // Пуста матриця
        testMultiplication(null, b);
    }

    private static void testMultiplication(int[][] a, int[][] b) {
        try {
            int[][] result = multiply(a, b);
            System.out.println("Результат множення матриць:");
            printMatrix(result);
        } catch (Exception ex) {
            System.out.println("Помилка: " + ex.getMessage());
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
