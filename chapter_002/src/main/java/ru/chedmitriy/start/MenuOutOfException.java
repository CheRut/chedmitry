package  ru.chedmitriy.start;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by dimsan on 28.09.2016.
 */
public class MenuOutOfException  {

    Logger lg = Logger.getLogger(MenuOutOfException.class.getName());

    public MenuOutOfException(String loggerMessage) {
        lg.log(Level.WARNING, loggerMessage);
    }


}
