package sqljdbc.testex.parser.quartz;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import sqljdbc.jdbc.connection.ConnectOptions;
import sqljdbc.testex.parser.ParseSqlRu;

import java.util.Date;

/**
 * Класс определяет задачу для выполненния
 */
public class ParsingJob implements Job {
    /**
     * файл логирования
     */
    private static final Logger LOGGER = LogManager.getLogger(ConnectOptions.class);
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
       LOGGER.info("Парсер запущен: " + new Date());
    }
}
