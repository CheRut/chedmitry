package ru.chedmitriy.bank;



import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;


/**
 * Created by root on 3/18/17.
 */
public class BankService {
    /**
     * класс ввода/вывода
     * */
    ConsoleIO cIO = new ConsoleIO();
    /**
     * Счетчик групп с максимальным количеством клиентов
     * */
    private int theBiggestClientsQuantity = 0;
    /**
     *время,которое соответствует окончанию загрузки
     * банка
     * */
    long theLowestDuringTime = 720;
    /**
     * Строковый параметр времени начала загрузки в час:мин
     * */
    String from = "";
    /**
     * Строковый параметр времени окончания загрузки в час:мин
     * */
    String to = "";
/**
 * база посещений клиентами банка в течении дня
 * */
    private ArrayList<Client> clientsForAllDay = new ArrayList<>();
    /**
     * Отмечаем начало отсечта - принимаем время открытия банка
     * */
 private final LocalTime openTime = LocalTime.of(8, 0);
 /**
  * Отмечаем конец временного промежутка - время закрытия банка
  * */
 private final LocalTime closeTime = LocalTime.of(20, 0);

   /**
    * Константа времени - секунды в минуте
    * */
    private final int secondsPerMinute = 60;
    /**
     * Константа времени - секунды в часе
     * */
    private final int secondsPerHour = 3600;
    /**
     * Массив,содержащий информацию о перегрузке
     * */
    private ArrayList<Client> overloadCatcher = new ArrayList<>();

    /**
 * Каждого нового клиента заносим "в базу данных",
 * @param client - объект класса Client
 * @return - массив объектов класса Client
 * */
        public ArrayList<Client> fillDataBase(Client client) {
          clientVisitTime(client);
          this.getClientsForAllDay().add(client);
        return this.getClientsForAllDay();
    }
/**
 * Для удобства расчетов,переведем время посещения клиентом банка
 * в минутах
 * @param openTime - время открытия банка
 * @param clientInTime - время начала работы с клиентом
 * @return - прошедшее время с открытия банка
 * до начала работы с клиентом в минутах
 * */
      private long getTime(LocalTime openTime, LocalTime clientInTime) {
    LocalTime bankWorkingTime = LocalTime.of(openTime.getHour(), openTime.getMinute());
    Duration duration = Duration.between(bankWorkingTime, clientInTime);
    long seconds = duration.getSeconds();
    long hours = seconds / secondsPerHour;
    long minutes = ((seconds % secondsPerHour) / secondsPerMinute);
    return (hours * 60) + minutes;
}
/**
 * Для каждого нового клиента получаем время начала работы с клиентом
 * и время окончания работы с клиентом.Рачеты проводятся относительно
 * времени открытия банка,результат принимается в минутах
 * @param client - обрабатываемый клиент
 * */
      public void clientVisitTime(Client client) {
          client.setTimeHasPassedBeforeClientHasComeIn(getTime(this.openTime,
                  client.getTimeIn()));
          client.setTimeDuringTheClientHasVisitingBank(getTime(this.openTime,
                  client.getTimeOut()));

      }
/**
 * имея базу клиентов,посетивших банк,можем
 * определить время максимальной нагрузки
 * @param clients - клиенты,посетившие банк
 * */
    public void theMostOverloadTimeInterval(ArrayList<Client> clients) {
    long timeMinutesOverloadFrom = 0;
    long timeMinutesOverloadTo = 0;
    int timeInQuantityOfClients = 0;
    for (Client clientWhoVisitTheBank
            : this.getClientsForAllDay()) {
        for (int i = 0; i < this.getClientsForAllDay().size(); i++) {
            if ((getClientsForAllDay().get(i).getTimeHasPassedBeforeClientHasComeIn()
                    < clientWhoVisitTheBank.getTimeDuringTheClientHasVisitingBank())) {
                   timeMinutesOverloadFrom
                           = getClientsForAllDay().get(i).
                           getTimeHasPassedBeforeClientHasComeIn();
               if (getClientsForAllDay().get(i).getTimeDuringTheClientHasVisitingBank()
                       > clientWhoVisitTheBank.getTimeHasPassedBeforeClientHasComeIn()) {
                   timeInQuantityOfClients++;
               }
               theBiggestClientsQuantity = timeInQuantityOfClients;
                }

               timeMinutesOverloadTo =
                       clientWhoVisitTheBank.getTimeDuringTheClientHasVisitingBank();

            }
            overloadCatcher.add(new Client(timeMinutesOverloadFrom,
                    timeMinutesOverloadTo,
                    timeInQuantityOfClients));
            timeInQuantityOfClients = 0;
        }
    overloadOutTimeCorrect(overloadCatcher);
    getOverloadTimeInterval(overloadCatcher);
}
/**
 * При нескольких  возникновении нескольких интервалов загрузки банка,
 * определяем максимальное число клиентов,тем самым определяя самый
 * нагруженный среди них
 * @param overloadCatcher - массив загрузки банка
 * */
    public int maxClientCounter(ArrayList<Client> overloadCatcher) {
        int theBiggestClientsQuantity = 0;
        for (Client overLoad : overloadCatcher) {
            if (overLoad.getCounter() > theBiggestClientsQuantity) {
                theBiggestClientsQuantity = overLoad.getCounter();
            }
        }
        return theBiggestClientsQuantity;
    }
    public ArrayList<Client> getClientsForAllDay() {
        return clientsForAllDay;
    }
    /**
     * Определяем,время окончания загрузки банка
     * */
    public void overloadOutTimeCorrect(ArrayList<Client> clients) {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getCounter() == maxClientCounter(clients)) {
                if (clients.get(i).getOutTimeOverload() < theLowestDuringTime) {
                    theLowestDuringTime = clients.get(i).getOutTimeOverload();
                }
            }
        }
    }
    /**
     * Приводим полученный ранее интервал загрузки банка
     * в "часы : минуты"
     * @param clients - массив перегрузки
     * */
    public void getOverloadTimeInterval(ArrayList<Client> clients) {
        for (Client c : clients) {
            if (c.getCounter() == maxClientCounter(clients)) {
                for (Client cfad : this.clientsForAllDay) {
                    if (cfad.getTimeHasPassedBeforeClientHasComeIn()
                            == c.getInTimeOverload()) {
                        from = cfad.getTimeIn().toString();
                    }
                    if (cfad.getTimeDuringTheClientHasVisitingBank()
                            == theLowestDuringTime) {
                        to = cfad.getTimeOut().toString();
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        BankService bs = new BankService();

        bs.theMostOverloadTimeInterval(bs.getClientsForAllDay());
    }
}


