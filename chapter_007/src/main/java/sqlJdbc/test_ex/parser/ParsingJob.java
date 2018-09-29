package sqlJdbc.test_ex.parser;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import sqlJdbc.jdbc.connection.ConnectOptions;

import java.util.Date;

/**
 * Класс определяет задачу для выполненния
 */
public class ParsingJob implements Job {
    /**
     * файл логирования
     */
    private static final Logger log = LogManager.getLogger(ConnectOptions.class);
    /**
     * объект - парсер
     * */
    ParseSqlRu parseSqlRu;

    /**
     * Определим экземпляр
     * объекта парсера
     */
    public ParsingJob() {
        parseSqlRu =  new ParseSqlRu();
    }

    /**
     * исполняемая задача
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
       parseSqlRu.parsePage();
       log.info("Парсер запущен: "+ new Date());
    }
}
