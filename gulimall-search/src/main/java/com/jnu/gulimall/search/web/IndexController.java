package com.jnu.gulimall.search.web;

import com.jnu.gulimall.search.service.MallSearchService;
import com.jnu.gulimall.search.vo.SearchParam;
import com.jnu.gulimall.search.vo.SearchResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author ych
 * @date 2022/9/15 15:23
 */
@Controller
public class IndexController {

    @Resource
    private MallSearchService mallSearchService;

    @GetMapping(value = {"/list.html", "/"})
    public String listPage(SearchParam param, Model model, HttpServletRequest request) {

        param.set_queryString(request.getQueryString());
        SearchResult result = mallSearchService.search(param);
        model.addAttribute("result", result);
        return "list";
    }
}
