public class lab7 {
    private static void show(short[] a){
        if (a == null)
            return;

        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    private static void demo(SortStrategy sortStrategy){
        short[] result = sortStrategy.sort(new short[]{5, 2, 0, 8, -10, 2});
        show(result);

        short[] result3 = sortStrategy.sort(new short[]{5, 2, Short.MAX_VALUE, 8, -10, Short.MIN_VALUE});
        show(result3);

        try {
            short[] result2 = sortStrategy.sort(null);
            show(result2);
        } catch (NullPointerException e){
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("===== Сортування вставкою =====");
        demo(new InsertionSort());
        System.out.println("===== Сортування бульбашкою =====");
        demo(new BubbleSort());
    }
}
