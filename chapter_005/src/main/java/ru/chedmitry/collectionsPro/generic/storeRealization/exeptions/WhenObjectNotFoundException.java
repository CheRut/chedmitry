package ru.chedmitry.collectionsPro.generic.storeRealization.exeptions;
/**
 * Если объекта не существует
 * выпадает исключение описанное
 * в данном классе
 *
 * */
public class WhenObjectNotFoundException extends Exception {
    /**
     * конструктор
     * по умолчанию
     * */
    public WhenObjectNotFoundException() {
    }
    /**
     * если объект
     * не найден,выпадает
     * соответствующее
     * сообщение
     * @return - сообщение при исключении
     * */
    @Override
    public String getMessage() {
        return "Ошибка!Объекта не существует!";
    }
}
