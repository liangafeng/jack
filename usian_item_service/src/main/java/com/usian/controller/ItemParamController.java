package com.usian.controller;

import com.usian.pojo.TbItemParam;
import com.usian.service.ItemParamService;
import com.usian.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemParamController {
    @Autowired
    ItemParamService itemParamService;

    /**
     * 根据商品分类 ID 查询规格参数模板
     */
    @RequestMapping("/service/itemParam/selectItemParamByItemCatId")
    public TbItemParam selectItemParamByItemCatId(@PathVariable(value = "itemCatId") Long itemCatId) {
        TbItemParam tbItemParams = this.itemParamService.selectItemParamByItemCatId(itemCatId);
        return tbItemParams;
    }
    @RequestMapping("/service/itemParam/selectItemParamAll")
    public PageResult selectItemParamAll(Integer page, Integer rows){
       return this.itemParamService.selectItemParamAll(page, rows);
    }
}