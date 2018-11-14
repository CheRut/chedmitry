package ru.chedmitriy.bank;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by root on 3/18/17.
 */
     public class Client {
    private  String name;
    private  String surName;

    private long inTimeOverload;
    private long outTimeOverload;
    private int counter;



    /**
     * время начала обслуживания клиента
     * */
    private  LocalTime timeIn;
    /**
     * Время прекращения работы с клиентом
     * */
    private  LocalTime timeOut;
    /**
     * Время,прошедшее с момента открытия банка,до начала работы
     * с клиентом
     * */
    private  long  timeHasPassedBeforeClientHasComeIn;
    /**
     * Время, прошедшее с начала открытия банка до прекращения
     * обслуживанияя клиента
     * */
    private  long  timeDuringTheClientHasVisitingBank;
    /**
     * Формат времени "Часы : минуты"
     * */
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
/**
 * Конструктор регистрации клиентов в банке
 * */
    public Client(String name, String surName, String timeIn,
                  String timeOut, long timeHasPassedBeforeClientHasComeIn,
                  long timeDuringTheClientHasVisitingBank) {
        this.name = name;
        this.surName = surName;
        this.timeIn = LocalTime.parse(timeIn, formatter);
        this.timeOut = LocalTime.parse(timeOut, formatter);
        this.timeHasPassedBeforeClientHasComeIn = timeHasPassedBeforeClientHasComeIn;
        this.timeDuringTheClientHasVisitingBank = timeDuringTheClientHasVisitingBank;
    }
/**
 * Перегруженный конструктор,содержащий информацию о нагрузке на банк
 * */
    public Client(long inTimeOverload, long outTimeOverload, int counter) {
        this.setInTimeOverload(inTimeOverload);
        this.setOutTimeOverload(outTimeOverload);
        this.setCounter(counter);
    }

    /**
     * Геттеры и Сеттеры для переменных
     * */

    public LocalTime getTimeIn() {
        return timeIn;
    }
    public LocalTime getTimeOut() {
        return timeOut;
    }
    public long getTimeHasPassedBeforeClientHasComeIn() {
        return timeHasPassedBeforeClientHasComeIn;
    }
    public long getTimeDuringTheClientHasVisitingBank() {
        return timeDuringTheClientHasVisitingBank;
    }
    public void setTimeHasPassedBeforeClientHasComeIn(long timeHasPassedBeforeClientHasComeIn) {
        this.timeHasPassedBeforeClientHasComeIn = timeHasPassedBeforeClientHasComeIn;
    }
    public void setTimeDuringTheClientHasVisitingBank(long timeDuringTheClientHasVisitingBank) {
        this.timeDuringTheClientHasVisitingBank = timeDuringTheClientHasVisitingBank;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurName() {
        return surName;
    }
    public void setSurName(String surName) {
        this.surName = surName;
    }
    public long getInTimeOverload() {
        return inTimeOverload;
    }
    public void setInTimeOverload(long inTimeOverload) {
        this.inTimeOverload = inTimeOverload;
    }
    public long getOutTimeOverload() {
        return outTimeOverload;
    }
    public void setOutTimeOverload(long outTimeOverload) {
        this.outTimeOverload = outTimeOverload;
    }
    public int getCounter() {
        return counter;
    }
    public void setCounter(int counter) {
        this.counter = counter;
    }
}
