package com.thaicom.backend.Schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service

public class UserSchedule {

    // 1 => second,2  => minute, 3 => Hour, 4 => day, 5 => month, 6 => year
    // cron format time is 24 hour and timezone default is UTC +00
    // if you want to run on my time zone you must be add zone in scheduled like this
    //@Scheduled(cron = "0 * * * * *", zone = "Asia/Bangkok")

    /**
     * Every minute
     * @Scheduled(cron = "0 * * * * *")
     */

    @Scheduled(cron = "0 * * * * *")
    public void print(){
        System.out.println("Log INFO : 1 min.");
    }

    /**
     * Every day at 00:00
     * @Scheduled(cron = "0 0 0 * * *")
     */

    /**
     * Every day at 09:00
     * @Scheduled(cron = "0 0 9 * * *")
     */

    /**
     * Every day at 10:50 AM
     * @Scheduled(cron = "0 50 10 * * *")
     */


}
