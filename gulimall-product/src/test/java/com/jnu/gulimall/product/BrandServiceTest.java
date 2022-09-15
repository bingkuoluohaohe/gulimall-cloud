package com.jnu.gulimall.product;

import com.jnu.gulimall.product.entity.BrandEntity;
import com.jnu.gulimall.product.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * [一句话描述该类的功能]
 *
 * @author : [游成鹤]
 * @version : [v1.0]
 * @date : [2022/9/12 20:10]
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BrandServiceTest {

    @Resource
    private BrandService brandService;

    @Test
    public void testUpdateStatus() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setBrandId(1L);
        brandEntity.setShowStatus(1);
        brandService.updateStatus(brandEntity);
    }

}