package ru.chedmitriy.chess.algorithm;


import ru.chedmitriy.chess.context.Cell;
import ru.chedmitriy.chess.logicexceptions.MovementException;
import ru.chedmitriy.chess.logicexceptions.OccupiedWayExceptions;

/**.
 * @author Dmitry Cherutsa on 10.12.2016.
 * @version $Id$
 * @project junior
 * @since 0.1
 * Главный класс - родитель всех
 * фигур
 */
public abstract class Figure  {


    public int cellIndex = 0;

    /**.
     *x - координата фигуры по горизонтали
     *y - координаты фигуры по вертикали;
     *  */
    public int x;
    /**.
     *y - координаты фигуры по вертикали;
     * */
    public int y;

    /**
     *position - параметр,содержащий
     * информацию о расположении фигур
     * .*/
   public final Cell position =  new Cell(x, y);

   public Cell[]cells = new Cell[16];


/**
 * .
 * Главный конструктор для всех фигур
 * @param x - координаты фигуры по горизонтали
 * @param y - координаты фигур по вертикали
 * */
    public Figure(int x, int y) {
        this.x = x;
        this.y = y;


    }


    /**
     * .
     * Метод описывает логику перемещений
     * фигуры и возвращает
     * значение true,при ее
     * соответствии
     *
     * @param dist   - **новые
     *               координаты
     *               фигуры**
     *
     * @return movementAllowed -
     *                         ** параметр,
     *                          характеризующий
     *                          возможность
     *                          движения фигуры
     *                          по заданной
     *                          траектории**
     */

    abstract public boolean way(Cell dist) throws MovementException, OccupiedWayExceptions;

}
