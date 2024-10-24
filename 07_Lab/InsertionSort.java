public class InsertionSort implements SortStrategy {

    /**
     * Сортування вставками за спаданням
     *
     * Найгірший випадок (зворотній порядок) — O( N²/2 ), а точніше O( N(N-1)/2 ) порівнянь і N перестановок
     * Найкращий випадок (відсортований масив) — O(N) порівнянь, 0 перестановок
     *
     * @param a - масив чисел short
     * @return відсортований за спаданням масив
     */
    @Override
    public short[] sort(short[] a) {
        if (a == null)
            throw new NullPointerException("Не можливо сортувати null");

        int N = a.length;
        for (int i = 1; i < N; i++){
            for (int j = i; j > 0 && a[j] > a[j-1]; j--)
                exchange(a, j, j - 1);
        }
        return a;
    }

    private static void exchange(short[] a, int j, int i) {
        short temporary = a[i];
        a[i] = a[j];
        a[j] = temporary;
    }

}
