package sqljdbc.testex.parser;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import sqljdbc.service.Settings;
import sqljdbc.testex.parser.quartz.ParsingJob;

/**
 * Главный класс,
 * задающий алгоритм запуска приложения
 *
 */
public class ParseMainClass {
    /**
     * файл конфигурации
     */
   private static Settings settings;

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
                withSchedule(CronScheduleBuilder.cronSchedule(settings.getValue("cron.time"))).build();

        Scheduler sc = StdSchedulerFactory.getDefaultScheduler();

        sc.start();

        sc.scheduleJob(job, cronTrigger);
    }
}
