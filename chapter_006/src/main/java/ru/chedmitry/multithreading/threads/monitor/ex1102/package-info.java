/**
 * junior
 * @author CheDmitry
 * @version 1.0
 * @since 27.10.17
 *
 *
 * В пакете представлена работа блокировки
 * метода,увеличивающего параметр на единицу.
 * Вызов этого метода двумя потоками
 * должен суммарно
 * дать вдвое больший результат.
 * В программе метод run вызывает метод
 * инкремента 9 млн раз,но,так как
 * метод синхронизирован,метод
 * будет вызываться каждым потоком поочереди
 * ответ должен получиться
 * 18 млн
 */
package ru.chedmitry.multithreading.threads.monitor.ex1102;