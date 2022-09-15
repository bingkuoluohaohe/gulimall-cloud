package com.jnu.gulimall.product;

import com.jnu.gulimall.product.entity.CategoryEntity;
import com.jnu.gulimall.product.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * [一句话描述该类的功能]
 *
 * @author : [游成鹤]
 * @version : [v1.0]
 * @date  : [2022/9/11 21:23]
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CategoryServiceTest {

    @Resource
    private CategoryService categoryService;

    @Test
    public void testList() {
        List<CategoryEntity> list = categoryService.list();
        list.forEach(System.out::println);
    }

    @Test
    public void testGetById() {
        categoryService.getById(1);
    }

    @Test
    public void testListWithTree() {
        List<CategoryEntity> list = categoryService.listWithTree();
        list.forEach(System.out::println);
    }

    @Test
    public void testRemoveMenuByids() {
        Long[] ids = {};
        categoryService.removeMenuByids(ids);
    }

    @Test
    public void testUpdateCascade() {
        CategoryEntity category = new CategoryEntity();
        category.setCatId(1444L);
        category.setName("手机");
        category.setIcon("http://codekenan.icu");
        category.setProductUnit("个");
        categoryService.updateCascade(category);
    }

    @Test
    public void testUpdateSort() {
        CategoryEntity category1 = new CategoryEntity();
        category1.setCatId(1444L);
        category1.setParentCid(1L);
        category1.setCatLevel(2);
        category1.setSort(2);
        CategoryEntity category2 = new CategoryEntity();
        category2.setCatId(1445L);
        category2.setParentCid(2L);
        category2.setCatLevel(3);
        category2.setSort(4);
        CategoryEntity[] list = {category1,category2};
        categoryService.updateSort(list);
    }
}