package com.cqgs.app.business.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqgs.app.business.form.TestForm;
import com.cqgs.app.common.exception.FormArgsException;
import com.cqgs.app.common.trade.ResponseResult;
import com.cqgs.app.common.trade.ResponseStatus;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController extends BaseController {

    /**
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    /**
     * 测试webapi响应结果
     * @return
     */
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult hello() throws InterruptedException {
        Thread.sleep(3000);
        int[] arr = {1,2,3,4,5,6};
        return new ResponseResult.Builder(ResponseStatus.SUCCESS).message("ok！").content("data", "ok").content("list", arr).build();
    }

    /**
     * 测试全局异常拦截
     * @return
     */
    @RequestMapping("/testError")
    @ResponseBody
    public int testError(){
        return Integer.parseInt("error");
    }

    /**
     * 测试提交参数错误
     * @param form
     * @param result
     * @return
     * @throws FormArgsException
     */
    @RequestMapping("/testForm")
    @ResponseBody
    public ResponseResult testForm(@Valid TestForm form, BindingResult result) throws FormArgsException {

        if(result.hasErrors()){
            throw FormArgsException.formatFormArgsErrors(result);
        }

        return new ResponseResult.Builder(ResponseStatus.SUCCESS).message("ok！").build();
    }
	
}
