package com.oujiewen.test.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("stu")
@Slf4j
public class StuController {
    @GetMapping("{stuid}")
    public String getStu(@PathVariable("stuid") String stuid,String name,
                         @RequestHeader("token") String token,
                         @CookieValue("token") String token2){
        /**
         * @RequestParam: 用语获取url中的请求参数。如果参数变量名一致，该注解可以省略
         */
        log.info("stuid=" + stuid);
        log.info("name=" + name);
        log.info("tiken="+token);
        log.info("tiken2="+token2);
        return "查询stu："+stuid;
    }

    @PostMapping("create")
    public String createStu(String name,String sex,Integer age){
//        log.info("map:"+map.toString());
//        log.info(res.toStringg());
        return "新增Stu:"+name+":"+sex+":"+age;
    }

    @PutMapping("update")
    public String updateStu(){
        return "更新Stu";
    }

    @DeleteMapping("delete")
    public String deleteStu(){
        return "删除Stu";
    }
}
