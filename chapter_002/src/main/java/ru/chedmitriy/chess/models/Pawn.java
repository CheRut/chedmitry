package ru.chedmitriy.chess.models;

import ru.chedmitriy.chess.algorithm.Figure;
import ru.chedmitriy.chess.context.Cell;
import ru.chedmitriy.chess.logicexceptions.MovementException;



/**
 * @author Dmitry Cherutsa on 10.12.2016.
 * @version $Id$
 * @project junior
 * @since 0.1
 * Класс описывает фигуру 'Пешка'
 */
public class Pawn extends Figure {
    /**.
     * параметр position - координаты фигуры
     * */
        public Cell position = new Cell();

    /**.
     * Переменная movementCounter
     * -счетчик ходов
     * пешки
     * */
    private  int movementsCounter = 0;


    /**
     * .
     * Главный конструктор для всех фигур
     * @param x - координаты фигуры по горизонтали
     * @param y - координаты фигур по вертикали
     *
     * внутри конструктора - переопределение
     *          параметра position.
     * */
    public Pawn(int x, int y) {
        super(x, y);
        this.position = new Cell(x, y);

    }

    /**
     * .
     * Метод описывает логику перемещений
     * фигуры и возвращает
     * значение true,при ее
     * соответствии
     *
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
    @Override
    public boolean way(Cell dist) throws MovementException {
    boolean canMove = false;
        int xDestination = dist.x - this.position.x;
        int yDestination = dist.y - this.position.y;
            if (yDestination == 1 && (xDestination == 0) && movementsCounter > 0) {
                this.position = dist;
                movementsCounter++;
                canMove = true;
            }
            if (((yDestination <= 2)
                    && xDestination == 0) && movementsCounter == 0) {

                this.position = dist;
                movementsCounter++;
                canMove = true;

            } else {
            throw new MovementException("Ошибка логики перемещения фигуры");
        }
        return canMove;
    }

}
