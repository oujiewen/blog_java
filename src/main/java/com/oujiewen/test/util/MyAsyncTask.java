package com.oujiewen.test.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@EnableAsync
@Slf4j
public class MyAsyncTask {
    @Async
    public void publishMsg(){
        try {
            log.warn("开始执行任务："+ LocalDateTime.now());
            Thread.sleep(5000);
            log.warn("结束执行任务："+ LocalDateTime.now());
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }

}
