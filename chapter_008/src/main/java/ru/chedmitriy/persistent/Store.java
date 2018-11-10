package ru.chedmitriy.persistent;

import ru.chedmitriy.models.User;

import java.util.Collection;
/**
 * Интерфейс хранилища пользователей
 * Здесь собраны все опреции
 * для работы с хранилищем
 * пользователей: добавление,
 * удаление, редактирование,
 * поиск.
 *
 */
public interface Store {

    /** Поиск по id
     * Также используется при удалении и
     * редактированиии
     * @param id -искомый пользователь
     * пользователь с таким ключом-id
     */
    User getById(int id);

    /**
     * Добавляем пользователя
     * @param User новый пользователь

     */
    void add(final User User);

    /**
     * пользователь ищется в
     * хранилище по id.
     * Удаляем пользователь
     * по его id
     * @param id - id удаляемого
     *          пользователя

     */
    void delete(final int id);

    /** Get the store's values
     *  without a keys
     * @return - values
     */
    Collection<User> values();

    /**
     * Пользователь ищется в
     * хранилище по id,
     * затем редактируется
     * @param User - id редактируемого
     *           пользователя

     */
    void edit (final User User);


    /**
     * Получаем значения
     * хранилища
     * @return - значения из хранилища
     */
    Collection<User> viewAll();


}
