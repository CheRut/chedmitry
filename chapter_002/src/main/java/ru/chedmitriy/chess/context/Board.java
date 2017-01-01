package ru.chedmitriy.chess.context;

import ru.chedmitriy.chess.algorithm.Figure;
import ru.chedmitriy.chess.logicExceptions.FigureNotFoundException;
import ru.chedmitriy.chess.logicExceptions.MovementException;
import ru.chedmitriy.chess.logicExceptions.OccupiedWayExceptions;
import ru.chedmitriy.chess.usage.ConsoleIO;

import static java.lang.Math.abs;

/**.
 * @author Dmitry Cherutsa on 10.12.2016.
 * @version $Id$
 * @project junior
 * @since 0.1
 * Класс 'Board'- несет в себе информацию о "шахматной доске": собирает все имеющиеся фигуры и добавляет/удаляет их
 * на "шахматную доску" а также "отслеживает" наличие препятствий
 * */
public class Board extends Cell {


    /**
     * .
     * cIO - экземпляр класса ввода/вывода
     */
    public   ConsoleIO cIO = new ConsoleIO();
    /**
     * .
     * figures - массив на 16 элементов типа Figure
     */
   public Figure[] figures = new Figure[16];

    /**
     * .
     * chessBoard - "шахматная доска" -
     * двумерный массив размером 9х9
     */
    Figure[][] chessBoard = new Figure[9][9];

    /**
     * .
     * Метод 'addFigures' - добавляет Элементы
     * в массив figures
     *
     * @param figure
     */
    public Figure[] addFigure(Figure figure,int index) throws FigureNotFoundException {
        figures[index] = figure;
        fillBoard();
        return figures;
    }
/**.
 * Метод заполняет
 * поле фигурами,расставляя
 * их в соответствии с их координатами
 * дефолтными значениями
 * @return поле - массив фигур
 * */
    public Figure[][] fillBoard() {
        for (int k = 0; k < figures.length; k++) {
            if (figures[k] != null)
                chessBoard[figures[k].y][figures[k].x] = figures[k];
        }

        return chessBoard;
    }
    /**.
     * Метод определяет
     * наличие занятой координаты x
     * на пути следования фигуры
     *
     * @param a -начальная точка
     *
     * @param c -конечная точка
     *
     * @return - число-результат сравнения
     *
     * */
    public int obstacleX(int a,int c){
        int xPos=0;
        if(a!=0||c!=0) {
            for (int i = 0; i < cells.length; i++) {
                if (a == c && a == cells[i].x) {
                    xPos = a;
                } else {
                    if (cells[i].x != 0 && cells[i].x != a && (a + cells[i].x + c) / 3 == cells[i].x) {
                        xPos = cells[i].x;
                    }

                }
            }
        }
        return xPos;
    } /**.
     * Метод определяет
     * наличие занятой координаты y
     * на пути следования фигуры
     *
     * @param a -начальная точка
     *
     * @param c -конечная точка
     *
     * @return - число-результат сравнения
     *
     * */
    public int obstacleY(int a,int c){

        int yPos = 0;
        if(a!=0||c!=0) {
            for (int i = 0; i < cells.length; i++) {
                if (a == c && a == cells[i].y) {
                    yPos = a;
                } else {
                    if (cells[i].y != 0 && cells[i].y != a && (a + cells[i].y + c) / 3 == cells[i].y) {
                        yPos = cells[i].y;

                    }
                }
            }
        }
        return yPos;
    }
    /**.
     * Метод находит занятые 'x'
     * и 'y'
     * в массиве координат.
     * @param pos - координаты фигуры
     * @param dis - координаты,в которые
     *            фигура перемещается
     *
     */
    public void checkObstacles(Cell pos,Cell dis) throws OccupiedWayExceptions {

        for (int i = 0; i <cells.length ; i++) {
            if(cells[i].x == obstacleX(pos.x,dis.x)&&cells[i].y==obstacleY(pos.y,dis.y)&&
                    cells[i].x !=0 &&cells[i].y!=0  ){
                throw new OccupiedWayExceptions();
            }
        }
    }
    /**.
     * Метод заполняет массив
     * координат дефолтными
     * значениями с 'x'= 0
     * и 'y'=0
     * @return -полученный массив координат
     * */
    public Cell[] fillCellDefaultValues(){
        for (int i = 0; i < cells.length; i++) {
            if (cells[i] == null)
                cells[i]= new Cell();
        }
        return cells;
    }
    /**.
     * Метод добавляет
     * координаты новой фигуры
     * в массив координат
     * @param position
     *
     *@return -полученный массив координат
     * */
    public Cell[]addPosition(Figure figure,Cell position) throws FigureNotFoundException {
        for (int i = 0; i < cells.length; i++) {
            if (cells[i].x == 0 && cells[i].y == 0) {
                cells[i] = position;
                addFigure(figure,i);
                break;
            }
        }
        return cells;
    }
    /**.
     * Метод отображает
     * содержимое массива координат,
     * если их значения отличны от 0
     *
     * */
    public void showCells() {
        for (int i = 0; i < cells.length; i++) {
            if (cells[i].x!=0&&cells[i].y!=0) {
                System.out.println(i + ". " + "x = " + cells[i].x + " " + "y = " +
                        cells[i].y + " " + cells[i].getClass().getCanonicalName());
            }
        }
        System.out.println();

    }
    /**.
     *
     * Метод-перемещение фигур
     * при выполнении условий:
     * соответствия логики движения фигуры,
     * отсутствия препятствий на пути движения
     * фигуры,
     * существует ли фигура с такими
     * координатами
     *
     * @param source - координаты,
     *               перемещаемой фигуры
     *
     * @param dist - координаты, в которые
     *             перемещается фигура.
     * @return - Истина или ложь
     * */
    public boolean move(Cell source, Cell dist) throws MovementException, OccupiedWayExceptions, FigureNotFoundException {
      if(chessBoard[source.y][source.x]!=null){
          chessBoard[source.y][source.x].way(dist);
          checkObstacles(source,dist);
          for (int i = 0; i <figures.length ; i++) {
              if(figures[i]!=null && figures[i].x == source.x && figures[i].y==source.y) {
                  remFromBoard(figures[i]);
                  cells[i].x = dist.x;
                  cells[i].y = dist.y;
                  figures[i].x = dist.x;
                  figures[i].y = dist.y;
                  fillBoard();

              }
          }
          } else {throw new FigureNotFoundException();}

         showBoard();
        return true;
    }

    /**
     * .
     * Метод 'remFromBoard' - удаляет Элементы
     * из массива figures
     *
     * @param figure
     */
    public void remFromBoard(Figure figure) throws FigureNotFoundException {
        int xCell = figure.x;
        int yCell = figure.y;
        chessBoard[yCell][xCell] = null;
    }

    /**
     * .
     * Метод 'showBoard()' -
     * при необходимости отображает в консоли массив элементов
     */
    public void showBoard() throws FigureNotFoundException {

        for (int i = 1; i < chessBoard.length; i++) {
            for (int j = 1; j < chessBoard.length; j++) {
                cIO.print(chessBoard[i][j] + "\t");
            }
            cIO.println("");
        }
        System.out.println();

    }


}



