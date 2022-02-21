package com.oujiewen.test.controller;
import com.alibaba.fastjson.JSONObject;
import com.oujiewen.test.pojo.MyConfig;
import com.oujiewen.test.pojo.Mystu;
import com.oujiewen.test.pojo.Stu;
import com.oujiewen.test.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("wrlx")
    public Object getResult(){
        HashMap<String,Object> h=new HashMap<String,Object>();
        h.put("name","ojw");
        h.put("age",18);
        return JsonResult.ok(h);
    }
    @PostMapping("upload")
    public String upload(MultipartFile file) throws IOException {
        file.transferTo(new File("d://oujiewen_pic/"+file.getOriginalFilename()));
        System.out.println("tmp"+file.getOriginalFilename());
        return "上传成功";
    }

}
