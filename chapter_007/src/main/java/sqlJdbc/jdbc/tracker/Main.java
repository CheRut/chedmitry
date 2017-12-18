package sqlJdbc.jdbc.tracker;

import java.sql.Timestamp;

/**
 * chedmitry
 *
 * @author CheDmitry
 * @version 1.0
 * @since 17.12.17
 */
public class Main {
    public static void main(String[] args) {
        TrackerJDBC itemWorker = new TrackerJDBC();
        itemWorker.itemStore();

        itemWorker.add(new Item(null, "заявка_2", new Timestamp(System.currentTimeMillis())));
        itemWorker.add(new Item(null, "заявка_2", new Timestamp(System.currentTimeMillis())));
        itemWorker.add(new Item(null, "заявка_3", new Timestamp(System.currentTimeMillis())));
        itemWorker.add(new Item(null, "заявка_4", new Timestamp(System.currentTimeMillis())));
        itemWorker.add(new Item(null, "заявка_5", new Timestamp(System.currentTimeMillis())));
        itemWorker.add(new Item(null, "заявка_5", new Timestamp(System.currentTimeMillis())));
        itemWorker.add(new Item(null, "заявка_5", new Timestamp(System.currentTimeMillis())));
        itemWorker.add(new Item(null, "заявка_5", new Timestamp(System.currentTimeMillis())));
        itemWorker.add(new Item(null, "заявка_6", new Timestamp(System.currentTimeMillis())));



        itemWorker.deleteById("1");

        System.out.println(itemWorker.replace("3", new Item(null, "name", new Timestamp(System.currentTimeMillis()))));

        System.out.println(itemWorker.findByName("заявка_5"));

        System.out.println( itemWorker.getElementById("2"));

        itemWorker.findAll();


    }
}
