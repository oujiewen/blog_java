package com.oujiewen.test.Exception;

import com.oujiewen.test.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

/**
 * 统一异常拦截处理
 * 可以针对异常自定义去处理去捕获，返回指定类型（json）到前端
 */
@Slf4j
@ControllerAdvice
public class GraceExceptionHanler {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseBody
    public JsonResult returnMaxFilesSizeLimit(MaxUploadSizeExceededException e){
        return JsonResult.eroor(ErrorMsg.file_max);
    }

    @ExceptionHandler(MyException.class)
    @ResponseBody
    public JsonResult returnMyException(MyException e){
        return  JsonResult.eroor(e.getMessage());
    }

}
