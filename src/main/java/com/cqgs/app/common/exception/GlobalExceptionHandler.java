package com.cqgs.app.common.exception;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqgs.app.common.trade.ResponseResult;
import com.cqgs.app.common.trade.ResponseStatus;

/**
 * Created by fuda on 2015/2/4.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static boolean showErrorMsg = true;

    static{
        try {
            PropertiesConfiguration webConfig = new PropertiesConfiguration("appConfig.properties");
            showErrorMsg = webConfig.getBoolean("show.error");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    @ExceptionHandler
    @ResponseBody
    public ResponseResult handleException(Exception ex) {

        ex.printStackTrace();

        String errorMsg = showErrorMsg ? "服务器内部错误！\n"+ex.getMessage() : "服务器内部错误！";

        return new ResponseResult.Builder(ResponseStatus.FAILED).message(errorMsg).build();
    }

    @ExceptionHandler
    @ResponseBody
    public ResponseResult handleFormArgsException(FormArgsException ex) {

        ex.printStackTrace();

        String errorMsg = showErrorMsg ? ex.getMessage() : "服务器内部错误！";

        return new ResponseResult.Builder(ResponseStatus.FAILED).message(errorMsg).build();
    }
}
