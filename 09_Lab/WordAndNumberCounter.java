public class WordAndNumberCounter {

    public static void main(String[] args) {
        // Тестуємо метод на кількох прикладах
        try {
            System.out.println(countNumbers("The user with the nickname koala757677 this month wrote 3 times more comments than the user with the nickname croco181dile920 4 months ago")); // 2
            System.out.println(countNumbers("123 hello 456 789")); // 3
            System.out.println(countNumbers("No numbers here!")); // 0
            System.out.println(countNumbers("123456")); // 1
            System.out.println(countNumbers("")); // 0
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int countNumbers(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Input string cannot be null.");
        }

        // Розбиваємо рядок на слова
        String[] words = s.split("\\s+");

        int count = 0;
        for (String word : words) {
            // Перевіряємо, чи є слово числом
            if (word.matches("\\d+")) {
                count++;
            }
        }

        return count;
    }
}
