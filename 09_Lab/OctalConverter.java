public class OctalConverter {

    public static void main(String[] args) {
        // Тестуємо метод на кількох прикладах
        try {
            System.out.println(octStringToInt("777")); // 511
            System.out.println(octStringToInt("10"));  // 8
            System.out.println(octStringToInt("1234")); // 668
            System.out.println(octStringToInt("0"));    // 0
            System.out.println(octStringToInt("8"));    // IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int octStringToInt(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty.");
        }

        // Перевірка, чи містить рядок лише вісімкові цифри
        if (!s.matches("[0-7]+")) {
            throw new IllegalArgumentException("Input string contains invalid characters for octal number.");
        }

        // Перетворення вісімкового числа в десяткове
        return Integer.parseInt(s, 8);
    }
}
