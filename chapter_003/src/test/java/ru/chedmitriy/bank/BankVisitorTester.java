package ru.chedmitriy.bank;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

/**
 * @author Dmitry Cherutsa
 * @project junior
 * @date 3/24/17.
 * @sinse
 * @description:
 */
public class BankVisitorTester {
    BankService bs = new BankService();
    private final LocalTime openTime = LocalTime.of(8,0);
    /**
     * Имитируем обслуживания клиентов банком
     * Клиентов добавляю таким образом,чтобы получилось два интервала нагрузки
     * с разницой в количечтве обслуживаемых клиентов
     * */
    @Before
public void initData() {
        bs.fillDataBase(new Client("client1","","08:15",
                "08:36",0,
                0));
        bs.fillDataBase(new Client("client2","","08:25",
                "09:00",0,
                0));
        bs.fillDataBase(new Client("client3","","08:35",
                "10:30",0,
                0));
        bs.fillDataBase(new Client("client4","","12:00",
                "15:30",0,
                0));
        bs.fillDataBase(new Client("client5","","13:25",
                "15:00",0,
                0));
        bs.fillDataBase(new Client("client6","","13:35",
                "15:46",0,
                0));
        bs.fillDataBase(new Client("client7","","14:35",
                "14:46",0,
                0));
    }
    /**
     * Заполняем баз
     * уданных
     * */
    @Test
    public void whenFillingDataBase () {
        String value ="client1";
        String exp = bs.getClientsForAllDay().get(0).getName();
        assertThat(value,is(exp));
    }
    /**
     * Переводим время в минуты
     * */
    @Test
    public void whenTimeConversionToMinutes() {
        bs.clientVisitTime(bs.getClientsForAllDay().get(1));
        long value  = 120;
        long exp = bs.getClientsForAllDay().get(0).getTimeDuringTheClientHasVisitingBank();
        assertThat(value,is(exp));
    }
    /**
     * Проверяем максимально нагруженный промежуток времени
     * */
    @Test
    public void whenOverTimeIntervalFinding(){
        bs.theMostOverloadTimeInterval(bs.getClientsForAllDay());
        //Время начала максимальной нагрузки равно 14:35
        String value = "14:35";
        String exp = bs.from;
        assertThat(value,is(exp));
        //Время окончания максимальной нагрузки соответствует 14:46
        String valueEnd = "14:46";
        String expEnd = bs.to;
        assertThat(valueEnd,is(expEnd));
    }
}
