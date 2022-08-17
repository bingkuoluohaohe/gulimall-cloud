package com.jnu.gulimall.product;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jnu.gulimall.product.entity.BrandEntity;
import com.jnu.gulimall.product.service.BrandService;
import com.jnu.gulimall.product.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class GulimallProductApplicationTests {

    @Resource
    private BrandService brandService;

    @Resource
    private CategoryService categoryService;

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

    @Test
    public void testFindCatelogPath(){
        Long[] catelogPath = categoryService.findCatelogPath(225L);
        System.out.println(Arrays.toString(catelogPath));
    }
}
