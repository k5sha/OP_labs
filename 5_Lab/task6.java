
public class task6 {

    public static int getNumberOfWinners(int[][] results) {
        int countWinners = 0;

        for (int[] row : results) {
            if (row == null) {
                throw new IllegalArgumentException("Рядок матриці не може бути null");
            }
            if (row.length != results.length) {
                throw new IllegalArgumentException("Неправильна розмірність матриці (має бути квадратною)");
            }
        }

        for (int i = 0; i < results.length; i++) {
            int totalScore = 0;

            for (int j = 0; j < results.length; j++) {
                if (i != j) {
                    if (results[i][j] == 2) {
                        totalScore++;
                    } else if (results[i][j] == 0) {
                        totalScore--;
                    } else if(results[i][j] != 1){
                        throw new IllegalArgumentException("Елементами матриці поза головною діагоналлю лише 0, 1, 2 (за умовою)");
                    }
                }

                if(!validMatrix(results, i, j)){
                    throw new IllegalArgumentException("Неправильна матриця (неможливий варіант)");
                }
            }

            if (totalScore > 0) {
                countWinners++;
            }
        }

        return countWinners;
    }

    /**
     * Перевіряє умови:
     * 1) Якщо команда A виграла, то команда B пограла (2←→0 або 0←→2)
     * 2) Якщо команда A зіграла в нічию, то команда B також (1←→1)
     * 3) Якщо команда грає сама проти себе, має бути 0
     *
     * @return false - якщо матриця неправильна
     */
    private static boolean validMatrix(int[][] results, int i, int j) {
        return  (results[i][j] == 2 && results[j][i] == 0) ||
                (results[i][j] == 0 && results[j][i] == 2) ||
                (results[i][j] == 1 && results[j][i] == 1) ||
                (i == j && results[i][j] == 0);
    }

    public static void test(int[][] results){
        try{
            int numberOfWinners = getNumberOfWinners(results);
            System.out.println("Кількість команд з більшою кількістю перемог: " + numberOfWinners);
        } catch (IllegalArgumentException ex){
            System.out.println("Помилка: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        /*
         int[][] results = {
                {0, 1, 2, 2},  →  Перша команда: -,       нічия,  виграш, виграш
                {1, 0, 1, 0},  →  Друга команда: нічия,   -,      нічия,  програш
                {0, 1, 0, 1},  →  Третя команда: програш, нічия,  -,      нічия
                {0, 2, 1, 0}   →  Четв. команда: нічия,   виграш, нічия,  -
        };
         */
        int[][] results = {
                {0, 1, 2, 2},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {0, 2, 1, 0}
        };

        test(results);

        // Не правильний елемент по діагоналі
        int[][] wrong_results0 = {
                {1000, 1, 2, 2},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {0, 2, 1, 0}
        };

        test(wrong_results0);

        // Не правильний елемент
        int[][] wrong_results1 = {
                {0, 1000, 2, 2},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {0, 2, 1, 0}
        };

        test(wrong_results1);

        // Не правильний елемент
        int[][] wrong_results2 = {
                {0, Integer.MAX_VALUE, 2, 2},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {0, 2, 1, 0}
        };

        test(wrong_results2);

        // null рядок матриці
        int[][] wrong_results3 = {
                {0, 1, 2, 2},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                null
        };

        test(wrong_results3);

        // Не правильна розмірність
        int[][] wrong_results4 = {
                {0, 1, 2, 2},
                {1, 0, 1, 0},
        };

        test(wrong_results4);
    }
}
