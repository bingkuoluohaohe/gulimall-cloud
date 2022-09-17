package com.jnu.gulimall.controller;

import com.jnu.common.utils.R;
import com.jnu.gulimall.component.SmsComponent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author ych
 * @date 2022/09/29 18:28
 */
@RestController
@RequestMapping(value = "/sms")
public class SmsSendController {

    @Resource
    private SmsComponent smsComponent;

    /**
     * 提供给别的服务进行调用
     *
     * @param phone
     * @param code
     * @return
     */
    @GetMapping(value = "/sendCode")
    public R sendCode(@RequestParam("phone") String phone, @RequestParam("code") String code) {
        //发送验证码
        boolean b = smsComponent.sendCode(phone, code);
        if (b) {
            return R.ok();
        } else {
            return R.error();
        }
    }
}
