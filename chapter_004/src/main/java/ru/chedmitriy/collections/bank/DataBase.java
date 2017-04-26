package ru.chedmitriy.collections.bank;

import ru.chedmitriy.collections.bank.exceptions.AccountNotFoundException;
import ru.chedmitriy.collections.bank.exceptions.UserNotFoundException;

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
    public final Map<User, List<Account>> client = new HashMap<>();

    /**
     * .
     * Метод добавляет нового клиента,
     * с пустым списком счетов
     * @param user - добавляемый клиент
     *
     * */
    public void addUser(User user) {
        this.client.put(user, new ArrayList<>());
    }
    /**
     * .
     * Метод удаляет клиента из базы данных
     * @param user - удаляемый клиент
     * */
    public void deleteUser(User user) throws UserNotFoundException{
        if(!client.containsKey(user))
            throw new UserNotFoundException(
                    );

        this.client.remove(user);

    }
    /**
     * .
     * Метод добавляет счета для клиента
     * @param user - клиент,которому добавляется     *
     * @param account - реквизиты и остаток средств
     * */
    public void addAccountToUser(User user, Account account) throws UserNotFoundException {
        if(!client.containsKey(user))
            throw new UserNotFoundException(
                    );
        this.client.get(getUserAccounts(user).add(account));

    }
    /**
     *.
     * Удаление некоторого счтета клиента
     * @param user - клиент,чей счет удаляется
     * @param account - удаляемый счет
     * */
    public void deleteAccountFromUser(User user, Account account) throws UserNotFoundException,
            AccountNotFoundException {
        if (!client.containsKey(user))
            throw new UserNotFoundException(
                    );
        if (!getUserAccounts(user).contains(account))
            throw new AccountNotFoundException(
                    );
        this.client.get(getUserAccounts(user).remove(account));
    }
    /**
     *.
     * Получаем информацию об аккаунте
     * клиента
     * @param user - клиент,чей счет интересует
     * */
    public List<Account> getUserAccounts (User user) throws UserNotFoundException {
        if(!client.containsKey(user))
            throw new UserNotFoundException();
        return this.client.get(user);
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
                                  User dstUser, Account dstAccount, double amount)
            throws UserNotFoundException, AccountNotFoundException {
        boolean operationSuccess = true;
        if(!client.containsKey(srcUser) || !client.containsKey(dstUser) )
            throw new UserNotFoundException(
                    );
        if(!getUserAccounts(srcUser).contains(srcAccount) ||
                !getUserAccounts(dstUser).contains(dstAccount) )
            throw new AccountNotFoundException(
                    );
        if(srcAccount.getValue() < amount) {
            operationSuccess = false;
        }
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
        return operationSuccess;
    }


}
