# Лабораторна робота №13
### Тема: Exceptions.

### Виконано групою номер **12**

[Сама лабороторна](https://docs.google.com/document/d/10vqYm9BCOLsB_NeguXYhOdFTZYocVnnJ/edit)

### Контрольні питання:

### 1. Для чого потрібні виняткові ситуації?

Виняткові ситуації використовуються для обробки помилок та несподіваних подій, що виникають під час виконання програми. Вони дозволяють програмі реагувати на різні проблеми, такі як неправильний ввід користувача, відсутність файлів, помилки мережі тощо, без аварійного завершення роботи. Це покращує надійність та стабільність програмного забезпечення.
```Java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Ділення на нуль неможливе.");
}
```

---

### 2. Чим Exception відрізняється від Error?

- **Exception** — це об'єкт, який сигналізує про умову, яку можна або очікувано обробити в коді. Наприклад, `IOException`, `SQLException`.
- **Error** — це об'єкт, що сигналізує про критичну помилку, яку неможливо або небажано обробляти. Наприклад, `OutOfMemoryError`, `StackOverflowError`. Вони зазвичай викликані проблемами, пов’язаними з середовищем виконання.

---

### 3. Чим Exception відрізняється від RuntimeException?

- **Exception** — це базовий клас для всіх винятків, включаючи як checked, так і unchecked винятки.
- **RuntimeException** — це підклас `Exception`, що представляє unchecked винятки. Ці винятки виникають під час виконання програми (наприклад, `NullPointerException`, `ArrayIndexOutOfBoundsException`) і зазвичай є результатом помилок програмування.

---

### 4. Що таке stack trace?

Stack trace — це список викликів методів, які привели до виняткової ситуації. Він показує, в якому місці програми сталася помилка, та відображає порядок викликів методів у зворотному хронологічному порядку (від поточного до кореневого).

---

### 5. Що таке cause?

**Cause** — це першопричина винятку, тобто інший виняток, який викликав поточний. Використовується для створення ланцюга винятків і зручнішого відстеження першоджерела помилки. Задається під час створення винятку через конструктор або метод `initCause()`.

---

### 6. Чим throw відрізняється від throws?

- **throw** — це оператор, який використовується для генерації винятку у виконуваному коді.
  ```java
  throw new IOException("Помилка вводу/виводу");
  ```
---

### 7. В чому полягає відмінність використання throws з checked та unchecked exceptions?
- **Checked exceptions** (наприклад, `IOException`) обов’язково потрібно вказувати в сигнатурі методу через `throws` або обробляти їх у блоці `try-catch`.
- **Unchecked exceptions** (наприклад, `NullPointerException`) не потребують вказівки через `throws`. Вони зазвичай обробляються лише за необхідності.

**Приклад з checked exceptions:**
```java
public void readFile(String path) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(path));
    System.out.println(reader.readLine());
    reader.close();
}
```
---

### 8. У яких випадках може не виконатись блок finally?
+ Блок finally може не виконатись у наступних випадках:
    1. Якщо JVM аварійно завершує роботу (наприклад, через System.exit()).
    2. Якщо сталася критична помилка (Error), яка зупинила виконання програми.
    3. Якщо потік викликаний до завершення під час виконання try або catch.
```Java
public void exampleFinally() {
    try {
        System.out.println("Робота у блоці try");
        System.exit(0); // JVM завершує виконання
    } finally {
        System.out.println("Цей блок не буде виконаний");
    }
}
```
---

### 9. Чи можна у конструкції try-catch-finally прибрати try або catch або finally або catch та finally?
+ Не можна прибрати try, оскільки він є основною частиною конструкції.
+ catch можна опустити, якщо є блок finally.
+ finally можна опустити, якщо є блок catch.
+ Не можна прибрати catch та finally одночасно, оскільки хоча б один із них повинен бути присутнім.
```Java
   // Без catch, але з finally
try {
    System.out.println("Робота у блоці try");
} finally {
    System.out.println("Робота у блоці finally");
}

// Без finally, але з catch
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Оброблено виняток: " + e.getMessage());
}
```
---

### 10. Пояснити, для чого потрібна та як працює конструкція try-with-resources? 
Конструкція try-with-resources використовується для автоматичного закриття ресурсів (файлів, потоків тощо), які реалізують інтерфейс AutoCloseable. Це дозволяє уникнути витоків ресурсів. Ресурси закриваються автоматично після завершення блоку try.
```Java
public void readFileWithResources(String path) {
    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
        System.out.println(reader.readLine());
    } catch (IOException e) {
        System.out.println("Помилка читання файлу: " + e.getMessage());
    }
    // Ресурс reader закриється автоматично.
}
```
