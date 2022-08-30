package com.jnu.gulimall.auth.feign;

import com.jnu.common.utils.R;
import com.jnu.gulimall.auth.vo.GiteeSocialUser;
import com.jnu.gulimall.auth.vo.UserLoginVo;
import com.jnu.gulimall.auth.vo.UserRegisterVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@FeignClient("gulimall-member")
public interface MemberFeignService {
    @PostMapping(value = "/member/member/register")
    R register(@RequestBody UserRegisterVo vo);

    @PostMapping(value = "/member/member/login")
    R login(@RequestBody UserLoginVo vo);

    @PostMapping(value = "/member/member/oauth2/login")
    R oauthLogin(@RequestBody GiteeSocialUser socialUser) throws Exception;
}
