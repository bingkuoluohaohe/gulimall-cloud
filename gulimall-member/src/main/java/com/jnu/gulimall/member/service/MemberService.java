package com.jnu.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jnu.common.utils.PageUtils;
import com.jnu.gulimall.member.entity.MemberEntity;
import com.jnu.gulimall.member.exception.PhoneException;
import com.jnu.gulimall.member.exception.UsernameException;
import com.jnu.gulimall.member.vo.GiteeSocialUser;
import com.jnu.gulimall.member.vo.MemberUserLoginVo;
import com.jnu.gulimall.member.vo.MemberUserRegisterVo;

import java.util.Map;

/**
 * 会员
 *
 * @author ych
 * @email 2625856353@qq.com
 * @date 2022-05-04 20:10:58
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 用户登录
     */
    MemberEntity login(MemberUserLoginVo vo);

    /**
     * 社交用户的登录
     */
    MemberEntity login(GiteeSocialUser socialUser) throws Exception;

    /**
     * 判断邮箱是否重复
     */
    void checkPhoneUnique(String phone) throws PhoneException;

    /**
     * 判断用户名是否重复
     */
    void checkUserNameUnique(String userName) throws UsernameException;


    void register(MemberUserRegisterVo vo);
}

