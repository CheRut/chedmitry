package ru.chedmitriy.testex.parser;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import ru.chedmitriy.service.Settings;
import ru.chedmitriy.testex.quartz.ParsingJob;


/**
 * Главный класс,
 * задающий алгоритм запуска приложения
 *
 */
public class ParseMainClass {

    public static void main(String[] args) throws SchedulerException {
        Settings settings = new Settings();
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
