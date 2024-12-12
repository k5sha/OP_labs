import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Cypher {

    private static void prepare(){
        try {
            FileWriter fileWriter = new FileWriter("CypherTaskExample.txt");
            fileWriter.write("Hello, world!");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cypher(String source, String destination, byte key) throws IOException, IllegalArgumentException {
        if (source == null || source.isEmpty())
            throw new IllegalArgumentException("обов'язковий параметр source");
        if (destination == null || destination.isEmpty())
            throw new IllegalArgumentException("обов'язковий параметр destination");
        if (key == 0b0)
            throw new IllegalArgumentException("ключ 0b0 не шифрує строку, використайте інший");

        byte[] buffer = new byte[1024];  // Розмір буфера для читання і запису (можна регулювати)

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            int bytesRead;
            // Читаємо файл порціями (масивами байтів)
            while ((bytesRead = fis.read(buffer)) != -1) {
                // Шифруємо кожен байт в буфері XOR з ключем
                for (int i = 0; i < bytesRead; i++) {
                    buffer[i] ^= key; // XOR операція
                }
                // Записуємо зашифровані байти у вихідний файл
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("Файл зашифровано: " + destination);
        }
    }

    public static void main(String[] args) {
        prepare();
        try {
            cypher("CypherTaskExample.txt", "CypherTaskExample_encrypted.txt", (byte) 0b01);
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Не вдалося зашифрувати файл. Помилка: " + e.getMessage());
        }
    }

}
