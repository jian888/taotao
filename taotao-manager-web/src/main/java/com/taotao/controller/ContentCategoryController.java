package com.taotao.controller;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.taotao.content.service.ContentCategoryService;

import java.util.List;

/**
 * Created by lenovo on 2018-04-19.
 */
@Controller
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    @RequestMapping("/content/category/list")
    @ResponseBody
    public List<EasyUITreeNode> getContentCategoryList(@RequestParam(name="id",defaultValue="0") Long parentId){
        List<EasyUITreeNode> list = contentCategoryService.getContentCategoryList(parentId);
        return list;
    }

    @RequestMapping("/content/category/create")
    @ResponseBody
    public TaotaoResult addContentCategory(Long parentId,String name){
        TaotaoResult taotaoResult = contentCategoryService.addContentCategory(parentId,name);
        return taotaoResult;
    }

    @RequestMapping("/content/category/update")
    @ResponseBody
    public TaotaoResult updateContentCategory(Long id,String name){
        TaotaoResult taotaoResult = contentCategoryService.updateContentCategory(id, name);
        return taotaoResult;
    }

    @RequestMapping("/content/category/delete/")
    @ResponseBody
    public TaotaoResult deleteContentCategory(Long id){
        TaotaoResult taotaoResult = contentCategoryService.deleteContentCategory(id);
        return taotaoResult;
    }
}
