package  ru.chedmitriy.start;

import ru.chedmitriy.models.Item;

import java.util.logging.Logger;
/**
 * This class shows the menu structure, built on the inner classes
 */
public class MenuTracker {

    private Logger lg = Logger.getLogger(getClass().getName());

    /*
     * An instance of  ConsoleInput to do some input output operations
     **/

    private ConsoleInput cIn;

    /*
     * An instance of Tracker containing the program logic.
     **/
    private Tracker tracker;



    public int position = 0;

    /*
     * Constructor that takes an instance of
     * input - output object,and Tracker instance,
     * to activate needed operations
     **/

    public MenuTracker(ConsoleInput cIn, Tracker tracker) {
        this.cIn = cIn;
        this.tracker = tracker;
    }

    /*
     *	Simple array of the menu items names;
     *	@return: array menuItems
     **/


    /*
     * An inner class that inherits from the abstract class,and
     * overriding super class method  to add all items by Tracker instance using
     * @param: menuItemId() method to get the call position
     **/
    class MenuAddItem extends MenuItem {
        public MenuAddItem(String name) {
            super(name);
        }

        public int menuItemId() {
            return 0;
        }
        @Override
        public void menuItemInfo(ConsoleInput cIn, Tracker tracker) {
            String name = cIn.ask("Please enter the  name of the new Item");
            String description = cIn.ask("Please enter the description of the new Item ");
            tracker.add(new Item(name, description));
        }
    }

    /*
     * An inner class that inherits from the abstract class,and
     * overriding super class method  to edit needed items by Tracker instance using
     * @param: menuItemId() method to get the call position
     **/
    class MenuEditItem extends MenuItem {

        public MenuEditItem(String name) {
            super(name);
        }

        public int menuItemId() {
            return 1;
        }

        @Override
        public void menuItemInfo(ConsoleInput cIn, Tracker tracker) {
            String id = cIn.ask("Please,enter the needed id");
            if (tracker.findById(id) != null) {
                String name = cIn.ask("Please enter a new "
                        + "name for a given item");
                String description = cIn.ask("Please enter a new"
                        + " description for a given item");
                tracker.editById(tracker.findById(id), name, description);
            } else {
                lg.info("item with id " + id + " is not found!"
                        + "\nCheck the correctness of the input data");
            }
        }
    }
    /*
     * An inner class that inherits from the abstract class,and
     * overriding super class method to delete needed items by Tracker instance using
     * @param: menuItemId() method to get the call position
     **/
    class MenuDeleteItem extends MenuItem {
        public MenuDeleteItem(String name) {
            super(name);
        }

        public int menuItemId() {
            return 2;
        }
        @Override
        public void menuItemInfo(ConsoleInput cIn, Tracker tracker) {
            String id = cIn.ask("Please,enter the id you want to delete");
            if (tracker.findById(id) != null) {
                tracker.deleteById(tracker.findById(id));
            } else {
                lg.info("item with id " + id + " is not found!"
                        + "\nCheck the correctness of the input data");
            }
        }
    }
    /*
     * An inner class that inherits from the abstract class,and
     * overriding super class method  to shows items list by Tracker instance using
     * @param: menuItemId() method to get the call position
     **/
    class MenuShowAllItem extends MenuItem {
        public MenuShowAllItem(String name) {
            super(name);
        }

        public int menuItemId() {
            return 3;
        }

        @Override
        public void menuItemInfo(ConsoleInput cIn, Tracker tracker) {
            for (int i = 0; i < tracker.getAll().length; i++) {
                cIn.outPrintln(i + "." + tracker.getAll()[i].getName()
                        + " " + tracker.getAll()[i].getDescription());
            }
        }
    }
    /*
     * An inner class that inherits from the abstract class,and
     * overriding super class method  to shows the items by specific filter,for example by id with even values
     * @param: menuItemId() method to get the call position
     **/
    class MenuShowByFilterItem extends MenuItem {
        public MenuShowByFilterItem(String name) {
            super(name);
        }

        public int menuItemId() {
            return 4;
        }
        @Override
        public void menuItemInfo(ConsoleInput cIn, Tracker tracker) {
            tracker.findBy();
        }
    }
    /*
     * An inner class that inherits from the abstract class,and
     * overriding super class method  to add a comments to needed item
     * @param: menuItemId() method to get the call position
     **/
    class MenuCommentItem extends MenuItem {

        public MenuCommentItem(String name) {
            super(name);
        }

        public int menuItemId() {
            return 5;
        }

        @Override
        public void menuItemInfo(ConsoleInput cIn, Tracker tracker) {
            String id = cIn.ask("Please,"
                    + "enter the id of item which you want to add a comments");
            if (tracker.findById(id) != null) {
                tracker.addComments(tracker.findById(id));
            } else {
                lg.info("item with id " + id
                        + " is not found!\nCheck the correctness of the input data");
            }
        }
    }
    /**
     *	Method, which takes the value of the selected menu item
     */

    public void optionSelect(int key) {
        if (key >= 0 || key <= 5) {
            this.menuAction[key].menuItemInfo(this.cIn, this.tracker);
        } else {
            lg.info("Check the "
                + "correctness of the input data");
        }
    }

    private MenuItem[] menuAction = new MenuItem[6];
    /*
     *	Array of the MenuOption object instances for implementation all inners classes
     *	By using key value,we can choose the needed option
     **/
    public void menuActionFilling() {

        menuAction[position++] = new MenuAddItem("Add item");
        menuAction[position++] = new MenuEditItem("Edit item");
        menuAction[position++] = new MenuDeleteItem("Delete item");
        menuAction[position++] = new MenuShowAllItem("Show all items");
        menuAction[position++] = new MenuShowByFilterItem("Show "
                + "items by using filter");
        menuAction[position++] = new MenuCommentItem("Add comments to item");
    }

    public void showMenu() {

        for (int i = 0; i < menuAction.length; i++) {

            System.out.println(i + "." + menuAction[i].name);
        }

    }

}




