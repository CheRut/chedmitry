package  ru.chedmitriy.start;

/**
 * Created by dimsan on 18.09.2016.
 */
public abstract class  MenuItem implements MenuOption {
    public String name;

   public MenuItem(String name) {
       this.name = name;
   }
    abstract public void menuItemInfo(ConsoleInput cIn, Tracker tracker);




}
