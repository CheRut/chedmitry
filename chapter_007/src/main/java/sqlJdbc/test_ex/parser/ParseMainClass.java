package sqlJdbc.test_ex.parser;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import sqlJdbc.service.Settings;

/**
 * Главный класс,
 * задающий алгоритм запуска приложения
 *
 */
public class ParseMainClass {
    /**
     * файл конфигурации
     */
   public static Settings settings;

    public static void main(String[] args) throws SchedulerException {
        settings = new Settings();
        settings.load();
        /**
         * определим задачу
         * */
        JobDetail job =  JobBuilder.newJob(ParsingJob.class).build();
        /**
         * определим периодичност запуска*/
        Trigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("CronTrigger").
                withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *")).build();

        Scheduler sc = StdSchedulerFactory.getDefaultScheduler();

        sc.start();

        sc.scheduleJob(job,cronTrigger);
    }
}
