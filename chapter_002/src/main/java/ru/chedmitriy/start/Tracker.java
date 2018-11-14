package  ru.chedmitriy.start;

import ru.chedmitriy.models.*;
/**
 * Created by dimsan on 18.09.2016.
 */
public class Tracker {
    /**
     * All values are stored in this array
     * */
    private Item[] items = new Item[10];
    private ConsoleInput cInput = new ConsoleInput();
    private int position = 0;


    public Tracker() {
        this(10);
    }

    /**
     * Constructor for trackerduplicate.
     * @param size of items list.
     */
    public Tracker(int size) {
        items = new Item[size];
        position = 0;
    }
    /**
     * This method adds new items in
     * items array.
     * @param: item - each new element of the list,
     * has been assigned a serial number
     * @param: items - list of items
     * @return: adding item
     *
     * */

    public Item add(Item item) {
        this.items[position++] = item;
        item.setId(String.valueOf(position));
        return item;
    }
    /**
     * This method find an item,which serial number was entered
     * @param: item - element of the list
     * @param: items - list of items
     * @return: finding item
     *
     * */

    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    public Item[] getAll() {
        Item[] result = new Item[position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }
    /**
     * This method edits the selected item
     * @param: item - element of the list
     * @param: items - list of items
     * */

    public void editById(Item item, String name, String description) {
       if (item != null) {
           for (Item item1 : this.items) {
               if (item.equals(item1)) {
                   item1.setName(name);
                   item1.setDescription(description);
               }
           }
       }

    }

    /**
     * This method deletes the selected item
     * @param: item - element of the list
     * @param: items - list of items
     * */

    public void deleteById(Item item) {
            for (Item item1 : this.items) {
                if (item.equals(item1)) {
                    item1.setName(null);
                    item1.setDescription(null);
                }
            }

    }

    /**
     * This method adds comments item
     * @param: items - list of items
     * */

    public void addComments(Item item) {

        for (int i = 0; i < this.items.length; i++) {

            if (items[i].equals(item) && items[i] instanceof Comments) {
              Comments  comments = (Comments) items[i];
                comments.setComments(cInput.ask("please "
                        + "add the comments: "));
            }

        }

    }
    /**
     * This method filters array ,
     * leaving only the elements with even serial numbers
     * @param: items -  list of items
     * @param: result -  new list of items
     * */

    public Item[] findBy() {
        Item[] result = new Item[10];
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items.length; j++) {
                if (i % 2 != 0) {
                    result[i] = items[i];
                }
            }

        }

        return result;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;


    }
}



