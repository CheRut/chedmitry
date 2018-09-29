package sqlJdbc.test_ex.parser;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import sqlJdbc.jdbc.connection.ConnectOptions;
import sqlJdbc.service.Settings;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateConverter {

    private String strDate;
    private Date date;
    SimpleDateFormat format;

    /**
     * файл логирования
     */
    private static final Logger log = LogManager.getLogger(ConnectOptions.class);

    public  Date dateConverter(String sd) {

        format = new SimpleDateFormat("dd MMMM yy, HH:mm", myDateFormatSymbols);
        try {
            date = format.parse(sd);
        } catch(Exception e){
            log.error(e);
        }

        return date;
    }

    public String yestTodayWordsChecker (String sd) {

        format = new SimpleDateFormat("dd MMMM yy", myDateFormatSymbols);
        if (sd.contains("вчера")) {
            strDate = format.format(yesterday()) + "," + sd.substring(sd.lastIndexOf(",") + 1);
        } else if (sd.contains("сегодня")) {
            strDate = format.format(new Date()) + "," + sd.substring(sd.lastIndexOf(",") + 1);
        }
        else strDate = sd;
        return strDate;
    }
    private  Date yesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }
    private  String getYesterdayDateString() {
        DateFormat dateFormat = new SimpleDateFormat("dd MMM yy",myDateFormatSymbols);
        return dateFormat.format(yesterday());
    }
    private  String getTodayDateString(){
        DateFormat dateFormat = new SimpleDateFormat("dd MMM yy",myDateFormatSymbols);
        return dateFormat.format(new Date());
    }
    private  DateFormatSymbols myDateFormatSymbols = new DateFormatSymbols() {
        @Override
        public String[] getMonths() {
            return new String[]{"янв", "фев", "мар", "апр", "май", "июн",
                    "июл", "авг", "сен", "окт", "ноя", "дек"};
        }
    };

    /**
     * обращаемся к файлу
     * конфигурации,
     * вводим нужный адрес,
     * получаем строку результат
     *
     * @param propertyLine - исполняемая строка в конфигураторе
     * @return - полученный результат после конфигурации
     */
    private String getProperty(final String propertyLine) {
        Settings s = new Settings();
        s.load();
        return s.getValue(propertyLine);
    }

    public static void main(String[] args) {
        System.out.println(new DateConverter().yestTodayWordsChecker("сегодня, 14:40"));
    }
}