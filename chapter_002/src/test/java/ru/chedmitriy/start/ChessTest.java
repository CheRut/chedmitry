package ru.chedmitriy.start;

import org.junit.After;
import org.junit.Before;

import org.junit.Test;

import ru.chedmitriy.chess.context.Board;
import ru.chedmitriy.chess.context.Cell;
import ru.chedmitriy.chess.logicExceptions.FigureNotFoundException;
import ru.chedmitriy.chess.logicExceptions.MovementException;
import ru.chedmitriy.chess.logicExceptions.OccupiedWayExceptions;
import ru.chedmitriy.chess.models.Pawn;


import static org.junit.Assert.assertNull;
/**.
 * @author Dmitry Cherutsa on 10.12.2016.
 * @version $Id$
 * @project junior
 * @since 0.1
 * Класс тестер.
 */
public class ChessTest {
    Board board;
    Pawn p1;
    Pawn p2;
    Pawn p3;

/**.
 * То,что будет выполняться
 * до запуска теста
 * Создаем объекты:
 *
 * */
    @Before
    public void addingItemTester() throws MovementException, OccupiedWayExceptions, FigureNotFoundException {
        /**.
         * объект класса Board для доступа
         * ко всем ключевым методам*/
         board  = new Board();
        /**.
         * Основная тестируемая
         * фигура
         * */
         p1 = new Pawn(1, 1);
        /**.
         * вспомагательная
         * фигура - препятствие
         * */
        p2 = new Pawn(1, 2);
        /**.
         * вспомагательная
         * фигура - Null фигура
         * */
         p3 = new Pawn(4, 4);
        /**.
        * Заполняем массив координат
        * */
        board.fillCellDefaultValues();
        /**.
         * Добавляем координаты и фигуры
         * */
        board.addPosition(p1,p1.position);

        board.addPosition(p2,p2.position);


    }
    /**.
     * То,что будет выполняться
     * после отработки теста
     * */
    @After
    public void itemListCleared(){
        for (int index = 0; index < board.figures.length; index++) {
            board.figures[index]=null;
            assertNull(board.figures[index]);
        }

    }
    /**.
     * тестируем некорректность
     * движения
     * */
    @Test(expected = MovementException.class)
    public void movingLogicTest() throws MovementException, OccupiedWayExceptions, FigureNotFoundException {
        board.move(p1.position, new Cell(3, 5));

    }/**.
     * тестируем наличие препятствия
     *
     * */
    @Test(expected = OccupiedWayExceptions.class)
    public void movingThrowObstaclesTest() throws MovementException, OccupiedWayExceptions, FigureNotFoundException {
        board.move(p1.position, new Cell(1, 3));
    }
    /**.
     * тестируем Null
     * объект
     *
     * */
    @Test(expected = FigureNotFoundException.class)
    public void movingThrowNullTest() throws MovementException, OccupiedWayExceptions, FigureNotFoundException {
        board.move(p3.position, new Cell(4, 5));
    }
}
