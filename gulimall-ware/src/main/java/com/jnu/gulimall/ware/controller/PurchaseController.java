package com.jnu.gulimall.ware.controller;

import com.jnu.common.utils.PageUtils;
import com.jnu.common.utils.R;
import com.jnu.gulimall.ware.entity.PurchaseEntity;
import com.jnu.gulimall.ware.service.PurchaseService;
import com.jnu.gulimall.ware.vo.MergeVo;
import com.jnu.gulimall.ware.vo.PurchaseDoneVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * 采购信息
 *
 * @author ych
 * @email 2625856353@qq.com
 * @date 2022-05-04 20:38:25
 */
@RestController
@RequestMapping("ware/purchase")
public class PurchaseController {
    @Resource
    private PurchaseService purchaseService;

    /**
     * 完成采购单
     */
    ///ware/purchase/done
    @PostMapping("/done")
    public R finish(@RequestBody PurchaseDoneVo doneVo) {

        purchaseService.done(doneVo);

        return R.ok();
    }

    /**
     * 领取采购单
     *
     */
    @PostMapping("/received")
    public R received(@RequestBody List<Long> ids) {

        purchaseService.received(ids);

        return R.ok();
    }

    ///ware/purchase/unreceive/list
    ///ware/purchase/merge
    @PostMapping("/merge")
    public R merge(@RequestBody MergeVo mergeVo) {

        purchaseService.mergePurchase(mergeVo);
        return R.ok();
    }

    @RequestMapping("/unreceive/list")
    public R unreceivelist(@RequestParam Map<String, Object> params) {
        PageUtils page = purchaseService.queryPageUnreceivePurchase(params);

        return R.ok().put("page", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = purchaseService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        PurchaseEntity purchase = purchaseService.getById(id);

        return R.ok().put("purchase", purchase);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PurchaseEntity purchase) {
        purchaseService.save(purchase);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PurchaseEntity purchase) {
        purchaseService.updateById(purchase);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        purchaseService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
