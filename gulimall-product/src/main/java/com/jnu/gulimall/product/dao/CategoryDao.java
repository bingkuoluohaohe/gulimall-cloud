package com.jnu.gulimall.product.dao;

import com.jnu.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author ych
 * @email 2625856353@qq.com
 * @date 2022-05-06 15:47:52
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
