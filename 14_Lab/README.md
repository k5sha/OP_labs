# Лабораторна робота №14
### Тема: Потоки вводу-виводу

### Виконано групою номер **12**

[Сама лабороторна](https://docs.google.com/document/d/10tv_WZJd5Mk_tKCAxWZw1BLSuN6kBXoi/edit)

### Контрольні питання:

### 1. Що таке потоки вводу-виводу?
# Потоки вводу-виводу в Java

Потоки вводу-виводу в Java (I/O Streams) — це механізм, який дозволяє читати або записувати дані в джерела, такі як файли, мережеві з'єднання, пам'ять тощо. Потоки в Java поділяються на дві основні категорії:

## 1. Потоки байтів (Byte Streams)
- Призначені для роботи з байтовими даними (наприклад, зображення, аудіо, файли).
- Використовують класи, що успадковують `InputStream` та `OutputStream`.
- Основні класи:
  - `FileInputStream` / `FileOutputStream`
  - `BufferedInputStream` / `BufferedOutputStream`
  - `DataInputStream` / `DataOutputStream`

### Приклад:
```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamExample {
    public static void main(String[] args) {
        try (FileInputStream input = new FileInputStream("input.txt");
             FileOutputStream output = new FileOutputStream("output.txt")) {
            int data;
            while ((data = input.read()) != -1) {
                output.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### 2. Що таке блокуючий і неблокуючий ввід-вивід?

## 1. **Блокуючий ввід-вивід (Blocking I/O):**
Блокуючий ввід-вивід означає, що потік виконавчого коду зупиняється (блокується), доки операція вводу-виводу (I/O) не буде завершена. Це традиційний підхід до роботи з I/O в Java, який забезпечує простоту реалізації, але може спричинити затримки.

### Характеристики:
- Потік зупиняється під час виконання операції I/O (наприклад, читання з файлу чи мережі).
- Простий у використанні, оскільки операції виконуються послідовно.
- Може призводити до втрати продуктивності через блокування потоку.

### Приклад:
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BlockingIOExample {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## 2. Потоки символів (Character Streams)

- **Призначення:** Для роботи з текстовими даними (символи Unicode).
- **Класи:** Використовують класи, що успадковують `Reader` та `Writer`.
- **Основні класи:**
  - `FileReader` / `FileWriter`
  - `BufferedReader` / `BufferedWriter`
  - `PrintWriter`

### Приклад:
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamExample {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
             FileWriter writer = new FileWriter("output.txt")) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

```

## 3. Ключові особливості:

- **Буферизація:** Використання буферизованих потоків (`BufferedInputStream`, `BufferedReader`) дозволяє зменшити кількість запитів до джерела даних.
- **Ланцюгові потоки:** Потоки можна комбінувати для розширення функціональності (наприклад, додавання буферизації до базових потоків).
- **Кодування:** Потоки символів дозволяють працювати з різними кодуваннями тексту (UTF-8, ISO-8859-1 тощо).

## 2. **Неблокуючий ввід-вивід (Non-blocking I/O):**

Неблокуючий ввід-вивід дозволяє виконувати операції I/O без блокування потоку. У Java це реалізовано за допомогою пакету **NIO (New Input/Output)**. Потік може перевіряти, чи доступні дані, і виконувати інші завдання, поки дані не стануть доступними.

### Характеристики:
- Потік не блокується під час очікування завершення операції I/O.
- Використовується для масштабованих систем (наприклад, серверів із великою кількістю з'єднань).
- Потребує складнішої реалізації (наприклад, використання селекторів).

### Приклад:
```java
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NonBlockingIOExample {
    public static void main(String[] args) {
        try (FileChannel channel = FileChannel.open(Paths.get("input.txt"), StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (channel.read(buffer) > 0) {
                buffer.flip(); // Переключення в режим читання
                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());
                }
                buffer.clear(); // Очищення для наступного запису
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

```
## 3. **Основні відмінності між блокуючим та неблокуючим I/O:**

| Параметр               | Блокуючий I/O                   | Неблокуючий I/O                 |
|------------------------|---------------------------------|---------------------------------|
| **Блокування**          | Потік блокується під час I/O   | Потік не блокується            |
| **Простота реалізації** | Простий                       | Складний                       |
| **Продуктивність**      | Залежить від швидкості I/O     | Висока у багатозадачних системах |
| **Застосування**        | Невеликі програми, де блокування допустиме | Сервери, масштабовані програми |

### 3. Чим InputStream відрізняється від Reader?

## 1. **InputStream**
- **Призначення:** Працює з байтовими потоками (8-бітові дані).
- **Використання:** Для читання файлів, зображень, аудіо, відео, та інших даних, які не є текстовими.
- **Базовий клас:** `InputStream`.
- **Ключові методи:**
  - `int read()`: Зчитує один байт.
  - `int read(byte[] b)`: Зчитує масив байтів.
  - `void close()`: Закриває потік.
- **Пакет:** `java.io`.

### Приклад:
```java
import java.io.FileInputStream;
import java.io.IOException;

public class InputStreamExample {
    public static void main(String[] args) {
        try (FileInputStream inputStream = new FileInputStream("example.txt")) {
            int data;
            while ((data = inputStream.read()) != -1) {
                System.out.print((char) data); // Перетворення байта в символ
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## 2. **Reader**

- **Призначення:** Працює з потоками символів (16-бітові дані, підтримує Unicode).
- **Використання:** Для роботи з текстовими файлами або потоками, що містять символи.
- **Базовий клас:** `Reader`.
- **Ключові методи:**
  - `int read()`: Зчитує один символ.
  - `int read(char[] cbuf)`: Зчитує масив символів.
  - `void close()`: Закриває потік.
- **Пакет:** `java.io`.

### Приклад:
```java
import java.io.FileReader;
import java.io.IOException;

public class ReaderExample {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("example.txt")) {
            int data;
            while ((data = reader.read()) != -1) {
                System.out.print((char) data); // Вивід символу
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

```
## 3. **Основні відмінності між InputStream і Reader**

| Параметр                | InputStream                        | Reader                          |
|-------------------------|------------------------------------|---------------------------------|
| **Тип даних**            | Байти (8 біт)                     | Символи (16 біт, Unicode)       |
| **Призначення**          | Бінарні дані (зображення, аудіо)   | Текстові дані                   |
| **Базовий клас**         | `InputStream`                     | `Reader`                        |
| **Методи**               | `read()` повертає байт            | `read()` повертає символ        |
| **Підтримка Unicode**    | Ні                                | Так                             |
| **Приклади використання**| Читання файлів PNG, MP3 тощо       | Читання текстових файлів        |

### 4. Якщо потрібно обробити велику кількість байтів а файлі, як це краще всього робити з точки зору швидкодії? Як це краще НЕ робити?
# Обробка великої кількості байтів у файлі: Рекомендації для швидкодії

1. **Використовувати буферизовані потоки:**
   - Використовуйте `BufferedInputStream` або `BufferedReader` для зменшення кількості операцій читання з диска.
   - Буфер дозволяє зчитувати великі блоки даних за одну операцію, що значно прискорює обробку.
### Приклад:
```java
   import java.io.BufferedInputStream;
   import java.io.FileInputStream;
   import java.io.IOException;

   public class BufferedReadExample {
       public static void main(String[] args) {
           try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("largefile.dat"))) {
               byte[] buffer = new byte[8192]; // Розмір буфера (8 KB)
               int bytesRead;
               while ((bytesRead = bis.read(buffer)) != -1) {
                   // Обробка даних у buffer
               }
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
   }
```

## **Обробляти дані блоками**

- **Підхід:** Замість читання по одному байту використовуйте масиви байтів (`byte[]`) для читання великих блоків даних.
- **Переваги:**
  - Зменшується кількість операцій вводу-виводу, що знижує навантаження на дискову підсистему.
  - Покращується швидкодія завдяки зчитуванню великих обсягів даних за одну операцію.

### Приклад:
```java
import java.io.FileInputStream;
import java.io.IOException;

public class BlockReadExample {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("largefile.dat")) {
            byte[] buffer = new byte[8192]; // Розмір блоку
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                // Обробка buffer[0..bytesRead-1]
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## **Використовувати NIO (New Input/Output)**

- **Підхід:** Потоки `FileChannel` і буфери `ByteBuffer` із пакету NIO забезпечують ефективне оброблення даних.
- **Переваги:**
  - Підтримка неблокуючих операцій.
  - Зручна робота з великими файлами.
  - Висока швидкодія завдяки прямому доступу до пам'яті.

### Приклад:
```java
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NIOExample {
    public static void main(String[] args) {
        try (FileChannel channel = FileChannel.open(Paths.get("largefile.dat"), StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(8192); // Розмір буфера
            while (channel.read(buffer) > 0) {
                buffer.flip(); // Перехід у режим читання
                // Обробка buffer
                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());
                }
                buffer.clear(); // Підготовка до наступного запису
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## **Як НЕ слід обробляти великі файли**

1. **Не читати файл байт за байтом:**
   - Читання по одному байту (`InputStream.read()`) створює значне навантаження на дискові операції, що суттєво уповільнює виконання програми.

### Приклад (повільно):
```java
   import java.io.FileInputStream;
   import java.io.IOException;

   public class SlowReadExample {
       public static void main(String[] args) {
           try (FileInputStream fis = new FileInputStream("largefile.dat")) {
               int data;
               while ((data = fis.read()) != -1) {
                   // Повільна обробка байтів
               }
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
   }
```

## **Як НЕ слід обробляти великі файли**

1. **Не використовувати занадто маленький буфер:**
   - Занадто малий розмір буфера призводить до частих викликів вводу-виводу, що значно знижує продуктивність.

2. **Не обробляти файл повністю в пам'яті (якщо файл дуже великий):**
   - Якщо файл завантажується повністю в оперативну пам'ять, це може призвести до перевантаження пам'яті або помилки OutOfMemoryError.

### 5. Як працює конструкція try-with-resource? Яким чином слід використовувати цю конструкцію при роботі з файлами?

# Конструкція `try-with-resources` в Java

Конструкція `try-with-resources` забезпечує автоматичне закриття ресурсів після завершення використання. Це дозволяє уникнути витоків ресурсів, таких як файли, сокети чи потоки.

## Основні особливості:
1. Автоматично закриває ресурси, які реалізують інтерфейс `AutoCloseable`.
2. Забезпечує більш чистий та безпечний код.
3. Підтримується з Java 7 і вище.

---

## Синтаксис:

```java
try (ResourceType resource = new ResourceType()) {
    // Використання ресурсу
} catch (ExceptionType e) {
    // Обробка винятків
}
```

## Використання з файлами

При роботі з файлами часто використовуються потоки вводу-виводу. Конструкція `try-with-resources` забезпечує автоматичне закриття цих потоків після завершення роботи.

### Переваги:
- Автоматичне закриття файлів і потоків.
- Зниження ризику витоків ресурсів.
- Покращення читабельності коду.

### Приклад 1: Читання файлу
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesExample {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## Переваги використання `try-with-resources`

1. **Менше коду:** 
   - Не потрібно вручну закривати ресурси через блок `finally`.
   - Код стає компактнішим і зручнішим для написання.

2. **Безпека:** 
   - Автоматичне закриття ресурсів запобігає витокам, навіть якщо під час виконання коду виник виняток.

3. **Читабельність:** 
   - Завдяки меншій кількості коду та автоматизації закриття ресурсів програма стає легшою для розуміння та підтримки.

### Порівняння з традиційним підходом:

#### Без `try-with-resources`:
```java
BufferedReader reader = null;
try {
    reader = new BufferedReader(new FileReader("example.txt"));
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
} catch (IOException e) {
    e.printStackTrace();
} finally {
    if (reader != null) {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

#### З `try-with-resources`:
```java
try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"))) {
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

### 6. Для чого потрібні методи flush() та close()?

## 1. **Метод `flush()`**

### Призначення:
Метод `flush()` використовується для примусового запису буферизованих даних у кінцевий потік (наприклад, у файл, сокет, тощо). Це гарантує, що всі дані, які зберігаються в буфері, будуть записані.

### Використання:
- В основному застосовується з буферизованими потоками (`BufferedWriter`, `BufferedOutputStream`) або потоками виводу (`OutputStream`, `Writer`).
- Забезпечує, що дані не залишаться у буфері після запису.

### Приклад:
```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FlushExample {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("example.txt"))) {
            writer.write("Hello, World!");
            writer.flush(); // Примусовий запис у файл
            System.out.println("Дані записані у файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## 2. **Метод `close()`**

### Призначення:
Метод `close()` закриває потік або ресурс, звільняючи системні ресурси (дескриптори файлів, сокети тощо). Після закриття потік більше не можна використовувати.

### Використання:
- Автоматично викликає метод `flush()`, якщо потік підтримує буферизацію.
- Обов'язково викликається в кінці роботи з ресурсом.

### Приклад:
```java
import java.io.FileWriter;
import java.io.IOException;

public class CloseExample {
    public static void main(String[] args) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("example.txt");
            writer.write("Hello, World!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close(); // Закриває потік
                    System.out.println("Потік закрито.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

## Відмінності між `flush()` та `close()`

| Параметр            | `flush()`                                  | `close()`                          |
|---------------------|-------------------------------------------|-------------------------------------|
| **Призначення**      | Примусовий запис буферизованих даних      | Закриває потік і звільняє ресурси   |
| **Використання**     | У процесі роботи з потоком                | Після завершення роботи з потоком  |
| **Автоматизація**    | Потрібно викликати вручну                 | Викликає `flush()` перед закриттям |
| **Після виклику**    | Потік продовжує працювати                 | Потік більше не можна використовувати |

