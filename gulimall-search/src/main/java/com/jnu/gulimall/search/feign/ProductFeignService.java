package com.jnu.gulimall.search.feign;

import com.jnu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient("gulimall-product")
public interface ProductFeignService {
    // 可以以这个为例，放入了缓存中
    @GetMapping("/product/attr/info/{attrId}")
    R attrInfo(@PathVariable("attrId") Long attrId);

    /**
     * 远程调用的数据可以放入缓存中
     */
    @GetMapping("/product/brand/infos")
    R brandsInfo(@RequestParam("brandIds") List<Long> brandIds);
}
