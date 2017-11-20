package ru.chedmitriy.multithreading.threads.waitNotify.ex1100;

import java.util.Random;

/**
 * junior.
 *
 * @author CheDmitry
 * @version 1.0
 * @since 08.11.17
 */
public class MainThread {

    public static void main(String[] args) {

        CapacityFill capacityFill = new CapacityFill();
        SmallContainer smallContainer = new SmallContainer(capacityFill);
        BigContainer bigContainer = new BigContainer(capacityFill);
        new Thread(smallContainer).start();
        new Thread(bigContainer).start();
    }
}

class CapacityFill {
    /**
     * параметр- минимальное количество
     * воды
     */
    private final double minVolume = 0.15;
    /**
     * макимальное количетво воды.
     */
    private final double maxVolume = 0.4;

    /**
     * объем первой емкоти.
     */
    private double capOneVol = 0;
    /**
     * объем виорой емкости.
     */
    private double capTwoVol = 0;
    /**
     * количетво налитой/слитой воды.
     */
    private double oddValue = 0;

    /**
     * расчет лучайног количества воды
     * добавляемой или сливаемой.
     * @return - значение типа double
     */
    public double randomVolumeStream() {
        Random r = new Random();
        return  minVolume + (maxVolume - minVolume) * r.nextDouble();
    }


    /**
     * при наполненнии
     * первой емкости,вода начинает
     * переливаться, наполняя вторую емкость.
     * При этом уровень воды первой емкости ,
     * остается приблизительно неизменным
     */
    public synchronized void get() {
        while (capTwoVol >= 10 || capOneVol <= 5) {
            try {
                wait();

            } catch (InterruptedException e) {
                System.out.println("ошибка");
            }
        }

        oddValue = randomVolumeStream();
        capOneVol -= oddValue;
        capTwoVol += oddValue;

        System.out.print(String.format("%s  %s %.2f %s%n",
                "первая емкость наполнилась",
                "в ней вего:",
                capOneVol,
                "литра воды"));
        System.out.print(String.format("%s %.2f %s %s %.2f %s%n",
                "вторая емкость наполняется на:",
                oddValue,
                "литра воды -",
                "в ней становится:",
                capTwoVol,
                "литра воды"));
        notify();
    }

    /**
     * наполнение первой емкости
     * происходит
     * до тех пор, пока объем залитой
     * жидкости не установится на уровне,
     * установленном в условии.
     *
     */
    public synchronized void add() {

        while (capOneVol >= 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }
        oddValue = randomVolumeStream();
        capOneVol += oddValue;


        System.out.print(String.format("%s %.2f %s %s %.2f %s%n",
                "первая емкость наполняется на:",
                oddValue,
                "литра,",
                "в ней становится:",
                capOneVol,
                "литра воды"));
        System.out.print(String.format("%s %.2f %s%n",
                "количество воды во второй емкости: ",
                capTwoVol,
                "литра воды"));

        notify();
    }


    /**
     * получаем
     * количество заполненности
     * второй емкости.
     * @return - значение типа double
     */
    public double getCapTwoVol() {
        return capTwoVol;
    }
}

/**
 * поток наполняемости
 * первой емкости.
 */
class SmallContainer implements Runnable {

    /**
     * объект определяющий алгоритм
     * действий.
     */
    private final CapacityFill capacityFill;
    /**
     * конструктор потока.
     * @param capacityFill - наполненние емкостей
     */

    SmallContainer(CapacityFill capacityFill) {
        this.capacityFill = capacityFill;
    }

    @Override
    public void run() {
        while (capacityFill.getCapTwoVol() <= 10) {
            capacityFill.add();
        }
    }
}

/**
 * поток наполняемости
 * второй емкости при переливании
 * второй.
 */
class BigContainer implements Runnable {

    /**
     * объект определяющий алгоритм
     * действий.
     */
    private final CapacityFill capacityFill;

    /**
     * конструктор потока.
     * @param capacityFill - наполненние емкостей
     */

    BigContainer(CapacityFill capacityFill) {
        this.capacityFill = capacityFill;
    }

    @Override
    public void run() {
        while (capacityFill.getCapTwoVol() <= 10) {
            capacityFill.get();
        }
    }
}
