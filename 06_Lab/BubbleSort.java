public class BubbleSort {

    /**
     * Сортування бульбашкою за спаданням
     *
     * Найгірший випадок — O(N²)
     * Найкращий випадок — O(N) (якщо масив вже відсортований)
     *
     * @param a - масив чисел short
     * @return відсортований за спаданням масив
     */
    public static short[] sort(short[] a) {
        if (a == null)
            throw new NullPointerException("Не можливо сортувати null");

        int N = a.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < N; i++) {
                if (a[i - 1] < a[i]) {
                    showSwap(a, i - 1, i); 
                    exchange(a, i - 1, i);
                    swapped = true;
                }
            }
            N--; // Зменшуємо N, оскільки останній елемент вже на своєму місці
        } while (swapped);

        return a;
    }

    private static void showSwap(short[] a, int j, int i) {
        // Виводимо масив з показом обміну
        for (int k = 0; k < a.length; k++) {
            System.out.print(a[k] + " ");
            if (k == j) {
                System.out.print("⇄ ");
            }
        }
        System.out.println();
    }

    private static void show(short[] a) {
        if (a == null) return;

        for (short value : a)
            System.out.print(value + " ");
        System.out.println("\n---------------------");
    }

    private static void exchange(short[] a, int j, int i) {
        short temporary = a[i];
        a[i] = a[j];
        a[j] = temporary;
    }

    public static void main(String[] args) {
        short[] arr1 = new short[]{5, 2, 0, 8, -10, 2};
        System.out.println("Початковий масив:");
        show(arr1);
        short[] result1 = sort(arr1);
        System.out.println("Відсортований масив:");
        show(result1);

        short[] arr2 = new short[]{5, 2, Short.MAX_VALUE, 8, -10, Short.MIN_VALUE};
        System.out.println("Початковий масив:");
        show(arr2);
        short[] result2 = sort(arr2);
        System.out.println("Відсортований масив:");
        show(result2);

        try {
            short[] result3 = sort(null);
            show(result3);
        } catch (NullPointerException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
