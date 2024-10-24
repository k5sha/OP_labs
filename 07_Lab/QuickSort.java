
public class QuickSort implements SortStrategy {

    /**
     * Сортування швидким методом за спаданням
     *
     * Найгірший випадок (сортований масив) — O(N²)
     * Найкращий випадок (випадкові дані) — O(N log N)
     *
     * @param array - масив чисел short
     * @return відсортований за спаданням масив
     */
    @Override
    public short[] sort(short[] array) {
        if (array == null) {
            throw new NullPointerException("Не можливо сортувати null");
        }

        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(short[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private int partition(short[] arr, int low, int high) {
        short pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] >= pivot) { // Змінено на >= для спадання
                i++;
                exchange(arr, i, j);
            }
        }

        exchange(arr, i + 1, high);
        return i + 1;
    }

    private static void exchange(short[] a, int j, int i) {
        short temporary = a[i];
        a[i] = a[j];
        a[j] = temporary;
    }

}
