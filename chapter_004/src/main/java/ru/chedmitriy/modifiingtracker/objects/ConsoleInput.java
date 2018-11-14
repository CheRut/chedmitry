package ru.chedmitriy.modifiingtracker.objects;



import ru.chedmitriy.modifiingtracker.models.InputIntValue;
import ru.chedmitriy.modifiingtracker.models.InputStrValue;
import ru.chedmitriy.modifiingtracker.models.Output;

import java.util.Scanner;

/**
 *
 * Класс ввода-вывода
 *
 */
public class ConsoleInput implements InputStrValue, InputIntValue, Output {

    /**
     * читаем с консоли
     * */
    private final Scanner scanner = new Scanner(System.in);

    /**
     *.
     * Запрос -  ответ
     * @param question - запрос
     * @return  - ответ*/
    public String ask(final String question) {
        System.out.println(question);
        return scanner.next();
    }
    /**
     * запрос -ответ при выборе пунктов меню
     * @param question - запрос
     *                 @return - ответ (число)
     * */
    public int chooseOption(final String question) {
        System.out.print(question);
        return scanner.nextInt();
    }
    /**
     * Вывод в консоль с новой строки
     * @param obj - передаваемый параметр
     * */
    public void outPrintln(final Object obj) {
        System.out.println(obj);
    }

}
