package com.jnu.gulimall.member.exception;

/**
 * @author zr
 * @date 2021/11/30 11:02
 */
public class PhoneException extends RuntimeException {
    public PhoneException() {
        super("存在相同的手机号");
    }
}
