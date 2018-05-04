package com.taotao.search.mapper;

import com.taotao.common.pojo.SearchItem;

import java.util.List;

/**
 * 导入索引
 * Created by lenovo on 2018-04-24.
 */
public interface SearchItemMapper {

    //获取要导入到索引库中的数据
    List<SearchItem> getSearchItemList();
    //根据商品ID查询商品详情
    SearchItem getItemById(long itemId);
}
