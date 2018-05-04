package com.taotao.service;


import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;


public interface ItemService {
    /**
     * 根据商品id获取商品信息
     * @param itemId
     * @return
     */
    TbItem getItemById(long itemId);

    /**
     * 分页查询商品信息
     * @param page
     * @param rows
     * @return
     */
    EasyUIDataGridResult getItemList(int page,int rows);

    /**
     * 根据商品id获取商品描述
     * @param itemId
     * @return
     */
    TbItemDesc getItemDescById(long itemId);

    /**
     * 添加商品
     * @param tbItem
     * @param desc
     * @return
     * @throws Exception
     */
    TaotaoResult createItem(TbItem tbItem,String desc) throws Exception;

}
