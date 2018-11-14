package ru.chedmitriy.chess.context;


/**.
 * @author Dmitry Cherutsa on 10.12.2016.
 * @version $Id$
 * @project junior
 * @since 0.1
 * Класс 'Cell'- несет в себе информацию о ячейках будущей шахматной доски:
 * меняет координаты фигур при их перемещении
 *
 * */
public class Cell {
    public Cell[] getCells() {
        return cells;
    }

    Cell[] cells = new Cell[16];
    /**.
     * Параметр x - координата горизонтальной состовляющей положения
     * фигуры
     * */
    public int x;
    /**.
     *
     * Параметр y - координата вертикальной состовляющей положения
     * фигуры
     * */
    public int y;

    /**.
     * Cell - конструктор по умолчанию
     * */
    public Cell() {

    }
    /**.
     * Cell - базовый конструктор
     * @param x - координата x параметра position класса Figure
     * @param y - координата y параметра position класса Figure
     * */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }


}
