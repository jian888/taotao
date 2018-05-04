package com.taotao.search.service;

import com.taotao.common.pojo.SearchResult;

/**
 * Created by lenovo on 2018-04-25.
 */
public interface SearchService {
    //搜索
    SearchResult search(String queryString,int page,int rows) throws Exception;
}
