package com.taotao.search.service;

import com.taotao.common.pojo.TaotaoResult;

/**
 * Created by lenovo on 2018-04-25.
 */
public interface SearchItemService {

    //将数据导入到索引库
    TaotaoResult importItemsToIndex();
}
