package ru.chedmitriy.bracketschecker;

/**.
 * @author Dmitry Cherutsa on 10.12.2016.
 * @version $Id$
 * @project junior
 * @since 0.1
 * Методы данного класса определяют
 * наличие и количество открытых и закрытых скобок
 */
public class BracketsChecker {

    /**.
     * Счетчик открытых
     * скобок
     * */
        private   int open = 0;
    /**.
     * Счетчик закрытых
     * скобок
     * */
        private  int close = 0;


    /**.
     * Главный метод,определяющий
     * все ли открытыескобки закрыты
     * @param s - строка, массив символов
     * @return correct: true при
     * равном количестве чскобок,иначе-false;
     * */
    public boolean bracketsOpenAndClose(String s) {
        boolean correct = false;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == '(') && (s.indexOf(')') > s.indexOf('('))) {
                open++;
            } else {
                close++;
            }
        }
         if (open == close) {
             correct = true;
         }

        return correct;
    }



}
