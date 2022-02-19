package com.oujiewen.test.controller;
import com.oujiewen.test.pojo.MyConfig;
import com.oujiewen.test.pojo.Mystu;
import com.oujiewen.test.pojo.Stu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {
//    @RequestMapping("hello")
    @PostMapping ("hello")
    public String hello(){
        return "hello world3~~";
    }

    @Autowired
    private Stu stu;
    @GetMapping("getStu")
    public Object getStu(){
        return stu;
    }

    @Autowired
    private MyConfig MyC;
    @GetMapping("config")
    public Object getMyconfig(){
        return MyC;
    }

    @GetMapping("mystu")
    public Object getMstu(){
        Mystu mystu= new Mystu();
        mystu.setName("oujiewen");
        mystu.setAge(18);
        log.info(mystu.toString());
        return mystu;
    }

}
