package com.jnu.gulimall.product.exception;

import com.jnu.common.exception.BizCodeeNUME;
import com.jnu.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

/**
 * [一句话描述该类的功能]
 *
 * @author : [游成鹤]
 * @version : [v1.0]
 * @createTime : [2022/8/11 11:30]
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.jnu.gulimall.product.controller")
public class GulimallExceptionControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e) {
        log.error("数据校验出现问题{},异常类型{}", e.getMessage(), e.getClass());
        BindingResult bindingResult = e.getBindingResult();
        HashMap<String, String> map = new HashMap<>();
        bindingResult.getFieldErrors().forEach(item -> {
            String defaultMessage = item.getDefaultMessage();
            String field = item.getField();
            map.put(field, defaultMessage);
        });
        return R.error(BizCodeeNUME.VAILD_EXCEPTION.getCode(),
                BizCodeeNUME.VAILD_EXCEPTION.getMsg()).put("data",
                map);
    }

    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable throwable) {

        return R.error(BizCodeeNUME.UNKNOW_EXCEPTION.getCode(),
                BizCodeeNUME.UNKNOW_EXCEPTION.getMsg());
    }
}