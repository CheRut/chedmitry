package ru.chedmitriy.collections.modifiingTracker.objects;

import ru.chedmitriy.collections.modifiingTracker.models.MenuItem;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Отображение структуры меню
 * */
public class MenuTracker {
    /**
     * объект класса Logger -
     * выводит информацию о проблеме
     * */
    private final Logger lg = Logger.getLogger(getClass().getName());
    /**
     * получаем возможность ввода/вывода
     * */
    private final ConsoleInput cIn;
    /**
     * Объект класса
     * Tracker с которым
     * работает программа
     * */
    private final Tracker tracker;
    /**
     * Конструктор,
     * позволяющий оперировать
     * действиями над объектами
     * коллекции из меню.
     * **/
    public MenuTracker(ConsoleInput cIn,Tracker tracker) {
        this.cIn = cIn; this.tracker = tracker;
    }
    /** Класс,
     * который дает возможность
     * добавлять новые объекты в
     * коллекцию
     * */
    class MenuAddItem extends MenuItem {
        /**
         * Конструктор,наследованный
         * от класса родителя MenItem  */
        public MenuAddItem() {
            super("Add item");
        }
        /**
         * Переопределенный метод,
         * реализующий добавление
         * нового объекта в коллекцию
         * @param cIn - запрос к пользователю
         * @param tracker - обект,дающий возможность
         *                выполнять заданные действия.
         *                */
        @Override public void menuItemInfo(final ConsoleInput cIn, final Tracker tracker) {
            String name = cIn.ask("Please enter the  name of the new Item");
            String description = cIn.ask("Please enter the description of the new Item ");
            tracker.add(new Item(name,description)); } }
    /**
     * Класс,
     * который дает
     * возможность
     * редактировать объекты коллекции
     * */
    class MenuEditItem extends MenuItem {
        public MenuEditItem() {
            super("Edit item");
        }
        /**
         *  Переопределенный метод,
         *  реализующий редактирование
         *  элементов в коллекции
         *  @param cIn - запрос к пользователю
         *  @param tracker - обект,дающий возможность
         *                 выполнять заданные действия.
         *                 При отсутствии элемента в коллекции
         *                 или некорректности ввода
         *                 выпадает Logger.info()
         *                 */
        @Override public void menuItemInfo(final ConsoleInput cIn, final Tracker tracker) {
            String id = cIn.ask("Please,enter the needed id");
            if (tracker.findById(id) != null) {
                String name = cIn.ask("Please enter a new name for a given item");
                String description = cIn.ask("Please enter a new description for a given item");
                tracker.editById(tracker.findById(id), name, description);
            } else lg.info("item with id "+id+" is" +
                    " not found!\nCheck the correctness of the input data");
        }
    }
    /**
     * Класс,который дает
     * возможность удалять
     * объекты коллекции */
    class MenuDeleteItem extends MenuItem {
        public MenuDeleteItem() {
            super("Delete item"); }

        /**
         * Переопределенный метод,
         * реализующий удаление
         * элементов в коллекции
         * @param cIn - запрос к пользователю
         * @param tracker - обект,дающий возможность
         *                выполнять заданные действия.
         *                при отсутствии элемента в
         *                коллекции или некорректности
         *                ввода выпадает Logger.info()
         *                */
        @Override public void menuItemInfo(final ConsoleInput cIn, final Tracker tracker) {
            String id = cIn.ask("Please,enter the id you want to delete");
            if (tracker.findById(id) != null) {
                tracker.deleteById(tracker.findById(id));
            }
            else lg.info("item with id "+id+" is not found!\nCheck the correctness of the input data");
        }
    }
    /**
     * Класс,отображение
     * элементов коллекции
     * */
    class MenuShowAllItem extends MenuItem {
        public MenuShowAllItem() {
            super("Show all items");
        }


        /**
         * Переопределенный метод,реализующий отображение
         * элементов  коллекции
         * @param cIn - запрос к пользователю
         * @param tracker - обект,дающий возможность
         *                           выполнять заданные действия.
         * */
        @Override
        public void menuItemInfo(final ConsoleInput cIn,final Tracker tracker) {
            for (int i = 0; i <tracker.getAll().size() ; i++) {
                cIn.outPrintln(i+"."+tracker.getAll().get(i).getName()+
                        " "+tracker.getAll().get(i).getDescription());
            }
        }
    }
    /**
     * Класс,отображение
     * элементов коллекции с использованием
     * фильтра
     * */
    class MenuShowByFilterItem extends MenuItem {
        public MenuShowByFilterItem() {
            super("Show items by using filter");
        }


        /**
         * Переопределенный метод,реализующий отображение
         * элементов  коллекции с использованием фильтра
         * @param cIn - запрос к пользователю
         * @param tracker - обект,дающий возможность
         *                           выполнять заданные действия.
         * */
        @Override
        public void menuItemInfo(final ConsoleInput cIn,final Tracker tracker) {
            tracker.findByFilter();
        }
    }
    /**
     * Класс,для
     * добавления комментариев к объектам
     * */
    class MenuCommentItem extends MenuItem {

        public MenuCommentItem() {
            super("Add comments to item");
        }


        /**
         * Переопределенный метод,реализующий добавление
         * комментариев к
         * элементам коллекции
         * @param cIn - запрос к пользователю
         * @param tracker - обект,дающий возможность
         *                           выполнять заданные действия.
         *при отсутствии элемента в коллекции или некорректности ввода
         *                выпадает Logger.info()
         * */
        @Override
        public void menuItemInfo(final ConsoleInput cIn, Tracker tracker) {
            String id = cIn.ask("Please,enter the id of item which you want to add a comments");
            if (tracker.findById(id) != null) {
                tracker.addComments(tracker.findById(id));
            } else {
                lg.info("item with id "+id+" is not found!\nCheck the correctness of the input data");
            }
        }
    }
    /**
     *	Метод принимает значение-ключ
     * по которому определяется действие над коллекциией
     * @param key - ключ-значение
     */

    public void optionSelect(int key) {
        if(key >= 0 || key <= 5) {
            this.menuAction.get(key).menuItemInfo(this.cIn, this.tracker);
        } else {
            lg.info("Check the correctness of the input data");}
    }

    private final ArrayList<MenuItem> menuAction = new ArrayList<>();
    /**
     * Метод заполняет список меню
     * */
    public void menuActionFilling() {

        this.menuAction.add(new MenuAddItem());
        this.menuAction.add(new MenuEditItem());
        this.menuAction.add(new MenuDeleteItem());
        this.menuAction.add(new MenuShowAllItem());
        this.menuAction.add(new MenuShowByFilterItem());
        this.menuAction.add(new MenuCommentItem());
    }
    /**
     * Отображение меню
     * */
    public void showMenu() {

        for (int i = 0; i < menuAction.size(); i++) {
            System.out.println(i+"."+menuAction.get(i).getName());
        }

    }

}




