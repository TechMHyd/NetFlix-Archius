package com.techm.netflix.archius.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.techm.netflix.archius.service.CopyFileContent;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

  /*  @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }*/
    
    @Scheduled(fixedRate = 30000)
    public void copyFileContents() throws Exception {
        log.info("The time is now {}", dateFormat.format(new Date()));
      
        CopyFileContent fileOpe = new CopyFileContent();
        fileOpe.CopyFileOperation();
    }
    
    
}
