package ru.chedmitriy.testex.object;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import java.text.DateFormatSymbols;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateConverter {

    /**
     * строка- дата
     */
    private String strDate;
    /**
     * дата
     */
    private Date date;
    /**
     * Объект форматирования даты
     */
    SimpleDateFormat format;

    /**
     * файл логирования
     */
    private static final Logger LOGGER = LogManager.getLogger(DateConverter.class);

    /** преобразование дат из
     * таблицы сайта к одному фиду
     * @param sd - строковое значение даты
     * @return - дата
     */
    public Date dateConverter(String sd) {

        format = new SimpleDateFormat("dd MMMM yy, HH:mm", myDateFormatSymbols);
        try {
            date = format.parse(sd);
        } catch (Exception e) {
            LOGGER.error(e);
        }

        return date;
    }

    /**
     * Преобразовании
     * даты "вчера" и "сегодня"
     * @param sd праметр даты
     * @return - строка сдатой в "dd MMMM yy, HH:mm" виде
     */
    public String yestTodayWordsChecker(String sd) {

        format = new SimpleDateFormat("dd MMMM yy", myDateFormatSymbols);
        if (sd.contains("вчера")) {
            strDate = format.format(yesterday()) + "," + sd.substring(sd.lastIndexOf(",") + 1);
        } else if (sd.contains("сегодня")) {
            strDate = format.format(new Date()) + "," + sd.substring(sd.lastIndexOf(",") + 1);
        } else {
            strDate = sd;
        }
        return strDate;
    }

    /**
     * преобразование даты "вчера"
     * @return - получаем дату
     */
    private Date yesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    /**
     * формат месяцев
     *
     */
    private DateFormatSymbols myDateFormatSymbols = new DateFormatSymbols() {
        @Override
        public String[] getMonths() {
            return new String[]{"янв", "фев", "мар", "апр", "май", "июн",
                    "июл", "авг", "сен", "окт", "ноя", "дек"};
        }
    };


}