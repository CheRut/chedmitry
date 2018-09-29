package sqlJdbc.test_ex.parser;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import sqlJdbc.jdbc.connection.ConnectOptions;
import sqlJdbc.service.Settings;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.Date;


public class ParseSqlRu  {

    /**
     * форматируем дату к удобному виду
     */
    private DateConverter dateFormat;

    /**
     * список объектов вакансий
     */
    private Set<Vacancy> vacancyList;
    /**
     * файл логирования
     */
    private static final Logger log = LogManager.getLogger(ConnectOptions.class);
    /**
     * создаем параметр для подключения к базе данных
     */
    private  Connection openConn;
    /**
     * нумерация страниц
     */
    private  int page = 1;
    /**
     * количество страниц
     */
    private int pageValue = 0;
    /**
     * счетчик страниц
     */
    private String pageCount = "";

    /**
     * объект обработки документа - web страницы в данном случае
     */
    private Document doc = null;


    /**
     * начало отсчета
     */
    private final String STARTTIME = "01 янв 18, 00:00";


    /**
     * Конструктор поумолчанию:
     * определяем контейнер в определенном порядке
     * @see ParseSqlRu#fromEarlierToLast
     *
     * определяем объект форматирования
     * @see DateConverter
     */
    public ParseSqlRu() {
        vacancyList =  new TreeSet<>(fromEarlierToLast);
        dateFormat = new DateConverter();
    }
    /**
     * считаем количество страниц
     * с размещенными вакансиями:
     * по определенному заданием условию
     * при этом,проверяем,
     * есть таблица в базе данных
     * @see ParseSqlRu#check()
     * если она отсутствует,
     * выбирам все нужные
     * значения с января 2018 года;
     * если в базе данных таблица существует,
     * тогда bot последнее добавленное значение
     * и добавляем новое,соттветствующее
     * более поздней дате
     * @return  pageValue - количество
     *          страниц,которые надо будет обработать.
     */
    public int pageCounter() {
        String date = null;
        int beginOfYearCatch = 0;
        boolean lastDate = false;
        if(!check())
            while ( beginOfYearCatch != -1)   {
                try {
                    Document document = Jsoup.connect(getProperty("jdbc.url") + pageValue).get();
                    Elements links = document.select("tr:contains(Java)");
                    for (Element t : links) {
                        if (!t.text().contains("JavaScript")
                                || !t.text().contains("Script")) {
                            date = dateFormat.yestTodayWordsChecker(t.child(5).text());
                            if (!dateFormat.dateConverter(date).after(dateFormat.dateConverter(STARTTIME))) {
                                beginOfYearCatch = -1;
                            }
                        }
                    }
                } catch (IOException e) {
                    log.error(e);
                }

                pageValue++;
            }
        else if(check()){
            while (!lastDate){
                try {
                    Document doc = Jsoup.connect(getProperty("jdbc.url") + pageValue).get();
                    Elements links = doc.select("tr:contains(Java)");
                    for (Element t : links) {
                        if (!t.text().contains("JavaScript") || !t.text().contains("Script")) {
                            date = dateFormat.yestTodayWordsChecker(t.child(5).text());
                            if (!compareLastAddingValue(date)) {
                                lastDate = true;
                            }
                        }
                    }
                } catch (IOException e) {
                    log.error(e);
                }
                pageValue++;
            }
        } else  {
            pageValue = -1;
        }
        return --pageValue;
    }


    /**
     * ищем вакнсии,
     * удовлетворяющие требованиям
     * @return если новых
     * значений нет,возвращаем
     * false
     */

    public  boolean   parsePage() {
        String autor = null;
        String date = null;
        String vacValue = null;
        Vacancy vacancy = null;
        pageCounter();
        if (pageValue < 0){
            log.info("Нечего добавлять на: "+ new Date()+ " число");
        }
        if (!check()) {
            vacancyList = firstTimeAddingList(this.pageValue);
        } else if(check()) {
            getDataFromDB();
            while (page <= pageValue) {
                try {
                    doc = Jsoup.connect(getProperty("jdbc.url")+page).get();
                    Elements links = doc.select("tr:contains(Java)");
                    for (Element t : links) {
                        if (!t.text().contains("JavaScript") || !t.text().contains("Script")) {
                            vacValue = t.getElementsByClass("postslisttopic").text();
                            date = dateFormat.yestTodayWordsChecker(t.child(5).text());
                            autor = t.child(2).text();
                            if(compareLastAddingValue(date)){
                                vacancy = new Vacancy(vacValue,autor,date);

                                vacancyList.add(vacancy);
                            }
                        }
                    }
                } catch (IOException e) {
                    log.error(e);
                }
                page++;
            }

        }
        else {
            return false;
        }
        fillTable(vacancyList);
        return true;
    }

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

    /**
     * подключение к базе данных
     * @param dbName - название бд
     * @return при правильном соб
     * возвращаем объект к
     */
    public boolean connectDb(final String dbName) {
        try {
            Class.forName("org.postgresql.Driver");
            openConn = DriverManager.getConnection(getProperty("jdbc.driver")+dbName,
                    getProperty("jdbc.username"),
                    getProperty("jdbc.password"));
            log.info("Подключение к базе данных "+dbName+" успешно ");
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     *
     * создаем таблицу,
     * если не создана.
     * Добавляем поля
     *
     */
    public boolean createTable() {
        connectDb(getProperty("jdbc.dBName"));
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean isCreated = false;
        try {
            String newDbTable = "CREATE TABLE IF NOT EXISTS" +
                    " vacancies(id serial primary key," +
                    " vac_name text, "+
                    " vac_autor text, "+
                    " vac_create text" +
                    ")";
            pst = openConn.prepareStatement(newDbTable);
            pst.execute();
            log.info("Создана новая таблица для учета вакансий:  "+"vacancies");
            isCreated = true;
        } catch (Exception e) {
            log.error(e);
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if(openConn!=null){
                    openConn.close();
                }
            } catch (Exception e) {
                log.error(e);
            }
        }
        return isCreated;
    }

    /**
     * Получаем значения из базы данных
     *
     */
    public Set<Vacancy> getDataFromDB() {
        connectDb(getProperty("jdbc.dBName"));
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sqlQuery = "select * from vacancies";
        try {
            pst = openConn.prepareStatement(sqlQuery);
            rs = pst.executeQuery();
            while (rs.next()) {
                vacancyList.add(new Vacancy(
                        rs.getString("vac_name"),
                        rs.getString("vac_autor"),
                        rs.getString("vac_create")));            }

            log.info("получены данные из базы данных "+getProperty("jdbc.dBName"));
            rs.close();
            pst.close();
            openConn.close();
        } catch (SQLException e) {
            log.error(e + "Таблица не создана");
        }
        return vacancyList;
    }

    /**
     * Проверяем наличие таблицы в БД
     * @return true/false
     */
    public boolean check(){
        connectDb(getProperty("jdbc.dBName"));
        DatabaseMetaData metadata = null;
        try {
            metadata = openConn.getMetaData();
            ResultSet resultSet;
            resultSet = metadata.getTables(null,
                    null, null, null);
            while(resultSet.next()){
                if(resultSet.getString(3).equals("vacancies")){
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * При наличии данных в таблице,
     * определяем дату последнего добавленного
     * в таблицу значения,
     * сравниваем его с датой
     * появившихся вакансий
     * last в конечном итоге примет значение
     * самой свежей записи в таблице
     * @param date - дата
     * @return true/false
     */
    private boolean compareLastAddingValue(String date){
        String last = null;
        connectDb(getProperty("jdbc.dBName"));
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sqlQuery = "select * from vacancies";
        try {
            pst = openConn.prepareStatement(sqlQuery);
            rs = pst.executeQuery();
            while (rs.next()){
                last = rs.getString("vac_create");
            }
        } catch (SQLException e) {
            log.error(e);
        }
        return dateFormat.dateConverter(date).after(dateFormat.dateConverter(last));
    }

    /**
     * Если таблица создается в этой сессии,
     * то выбираем все значения сайта,
     * вплоть до начала 2018 года
     * @param pageValue - количество
     *                 обрабатываемых страниц
     * @return контейнер с данными
     */
    public Set<Vacancy> firstTimeAddingList(int pageValue) {
        String autor = null;
        String date = null;
        String vacValue = null;
        Vacancy vacancy = null;
        dateFormat = new DateConverter();
        while (page <= pageValue) {
            try {
                doc = Jsoup.connect(getProperty("jdbc.url") + page).get();
                Elements links = doc.select("tr:contains(Java)");
                for (Element t : links) {
                    if (!t.text().contains("JavaScript") || !t.text().contains("Script")) {
                        vacValue = t.getElementsByClass("postslisttopic").text();
                        date = dateFormat.yestTodayWordsChecker(t.child(5).text());
                        autor = t.child(2).text();

                        if (dateFormat.dateConverter(date).after(dateFormat.dateConverter(STARTTIME))) {
                            vacancy = new Vacancy(vacValue, autor, date);
                            vacancyList.add(vacancy);
                        }
                    }
                }
            } catch (IOException e) {
                log.error(e);
            }
            page++;
        }
        return vacancyList;
    }

    /**
     * Очищаем таблицу
     * @return true если не возникло
     * было никаких пролем
     */
    public boolean clearTable() {
        connectDb(getProperty("jdbc.dBName"));
        PreparedStatement prepSt = null;
        boolean isCleared = false;
        try {
            prepSt = openConn.prepareStatement("delete from vacancies");
            prepSt.execute();
            log.info("Таблица очищена");
            isCleared = true;
            prepSt.close();
            openConn.close();
        } catch (SQLException e) {
            log.error(e);
        }

        return isCleared;
    }
    /**
     * Заполняем таблицу
     * списком из хранилища,образованного
     * через:
     * @see ParseSqlRu#getDataFromDB()
     * или
     * @see ParseSqlRu#firstTimeAddingList(int)
     * @return true/false
     */
    public boolean fillTable(final Set<Vacancy> vacList) {
        createTable();
        clearTable();
        connectDb(getProperty("jdbc.dBName"));
        PreparedStatement preparedStatement = null;
        if (vacancyList.size()==0){
            log.error("Отстутствую данные для добавления");
            return false;
        }
        try {
            for (Vacancy v : vacList) {
                preparedStatement = openConn.prepareStatement("insert into vacancies(vac_name,vac_autor,vac_create)" +
                        " values ('" + v.getVacancyType() + "','" + v.getAuthor() + "','" + v.getCreate() + "')   ");
                preparedStatement.execute();
            }
            log.info("Данные добавлены");
            return true;
        } catch (SQLException e) {
            log.error(e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if(openConn != null){
                    openConn.close();
                }
            } catch (Exception e) {
                log.error(e);
            }
        }
        return false;
    }


    /**
     * Порядок расположения элементов
     * в хранилище
     * @return - результат сравненния
     */
    private final Comparator<Vacancy> fromEarlierToLast = new Comparator<Vacancy>() {
        @Override
        public int compare(Vacancy o1, Vacancy o2) {
            return dateFormat.dateConverter(o1.getCreate()).compareTo(dateFormat.dateConverter(o2.getCreate()));
        }
    };

    public Set<Vacancy> getVacancyList() {
        return vacancyList;
    }

    /**
     * вспомагательный метод,
     * определенный для тестирования
     * удаляет таблицу из БД
     * @return true/false
     */
    public boolean dropTable() {
        openConn = null;
        PreparedStatement statement = null;
        connectDb("postgres");
        try {
            statement =  openConn.prepareStatement("DROP TABLE IF EXISTS vacancies  ");
            statement.execute();
            statement.close();
            openConn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }





}



















































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































