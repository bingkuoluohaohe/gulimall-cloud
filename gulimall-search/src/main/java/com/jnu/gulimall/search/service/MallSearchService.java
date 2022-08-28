package com.jnu.gulimall.search.service;


import com.jnu.gulimall.search.vo.SearchParam;
import com.jnu.gulimall.search.vo.SearchResult;

/**
 * @author zr
 * @date 2021/11/17 18:06
 */
public interface MallSearchService {
    SearchResult search(SearchParam param);
}
