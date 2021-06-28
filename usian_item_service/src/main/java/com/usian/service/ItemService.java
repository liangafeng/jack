package com.usian.service;

import com.usian.pojo.TbItem;
import com.usian.utils.PageResult;

import java.util.Map;

public interface ItemService {
//    根据id查询
    TbItem findById(Long itemId);
//    分页查询商品信息
    PageResult findPage(Integer rows,Integer page);
//
    Integer insertTbItem(TbItem tbItem, String desc, String itemParams);

    Map<String, Object> preUpdateItem(Long itemId);

    Integer updateTbItem(TbItem tbItem, String desc, String itemParams);

}
