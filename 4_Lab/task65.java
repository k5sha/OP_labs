import java.util.Arrays;

public class task65 {

    /**
     * Формує новий масив, елементи якого це елементи старого масиву у зворотному порядку
     * @param originalArray масив цілих чисел
     * @return обернений масив
     */
    public static int[] reverse(int[] originalArray){
        if(originalArray == null)
            return null;

        int[] reversedArray = new int[originalArray.length];

        for (int i = 0; i < originalArray.length; i++) {
            reversedArray[i] = originalArray[originalArray.length - i - 1];
        }

        return reversedArray;
    }

    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3, 4, 5};
        int[] reversedArray;

        reversedArray = reverse(originalArray);
        System.out.println(Arrays.toString(reversedArray));

        reversedArray = reverse(null);
        System.out.println(Arrays.toString(reversedArray));
    }
}
