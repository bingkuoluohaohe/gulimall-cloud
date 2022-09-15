package com.jnu.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jnu.common.utils.PageUtils;
import com.jnu.gulimall.product.entity.BrandEntity;

import java.util.List;
import java.util.Map;

/**
 * 品牌
 *
 * @author ych
 * @email 2625856353@qq.com
 * @date 2022-05-06 15:47:54
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void updateDetail(BrandEntity brand);

    List<BrandEntity> getBrandsByIds(List<Long> brandIds);

    void updateStatus(BrandEntity brand);

}

