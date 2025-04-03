//import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static final String delimeter = "\n...........\n";
    public static <Scanner> void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.println("Hello and welcome!");
//
//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.print(i + "\t");
//        }
/*
        boolean condition = true;
        System.out.println(condition);
        System.out.println(Boolean.TYPE);

        System.out.println(Character.TYPE);

        System.out.println(Short.TYPE);
        System.out.println(Short.SIZE);//Размер в битах
        System.out.println(Short.BYTES);//Размер в байтах

        System.out.println(Short.MIN_VALUE);
        System.out.println(Short.MAX_VALUE);

        /// ////////////////////////////////////////////////
        System.out.println("ЦЕЛОЧИСЛЕННЫЕ ТИПЫ");

        System.out.println
                (
                        "Переменная типа %-7s занимает %d байт памяти (%d бит памяти), и принимает значения в диапазоне от %d до %d".
                                formatted("byte", Byte.BYTES, Byte.SIZE, Byte.MIN_VALUE, Byte.MAX_VALUE)
                );
        System.out.println
                (
                        "Переменная типа %-7s занимает %d байт памяти (%d бит памяти), и принимает значения в диапазоне от %d до %d".
                                formatted("short", Short.BYTES, Short.SIZE, Short.MIN_VALUE, Short.MAX_VALUE)
                );
        System.out.println
                (
                        "Переменная типа %-7s занимает %d байт памяти (%d бит памяти), и принимает значения в диапазоне от %d до %d".
                                formatted("int", Integer.BYTES, Integer.SIZE, Integer.MIN_VALUE, Integer.MAX_VALUE)
                );
        System.out.println
                (
                        "Переменная типа %-7s занимает %d байт памяти (%d бит памяти), и принимает значения в диапазоне от %d до %d".
                                formatted("long", Long.BYTES, Long.SIZE, Long.MIN_VALUE, Long.MAX_VALUE)
                );

        System.out.println("ВЕЩЕСТВЕННЫЕ ТИПЫ");

        System.out.println
                (
                        "Переменная типа %-7s занимает %d байт памяти (%d бит памяти), и принимает значения в диапазоне от %e до %e".
                                formatted("float", Float.BYTES, Float.SIZE, Float.MIN_VALUE, Float.MAX_VALUE)
                );
        System.out.println
                (
                        "Переменная типа %-7s занимает %d байт памяти (%d бит памяти), и принимает значения в диапазоне от %e до %e".
                                formatted("double", Double.BYTES, Double.SIZE, Double.MIN_VALUE, Double.MAX_VALUE)
                );
        System.out.println(delimeter);
        /// ////////////////////////////////////////////////////
        System.out.println("КОНСТАНТЫ");
        int speed = 0;
        final int MAX_SPEED = 250;

        System.out.println(((Object)512).getClass().getSimpleName());
        System.out.println(((Object)512L).getClass().getSimpleName());
        System.out.println(((Object)512.f).getClass().getSimpleName());

        System.out.println("Ввод с клавиатуры");

        //Scanner kb = new Scanner(System.in);
        java.util.Scanner kb = new java.util.Scanner(System.in);
        int a = kb.nextInt();
        System.out.println("Вы ввели значение " + a);
        System.out.println(5.5%2);

        System.out.println("Введите направление");
        String direction = kb.nextLine();
        switch (direction)
        {
            case "left":
                System.out.println("Идем налево");
                break;
            case "right":
                System.out.println("Идем направо");
                break;
           case "forward":
                System.out.println("Идем вперед");
                break;
            case "backward":
                System.out.println("Идем назад");
                break;
            default:
                System.out.println("Ошибка ввода");
        }
*/

//////////////////////////Определение даты Пасхи в указанном году/////////////////////////////////////////////////////
        System.out.println("Программа определения даты Пасхи в указанном пользователем году");
        System.out.println("Введите год в периоде с 1900г по 2099г (для XX–XXI веков) (например, 2025):");
        java.util.Scanner kb = new java.util.Scanner(System.in);
        int year = kb.nextInt();//Метод nextInt() класса Scanner
        // 1. Алгоритм Гаусса (упрощённый)
        int a = year % 19;
        int b = year % 4;
        int c = year % 7;
        int d = (19 * a + 15) % 30;
        int e = (2 * b + 4 * c + 6 * d + 6) % 7;
        int day = d + e;

        // 2. Определение даты (старый стиль)
        if (day <= 9) {
            day += 22; // Март
        } else {
            day -= 9;  // Апрель
        }

        // 3. Исключения (редкие случаи)
        if (d == 29 && e == 6) day = 19;
        if (d == 28 && e == 6) day = 18;

        // 4. Переход в новый стиль (+13 дней для XX-XXI веков)
        day += 13;
        String month = (day > 30) ? "мая" : "апреля"; // Простое определение месяца

        // 5. Вывод результата
        System.out.println("Православная Пасха по новому стилю в " + year + "г.: "+ day + " " + month);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


///  ////////проверка является ли число Палиндромом///////////////////////////////////////////////////////////////////
        System.out.println("Программа-проверка является ли число Палиндромом");
        System.out.println("Введите число:");
        java.util.Scanner kb = new java.util.Scanner(System.in); // kb - keyboard
        int number = kb.nextInt();//Метод nextInt() класса Scanner

        int original = number; // Сохраняем оригинальное число
        int reversed = 0;// инициализируем переменную для перевернутого числа

        if (number < 0)
        {
            System.out.println("Число " + number + " - НЕ палиндром (отрицательные числа не учитываются)");
        }
        else if (number < 10)
        {
            System.out.println("Число " + number + " - палиндром (однозначное число)");
        }
        else
        {
            // Переворачиваем число только если оно положительное, а также двузначное и больше
            while (number > 0)
            {
                reversed = reversed * 10 + number % 10;
                number /= 10;
            }

            if (original == reversed)
            {
                System.out.println("Число " + original + " - палиндром (перевёрнутое: " + reversed + ")");
            }
            else
            {
                System.out.println("Число " + original + " - НЕ палиндром (перевёрнутое: " + reversed + ")");
            }
        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//////////////////Программы вывода чисел на экран до указанного предела/////////////////////////////////////////////////
        System.out.println("Введите верхний предел:");
        java.util.Scanner kb = new java.util.Scanner(System.in); // kb - keyboard
        int limit = kb.nextInt();//Метод nextInt() класса Scanner
 /// ///////Вывод на экран ряд чисел Фибаначчи, до указанного предела///////////////////////////////////////////////////
        System.out.println("Программа вывода на экран ряда чисел Фибаначчи, до указанного предела");
        System.out.println("Ряд Фибоначчи до " + limit + ":");
        int a = 0, b = 1;
        System.out.print(a + " " + b + " "); // Выводим первые два числа
        while (true)
        {
            int next = a + b;
            if (next > limit)
            {
                break;
            }
            System.out.print(next + " ");
            a = b;
            b = next;
        }
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////Вывод на экран ряда простых чисел, до указанного предела (алгоритм решето Эратосфена)////////////////////////
//Простое число — это натуральное число (целое положительное),
//которое имеет ровно два различных натуральных делителя: 1 и само себя
//Пример:7 — простое (делится на 1 и 7); 6 — составное (делится на 1, 2, 3, 6)
        System.out.println("\n"+"Программа вывода на экран ряда простых чисел, до указанного предела (алгоритм решето Эратосфена)");
        System.out.println("Ряд простых чисел до " + limit + ":");

/// ///////Вывод на экран ряда совершенных чисел, до указанного предела (алгоритм Мерсенна)//////////////////////////////
//Совершенные числа — это натуральные числа,
//которые равны сумме всех своих собственных делителей (делителей, меньших самого числа)
//Пример:6 (Делители (кроме 6): 1, 2, 3; Сумма: 1+2+3=6)
        System.out.println("\n"+"Программа вывода на экран ряда совершенных чисел, до указанного предела (алгоритм Мерсенна)");
        System.out.println("Ряд совершенных чисел до " + limit + ":");

    }
}