package com.jnu.gulimall.search.service;

import com.jnu.common.to.es.SkuEsModel;

import java.io.IOException;
import java.util.List;

/**
 * @author zr
 * @date 2021/10/26 13:50
 */
public interface ProductSaveService {
    boolean productStatusUp(List<SkuEsModel> skuEsModels) throws IOException;
}