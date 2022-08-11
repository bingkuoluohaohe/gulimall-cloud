package com.jnu.gulimall.product;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jnu.gulimall.product.entity.BrandEntity;
import com.jnu.gulimall.product.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class GulimallProductApplicationTests {

    @Resource
    private BrandService brandService;

    @Test
    public void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
//        brandEntity.setDescript("HUAWEI");
//        brandEntity.setName("华为");
//        brandService.save(brandEntity);
//        System.out.println("保存成功");
        brandEntity.setBrandId(1l);
        brandEntity.setDescript("huawei");
        brandService.updateById(brandEntity);
        List<BrandEntity> list = brandService.list(new LambdaQueryWrapper<BrandEntity>().like(BrandEntity::getDescript, "huawei"));
        for (BrandEntity entity : list) {
            System.out.println(entity);
        }
    }

}
