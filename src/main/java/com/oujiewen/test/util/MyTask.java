package com.oujiewen.test.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@Configuration//标记配置类，使得springboot容器可以扫描到
//@EnableScheduling //开启定时任务
@Slf4j
public class MyTask {
    @Scheduled(cron="*/5 * * * * ?")
    public void publishMsg(){
        log.warn("开始执行任务："+ LocalDateTime.now());
    }

}
