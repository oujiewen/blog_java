package com.oujiewen.test;

import com.oujiewen.test.pojo.Stu;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//声明为该配置为配置类
/**
 * @Bean
 * @Controller
 * @Service
 * @Repository
 * @Component
 * 这些逐渐注解也饿能使用，根据场景和业务去使用定义即可
 */
public class SpringBootConfig {
    @Bean
    public  Stu stu(){
        return new Stu("jack",18);
    }

}
