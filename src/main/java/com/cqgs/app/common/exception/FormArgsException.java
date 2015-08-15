package com.cqgs.app.common.exception;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

/**
 * Created by fuda on 2015/2/5.
 */
public class FormArgsException extends Exception {
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public FormArgsException(String message) {
        super(message);
    }

    public static FormArgsException formatFormArgsErrors(BindingResult result){

        if(result == null){
            return new FormArgsException("");
        }

        StringBuilder stringBuilder = new StringBuilder("向接口提交的参数有误：\n");
        for(ObjectError item : result.getAllErrors()){

            stringBuilder.append(item.getDefaultMessage()).append("\n");
        }

        return new FormArgsException(stringBuilder.toString());
    }
}
