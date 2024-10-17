public class InsertionSort {

    /**
     * Сортування вставками за спаданням
     *
     * Найгірший випадок (зворотній порядок) — O( N²/2 ), а точніше O( N(N-1)/2 ) порівнянь і N перестановок
     * Найкращий випадок (відсортований масив) — O(N) порівнянь, 0 перестановок
     *
     * @param a - масив чисел short
     * @return відсортований за спаданням масив
     */
    public static short[] sort(short[] a) {
        if (a == null)
            throw new NullPointerException("Не можливо сортувати null");

        int N = a.length;
        for (int i = 1; i < N; i++){
            for (int j = i; j > 0 && a[j] > a[j-1]; j--)
                exchange(a, j, j - 1);
        }
        return a;
    }

    private static void show(short[] a){
        if (a == null)
            return;

        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    private static void exchange(short[] a, int j, int i) {
        short temporary = a[i];
        a[i] = a[j];
        a[j] = temporary;
    }

    public static void main(String[] args) {
        short[] result = sort(new short[]{5, 2, 0, 8, -10, 2});
        show(result);

        short[] result3 = sort(new short[]{5, 2, Short.MAX_VALUE, 8, -10, Short.MIN_VALUE});
        show(result3);

        try {
            short[] result2 = sort(null);
            show(result2);
        } catch (NullPointerException e){
            System.out.println("Помилка: " + e.getMessage());
        }
    }

}
