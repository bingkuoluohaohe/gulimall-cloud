package com.jnu.gulimall.search.service;


import com.jnu.gulimall.search.vo.SearchParam;
import com.jnu.gulimall.search.vo.SearchResult;

/**
 * @author ych
 * @date 2022/09/17 18:06
 */
public interface MallSearchService {
    SearchResult search(SearchParam param);
}
