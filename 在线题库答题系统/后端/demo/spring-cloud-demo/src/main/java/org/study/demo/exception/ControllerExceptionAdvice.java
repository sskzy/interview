package org.study.demo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.study.demo.controller.vo.Status;
import org.study.demo.util.metaData;

/**
 * @Author: SongTC
 * @Since: 2022/11/13
 * @E-mail: 690259811@qq.com
 * @Details;
 */

@RestControllerAdvice(value = "org.study.demo.controller")
public class ControllerExceptionAdvice {

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Status exceptionHandler(NullPointerException e) {
        return new Status(metaData.DEFEAT.CODE, metaData.DEFEAT.MSG);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Status exceptionHandler(Exception e) {
        return new Status(metaData.ERROR.CODE, metaData.ERROR.MSG);
    }

}
