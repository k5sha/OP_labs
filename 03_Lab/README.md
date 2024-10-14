# Лабораторна робота №3
### Тема: Управління потоком виконання

### Виконано групою номер **12**

[Сама лабороторна](https://docs.google.com/document/d/11fW-pEmBKQ1iS3uXwppY2oJHCmGSY36P/edit)
### Контрольні питання:
### 1. Що таке структурне програмування? 
Структурне програмування — це парадигма програмування, яка передбачає поділ програми на логічно зв'язані блоки (підпрограми або функції). Основна ідея структурного програмування полягає в тому, щоб спростити розробку та підтримку програмного коду, зменшивши складність і підвищивши читабельність коду.
### 2. Назвіть основні конструкції структурного програмування.
Основні концепції структурного програмування:
    Послідовність — виконання команд відбувається одна за одною, лінійно.
    Розгалуження — це можливість виконувати різні блоки коду залежно від умов (наприклад, конструкції if-else).
    Цикли — дозволяють виконувати певний блок коду багаторазово (наприклад, цикли for, while).
### 3. Назвіть основні принципи структурного програмування.
Основні принципи структурного програмування:
    Модульність — поділ програми на незалежні модулі або функції.
    Використання логічних структур — в програмі використовуються чітко визначені структури: послідовності, розгалуження, цикли.
### 4. Поясніть, чому в більшості мов програмування не радять використовувати оператор GOTO, а в мові Java його взагалі немає?
Відмова від використання оператора goto — замість безладного перескакування між частинами коду програма виконується послідовно або в рамках керованих структур.
### 5. Що таке спагеті-код?
Спагеті-код — це жаргонний термін, який описує заплутаний і неструктурований код, де важко розібратися в логіці програми. Такі програми нагадують клубок спагеті, в якому важко простежити, де початок і де кінець.
### 6. Що таке проектування зверху-вниз? В чому його переваги?
Проектування зверху-вниз (top-down design) — це метод розробки програмного забезпечення або системи, коли спочатку розробляються загальні концепції і високорівневі компоненти, а потім поступово деталізуються до конкретних підсистем і модулів. Процес починається з абстрактної картини всього проєкту, після чого проєкт розбивається на менші частини, які розробляються незалежно одна від одної.
### 7. Що таке область видимості ідентифікатора?
Область видимості ідентифікатора (scope) — це частина програми, в межах якої можна отримати доступ до змінної, функції або будь-якого іншого ідентифікатора (наприклад, константи). Іншими словами, область видимості визначає, де саме в коді ідентифікатор є видимим і доступним для використання.
### 8. Що таке блок? Як блоки впливають на область видимості?
Блок у програмуванні — це група інструкцій, яка утворює логічно завершений фрагмент коду. 
   Блок зазвичай включає одну або більше інструкцій, які об'єднані в певному контексті, наприклад, всередині умовних операторів, циклів, функцій, класів тощо. У багатьох мовах програмування блоки обмежуються фігурними дужками {} (наприклад, у C, Java) або відступами (в Python).
   Блоки визначають області видимості ідентифікаторів (змінних, функцій і класів). У різних мовах програмування правила впливу блоків на область видимості можуть відрізнятися.
### 9. Наведіть приклади, у яких випадках краще використовувати наступні оператори та конструкції:
	  - if
	  - if-else
	  - ланцюги if-else if -else if...
	  - switch
	  - тернарна умовна операція ?:
Вибір між if, if-else, ланцюгами if-else if, switch та тернарною операцією залежить від конкретної задачі, кількості умов, читабельності коду та особистих переваг програміста. Ось загальні рекомендації.
Коли використовувати який варіант:
	Тернарна операція: Найкраще підходить для простих умовних виразів, які повертають одне з двох значень.
	switch: Використовуйте для перевірки одного значення на рівність кільком константам, особливо якщо умови не перекриваються.
	if-else: Для двох взаємовиключних умов.
	Ланцюги if-else if: Для багатьох взаємовиключних умов.
	if: Для простих перевірок однієї умови.
### 10. Наведіть приклади, у яких випадках краще використовувати наступні оператори та конструкції:
           - while
	   - do-while
	   - for
### 11. Чим оператор break відрізняється від оператора continue?
Оператори break та continue використовуються для керування потоком виконання циклів у Java, але вони мають різну поведінку.
Оператор break призначення для призупиняє виконання найближчого циклу (while, do-while або for) та передає управління на інструкцію, що йде одразу після циклу.
ператор continue призначення для ризупиняє поточну ітерацію циклу та переходить до наступної ітерації. Тобто, пропускає решту коду в тілі циклу для поточної ітерації.
### 12. Навіщо у мові Java є мітки, якщо немає goto?
В Java немає оператора goto, який дозволяє безпосередньо переходити до будь-якої точки коду, мітки все ж таки використовуються. Але для чого, якщо ми не можемо використати їх для безпосередніх переходів?
### 13. До якого результату призведе виконання наступного фрагменту коду? Перевірте. Поясніть.
```Java
        boolean a = false;
        boolean b = false;        
        if (a=false) {
            System.out.println("a is false");
        } 
        if (b=true) {
            System.out.println("b is true");
        }
        if (a=b) {
            System.out.println("a = b");
        }
```
```Java
a is false
b is true
a = b
```
### 14. До якого результату призведе виконання наступного фрагменту коду? Перевірте. Поясніть.
``` Java      
        int a = 1;
        a++;
        ++a;        
        switch(a) {
            case 1: System.out.println("1");
            case 2: System.out.println("2");
            case 3: System.out.println("3");
            case 4: System.out.println("4");            
        }
```
```Java
3
4
```
### 15. До якого результату призведе виконання наступного фрагменту коду (true/false)? Перевірте. Поясніть.
```Java   
        double sum = 0;                
        // Let's find: 1 + 1/2 + 1/3 + 1/4 + 1/5 + ...
        for(int i=1; i<10; i++) {
            sum = sum + 1/i;
        }
        System.out.println(sum > 1);
```
```Java
False
A JNI error has occurred, please check your installation and try again
```