package ru.chedmitriy.consolechat;

import org.apache.log4j.Logger;
import ru.chedmitriy.bank.ConsoleIO;

import java.io.*;
import java.util.ArrayList;
/**
 * @author Dmitry Cherutsa on 09.01.2017.
 * @version $Id$
 * @project junior
 * @since 0.1
 */
public class Chat {
    /**
     * source - параметр,который принимает
     * файл - список ответов
     * */
    File answerSource;
    /**.
     * объвление константы
     * для логгирования
     * */
    private static final Logger LOG = Logger.getLogger(Chat.class.getName());

    /**.
     * answerOutput - параметр,который
     * принимает строки потока
     * */
    String answerOutput;
    /**
     * использую ArrayList для
     * удобства - размер меняется динамически*/
    ArrayList<String> answerList;
    /**.
     * roboAnswer -
     * параметр,который принимает
     * случайный элемент массива*/
    String roboAnswer = "";
    /**.
     * randomIndex- целочисленный параметр,
     * который принимает случайное число
     * в диапазоне размера массива
     * */
    int randomIndex;
    /**.
     * robotSpeakingAllowed -
     * параметр,принимающий
     * true/false значение,который
     * определяет может ли программа отвечать
     * */

    boolean robotSpeakingAllowed;
    ConsoleIO cIO = new ConsoleIO();

    public Chat(File answerSource) {
        this.answerSource = answerSource;
    }
    /**.
     * метод, который берет из указанного файла
     * строку,заносит ее в массив
     * затем в случайном порядке
     * возвращает строку(из массива)
     * @return  - строка-ответ
     * */
   public String answer() throws IOException {
       answerList = new ArrayList<>();
       if (robotSpeakingAllowed) {
           try (BufferedReader randomAnswer
                        = new BufferedReader(new FileReader(this.answerSource))) {
               while ((answerOutput = randomAnswer.readLine()) != null) {
                   answerList.add(answerOutput);
               }
               randomIndex = (int) (Math.random() * (answerList.size() - 1));
               cIO.print("Robot: ");
               roboAnswer = answerList.get(randomIndex);
               cIO.println(roboAnswer);
               LOG.info("Robot сказал: " + roboAnswer);
           } catch (IOException ex) {
               ex.printStackTrace();
           }
       }
       return answerOutput;
   }

    /**.
     * Метод,принимает введенную
     * пользователем фразу
     * @return строку - введенное слово
     * */
public String userTalk() {
    robotSpeakingAllowed = true;
    String userSpeaking = cIO.ask("User: ");
    LOG.info("User сказал " + userSpeaking);
        if (muteRoboChatting(userSpeaking)) {
            while (!continueRoboChat(userTalk())) {
                robotSpeakingAllowed = false;
            }
        }
 return  userSpeaking;
}
    /**.
     * Метод который завершает программу
     * при введении слова "закончить"
     * @param stop - принимаемая для сравнения строка
     * @return true если stop равна "закончить"*/
  public   boolean stopChatting(String stop) {
        return stop.equals("закончить");
    }
    /**.
     * Метод который продолжает отвечать
     * на вопросы пользователя
     * при введении слова "продолжить"
     * @param contin - принимаемая для сравнения строка
     * @return true если contin равна "продолжить"*/
    public  boolean continueRoboChat(String contin) {
          return contin.equals("продолжить");
      }
    /**.
     * Метод который приостанавливает
     * выводслучайных ответов
     * при введении слова "стоп"
     * @param mute - принимаемая для сравнения строка
     * @return true если mute равна "стоп"*/
   public boolean muteRoboChatting(String mute) {
        return mute.equals("стоп");
    }
/**.
 * метод - имитирующий диалог
 * пользователя и компьютера */
    public void dialog() throws IOException {
        while (!stopChatting(userTalk())) {
                     answer();
                 }
    }
}
