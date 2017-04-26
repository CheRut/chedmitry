package ru.chedmitry.bank;

import org.junit.Before;
import org.junit.Test;
import ru.chedmitriy.collections.bank.Account;
import ru.chedmitriy.collections.bank.DataBase;
import ru.chedmitriy.collections.bank.User;
import ru.chedmitriy.collections.bank.exceptions.AccountNotFoundException;
import ru.chedmitriy.collections.bank.exceptions.UserNotFoundException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class BankOperationsTesting {
    private DataBase dataBase;

    private final User user1 = new User("Dmitry","221133");
    private final User user2 = new User("Viktor","003333");
    private final User user3 = new User("Alex","225144");


    @Before
    public void init() {
        dataBase = new DataBase();
        dataBase.client.put(user1,new ArrayList<Account>());
        dataBase.client.put(user2,new ArrayList<Account>());
        dataBase.client.put(user3,new ArrayList<Account>());





    }
    /**.
     * Тестирование метода add:
     * сравниваю размер Map client до
     * добавления и после
     */
    @Test
    public void whenNewUserAdding() {
        int exp = 3;
        assertThat(dataBase.client.size(),is(exp));
        dataBase.addUser(new User("Evgeniy","123456"));
        dataBase.addUser(new User("Aleksey","000223"));
        dataBase.addUser(new User("Oleg","111234"));
        exp = 6;
        assertThat(dataBase.client.size(),is(exp));
    }
    /**
     * Тестирование метода
     * addAccountToUser
     * добавляем Account клиенту проверяем
     * значение getRequisites
     * */
    @Test
    public void whenAccountAddingToUser() throws UserNotFoundException {
        dataBase.addAccountToUser(user1,new Account(3000,"1234 5678 9123 4560"));
        String exp = "1234 5678 9123 4560";
        assertThat(dataBase.client.get(user1).get(0).getRequisites(),is(exp));
    }
    /**
     * Получаем информацию об аккаунте
     * тестируем метод getUserAccounts(user1)
     * Сначала добавляем клиента user1 с
     * с параметрами.Затем получаем информацию о значении
     * */
    @Test
    public void whenTryingToGetAccount() throws UserNotFoundException {
        dataBase.addAccountToUser(user1,new Account(3000,"1234 5678 9123 4560"));
        assertThat(dataBase.getUserAccounts(user1).get(0).getValue(),is(3000.0));

    }
    /**
     * Тестирование метода deleteUser
     * было 3 клиента
     * одного клиента удалили,
     * размер map уменьшился на 1
     * */
    @Test
    public void whenUserDelete() throws UserNotFoundException {
        dataBase.deleteUser(user1);
        int newSizeOfDb = 2;
        assertThat(dataBase.client.size(),is(newSizeOfDb));

    }
    /**
     * Тестируем метод addAccountToUser
     * добавляем два объекта Account
     * проверяем изменение размера списка List<Account>
     * затем удаляем один объект
     * */
    @Test
    public void whenUserAccountWasDeleted() throws UserNotFoundException, AccountNotFoundException {
        Account firstUserAccount = new Account(1000,"some requisites");
        Account secondUserAccount = new Account(2000,"new some requisites");
        dataBase.addAccountToUser(user1,firstUserAccount);
        dataBase.addAccountToUser(user1,secondUserAccount);
        assertTrue(dataBase.getUserAccounts(user1).size()==2);
        dataBase.deleteAccountFromUser(user1,secondUserAccount);
        assertFalse(dataBase.getUserAccounts(user1).size()==2);

    }
    /**
     * Проверяем метод
     * transferMoney
     * Передаем 100 условных единиц с одного счета
     * клиента user1 на другой.
     * Проверяем полученные результаты
     * */
    @Test
    public void whenTransferTrying() throws UserNotFoundException, AccountNotFoundException {
        Account firstUserAccount = new Account(1000,"some requisites");
        Account secondUserAccount = new Account(2000,"new some requisites");
        dataBase.addAccountToUser(user1,firstUserAccount);
        dataBase.addAccountToUser(user1,secondUserAccount);
        dataBase.transferMoney(user1,firstUserAccount,user1,secondUserAccount,100);
        assertTrue(dataBase.getUserAccounts(user1).get(0).getValue() == 900);
        assertTrue(dataBase.getUserAccounts(user1).get(1).getValue() == 2100);
    }

}
