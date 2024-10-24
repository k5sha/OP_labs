public class BubbleSort implements SortStrategy{

    /**
     * Сортування бульбашкою за спаданням
     *
     * Найгірший випадок — O(N²)
     * Найкращий випадок — O(N) (якщо масив вже відсортований)
     *
     * @param a - масив чисел short
     * @return відсортований за спаданням масив
     */
    @Override
    public short[] sort(short[] a) {
        if (a == null)
            throw new NullPointerException("Не можливо сортувати null");

        int N = a.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < N; i++) {
                if (a[i - 1] < a[i]) {
                    exchange(a, i - 1, i);
                    swapped = true;
                }
            }
            N--; // Зменшуємо N, оскільки останній елемент вже на своєму місці
        } while (swapped);

        return a;
    }

    private static void exchange(short[] a, int j, int i) {
        short temporary = a[i];
        a[i] = a[j];
        a[j] = temporary;
    }

}
