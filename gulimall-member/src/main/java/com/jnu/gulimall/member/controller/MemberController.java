package com.jnu.gulimall.member.controller;

import com.jnu.common.utils.PageUtils;
import com.jnu.common.utils.R;
import com.jnu.gulimall.member.entity.MemberEntity;
import com.jnu.gulimall.member.feign.CouponFeignService;
import com.jnu.gulimall.member.service.MemberService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Map;



/**
 * 会员
 *
 * @author ych
 * @email 2625856353@qq.com
 * @date 2022-05-04 20:10:58
 */
@RestController
@RequestMapping("member/member")
public class MemberController {
    @Resource
    private MemberService memberService;

    @Resource
    private CouponFeignService couponFeignService;

    @RequestMapping("/coupons")
    public R test(){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setNickname("张三");

        R member = couponFeignService.memberCoupons();
        return R.ok().put("member",memberEntity).put("coupons",member.get("coupons"));
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		MemberEntity member = memberService.getById(id);

        return R.ok().put("member", member);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MemberEntity member){
		memberService.save(member);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MemberEntity member){
		memberService.updateById(member);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		memberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
