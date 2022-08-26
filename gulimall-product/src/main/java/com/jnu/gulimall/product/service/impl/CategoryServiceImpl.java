package com.jnu.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jnu.common.utils.PageUtils;
import com.jnu.common.utils.Query;
import com.jnu.gulimall.product.dao.CategoryDao;
import com.jnu.gulimall.product.entity.CategoryEntity;
import com.jnu.gulimall.product.service.CategoryBrandRelationService;
import com.jnu.gulimall.product.service.CategoryService;
import com.jnu.gulimall.product.vo.Catalog2Vo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Resource
    private CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        //1、查出所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);
        //2、组装成父子的树形结构
        //2.1）、找到所有的一级分类
        return entities.stream().filter
                        (categoryEntity -> categoryEntity.getParentCid() == 0)
                .peek((menu) -> menu.setChildren(getChildrens(menu, entities))).
                sorted(Comparator.comparingInt
                        (menu -> (menu.getSort() == null ? 0 : menu.getSort()))
                ).collect(Collectors.toList());
    }

    //递归查找所有菜单的子菜单
    private List<CategoryEntity> getChildrens(CategoryEntity root, List<CategoryEntity> all) {

        return all.stream().filter
                        (categoryEntity -> Objects.equals(categoryEntity.getParentCid(), root.getCatId()))
                .peek(categoryEntity -> {//1、找到子菜单
                    categoryEntity.setChildren(getChildrens(categoryEntity, all));
                }).sorted(
                        Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort()))
                ).collect(Collectors.toList());
    }

    @Override
    public void removeMenuByids(List<Long> asList) {
        // TODO 1.检查当前删除的菜单，是否被别的地方引用
        baseMapper.deleteBatchIds(asList);
    }

    @Override
    public Long[] findCatelogPath(Long id) {
        List<Long> paths = new ArrayList<>();
        findParentPath(id, paths);
        return paths.toArray(new Long[0]);
    }

    /**
     * 级联更新所有关联数据
     */
    @Override
    @Transactional
    public void updateCascade(CategoryEntity category) {
        this.updateById(category);
        categoryBrandRelationService.updateCategory(category.getCatId(), category.getName());
    }

    //    @Cacheable(value = "category",key = "#root.method.name",sync = true)
    @Override
    public List<CategoryEntity> getLevel1Categorys() {
        return baseMapper.selectList(new QueryWrapper<CategoryEntity>().eq("parent_cid", 0));
    }

    @Override
    public Map<String, List<Catalog2Vo>> getCatalogJson() {
        //1.加入缓存逻辑
//        String catelogJSON = redisTemplate.opsForValue().get("catelogJSON");
//        if (StringUtils.isEmpty(catelogJSON)){
//            //2.缓存中没有,查询数据库
//            System.out.println("缓存未命中.....查询数据库");
//            Map<String, List<Catalog2Vo>> catalogJsonFromDb = getCatalogJsonFromDbWithRedisLock();
//            //3.查到的数据再放入缓存,将对象转为json放在缓存中
//        }
//        System.out.println("缓存命中.....直接返回");
//        Map<String, List<Catalog2Vo>> result = JSON.parseObject(catelogJSON, new TypeReference<Map<String, List<Catalog2Vo>>>() {
//        });

        List<CategoryEntity> level1Categorys = getLevel1Categorys();

        Map<String, List<Catalog2Vo>> listMap = level1Categorys.stream().collect(Collectors.toMap(k -> k.getCatId().toString(), v -> {
            List<CategoryEntity> entities = baseMapper.selectList(new QueryWrapper<CategoryEntity>().eq("parent_cid", v.getCatId()));
            List<Catalog2Vo> list = null;
            if (entities != null) {
                list = entities.stream().map(l2 -> {
                    Catalog2Vo catalog2Vo = new Catalog2Vo(v.getCatId().toString(), null, l2.getCatId().toString(), l2.getName());
                    List<CategoryEntity> categoryEntities = baseMapper.selectList(new QueryWrapper<CategoryEntity>().eq("parent_cid", l2.getCatId()));
                    if (categoryEntities != null) {
                        List<Catalog2Vo.Catalog3Vo> collect = categoryEntities.stream().map(l3 -> {
                            Catalog2Vo.Catalog3Vo catalog3Vo = new Catalog2Vo.Catalog3Vo(l2.getCatId().toString(),l3.getCatId().toString(),l3.getName());

                            return catalog3Vo;
                        }).collect(Collectors.toList());
                        catalog2Vo.setCatalog3List(collect);
                    }

                    return catalog2Vo;
                }).collect(Collectors.toList());
            }
            return list;
        }));

        return listMap;
    }

    private void findParentPath(Long categoryId, List<Long> paths) {
        CategoryEntity category = this.getById(categoryId);
        paths.add(0, categoryId);
        if (category.getParentCid() != 0) {
            findParentPath(category.getParentCid(), paths);
        }
    }
}

