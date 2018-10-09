package sqlJdbc.test_ex.parser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sqlJdbc.service.Settings;

import java.sql.Connection;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParseSqlRuTest {
    ParseSqlRu parseSqlRu;
    Settings settings;
    /**
     * создаем параметр для подключения к базе данных
     */
    private Connection openConn;

    @Before
    public void ParseTestvariables() {
        parseSqlRu = new ParseSqlRu();
        settings = new Settings();

    }

    /**
     * удаляем таблицу и парсим сайт
     */
    @After
    public void dropAndParse(){
        parseSqlRu.dropTable();
        parseSqlRu.parsePage();
    }

    @Test
    public void pageCounter() {
        assertTrue(parseSqlRu.pageCounter()!=-1);
    }

    /**
     * Удаляем таблицу и
     * парсим сайт
     *
     * размер хранилища должен быть
     * больше 0
     */
    @Test
    public void parsePage() {
        dropAndParse();
        assertTrue(parseSqlRu.getVacancyList().size()!=0);
    }

    @Test
    public void getProperty() {
        settings.load();
        assertThat(settings.getValue("jdbc.username"),is("postgres"));
    }

    /**
     * Удаляем таблицу и
     * парсим сайт
     * создаем таблицу
     * метод проверки
     * @see ParseSqlRu#check()
     * должен вернуть true, если таблица создалась
     */
    @Test
    public void createTable() {
        parseSqlRu.createTable();
        assertTrue(parseSqlRu.check());
    }

    @Test
    public void getDataFromDB() {
        parseSqlRu.getDataFromDB();
        assertTrue(parseSqlRu.getDataFromDB().size() > 0);
    }

    @Test
    public void check() {
        assertTrue(parseSqlRu.check());
    }

    /**
     * чистим таблицу
     * размер хранилища
     * должен быть равен 0;
     */
    @Test
    public void clearTable() {
        parseSqlRu.clearTable();
        assertThat(parseSqlRu.getDataFromDB().size(),is(0));

    }


    @Test
    public void fillTable() {
        dropAndParse();
        assertTrue(parseSqlRu.fillTable(parseSqlRu.getVacancyList()));


    }
}