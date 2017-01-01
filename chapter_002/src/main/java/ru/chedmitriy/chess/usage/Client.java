package ru.chedmitriy.chess.usage;

import ru.chedmitriy.chess.context.Board;
import ru.chedmitriy.chess.context.Cell;
import ru.chedmitriy.chess.logicExceptions.FigureNotFoundException;
import ru.chedmitriy.chess.logicExceptions.MovementException;
import ru.chedmitriy.chess.logicExceptions.OccupiedWayExceptions;
import ru.chedmitriy.chess.models.Pawn;

/**
 * @author Dmitry Cherutsa on 10.12.2016.
 * @version $Id$
 * @project junior
 * @since 0.1
 */
public class Client {




    void init() throws MovementException,OccupiedWayExceptions,FigureNotFoundException {





    }
    public static void main(String... args) throws MovementException, OccupiedWayExceptions, FigureNotFoundException {
new Client().init();
    }
}
