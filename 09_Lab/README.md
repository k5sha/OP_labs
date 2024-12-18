# Лабораторна робота №9
### Тема: String

### Виконано групою номер **12**

[Сама лабороторна](https://docs.google.com/document/d/11B2l13NmIDkrUPen5_xUnoV-wmadlzY4/edit)

### Контрольні питання:

### 1. Що таке immutable об’єкт? Для чого об’єкти класу String зробили імутабельними? Чому клас String задекларований як final?
Immutable об'єкти — це об'єкти, стан яких не можна змінити після створення. У них усі поля встановлюються під час ініціалізації і не змінюються протягом існування об'єкта.

1) Якщо ми не зробимо рядок незмінним, це створить серйозну загрозу безпеці програми. Наприклад, імена користувачів і паролі бази даних передаються як рядки для отримання підключень до бази даних. Описи хоста та порту програмування сокетів також передаються як рядки. Рядок незмінний, тому його значення не можна змінити. Якщо рядок не залишається незмінним, будь-який хакер може спричинити проблему безпеки в програмі, змінивши значення посилання.
2) Інтерування рядків неможливе, якщо String не є незмінним у Java. JRE зберігає багато місця в купі. Оскільки, на ту саму рядкову змінну може посилатися більше ніж одна рядкова змінна. (інтерування: якщо кілька об'єктів мають те саме значення, то на них йде однакове посилання)
3) Рядок безпечний для багатопоточності через його незмінність. Різні потоки можуть отримати доступ до одного "екземпляра рядка". Він усуває синхронізацію для безпеки потоків, оскільки ми неявно робимо рядки потокобезпечними.
4) Незмінність забезпечує безпеку завантаження правильного класу за допомогою Classloader. Наприклад, припустімо, що ми намагаємося завантажити клас java.sql.Connection, але якщо строка з посиланням на клас змінюється на посилається hacked.Connection, то завдаються небажані дії нашій базі даних.

Рядок робиться final, щоб не дозволити іншим розширити його та не дозволити знищити його імутабельність (imutable).

### 2. Що таке регулярні вирази? Наведіть приклади регулярних виразів.
регулярний вираз — це рядок, що описує або збігається з множиною рядків, відповідно до набору спеціальних синтаксичних правил. Вони використовуються для пошуку та зміни тексту на основі заданих шаблонів.

(\d\d\d\d) — знаходить групу з 4 цифр
```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example {
    public static void main(String[] args) {
        final String regex = "(\\d\\d\\d\\d)";
        final String string = "1234567890";
        
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);
        
        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));
            
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }
    }
}

```
### 3. В чому полягає різниця між оператором «==» та методом «equals()»?
Метод equals() у Java використовується для порівняння двох об’єктів на основі їхніх даних (для рядків це послідовності символів). Оператор == порівнює значення для примітивних типів даних і адреси для об’єктів.
### 4. Для чого потрібні класи StringBuilder та StringBuffer?
StringBuilder — mutable (змінний), тому він працює набагато швидше для частих змін ніж String. Для кожної зміни String створюється новий об'єкт, а для StringBuilder - ні . StringBuffer це версія StringBuilder, яка є синхронизованою і  thread-safe.
### 5. Яким чином простіше всього прибрати пробіли на початку та кінці об’єкту String?
Використовуючи метод .trim()
