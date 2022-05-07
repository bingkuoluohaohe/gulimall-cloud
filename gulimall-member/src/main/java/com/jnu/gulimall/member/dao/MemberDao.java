package com.jnu.gulimall.member.dao;

import com.jnu.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author ych
 * @email 2625856353@qq.com
 * @date 2022-05-04 20:10:58
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
