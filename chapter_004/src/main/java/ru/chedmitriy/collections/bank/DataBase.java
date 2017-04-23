package ru.chedmitriy.collections.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Данный класс отображает взаимодействие
 * клиентов с их номерами счетов
 **/
public class DataBase {
    /**
     * .
     * база данных,содержащая
     * всю информацию о клиентах
     * */
    private final Map<User, List<Account>> client = new HashMap<>();

    /**
     * .
     * Метод добавляет нового клиента,
     * с пустым списком счетов
     * @param user - добавляемый клиент
     *
     * */
    public void addUser(User user) {
        this.getClient().put(user, new ArrayList<>());
    }
    /**
     * .
     * Метод удаляет клиента из базы данных
     * @param user - удаляемый клиент
     * */
    public void deleteUser(User user) {
        getClient().remove(user);

    }
    /**
     * .
     * Метод добавляет счета для клиента
     * @param user - клиент,которому добавляется     *
     * @param account - реквизиты и остаток средств
     * */
    public void addAccountToUser(User user, Account account) {
        getClient().get(getUserAccounts(user).add(account));

    }
    /**
     *.
     * Удаление некоторого счтета клиента
     * @param user - клиент,чей счет удаляется
     * @param account - удаляемый счет
     * */
    public void deleteAccountFromUser(User user, Account account) {
        getClient().get(getUserAccounts(user).remove(account));
    }
    /**
     *.
     * Получаем информацию об аккаунте
     * клиента
     * @param user - клиент,чей счет интересует
     * */
    public List<Account> getUserAccounts (User user) {
        return getClient().get(user);
    }
    /**
     * .
     * передача средств между
     * счетами разных клиентов или
     * счетами одного клиента
     * @param srcUser - клиент,с счета которого производится
     *                списание средств
     * @param srcAccount - счет,
     *                   с которогосписываются средства
     * @param dstUser - клиент,
     *                которому начисляются средства
     * @param dstAccount - счет,
     *                   на  который начисляются средства
     * @return false если на первом счету недостаточно средств,
     * не найден клиент или счет клиента
     *
     **/
    public boolean transferMoney (User srcUser, Account srcAccount,
                                  User dstUser, Account dstAccount, double amount) {
        boolean operationSuccess = true;
        if(srcAccount.getValue() < amount) {
            operationSuccess = false;
        }
        try {
            for (Account account : getUserAccounts(srcUser)) {
                if (account.equals(srcAccount)) {
                    account.setValue(account.getValue() - amount);
                }
            }
            for (Account account : getUserAccounts(dstUser)) {
                if (account.equals(dstAccount)) {
                    account.setValue(account.getValue() + amount);
                }
            }
        } catch (NullPointerException npe) {
            operationSuccess = false;
        }
        return operationSuccess;
    }
    public Map<User, List<Account>> getClient() {
        return client;
    }
}
