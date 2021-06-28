package com.usian.feign;


import com.usian.pojo.TbItem;
import com.usian.pojo.TbItemCat;
import com.usian.pojo.TbItemParam;
import com.usian.utils.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value = "usian-item-service")
public interface ItemFeign {
    @RequestMapping("/service/item/selectItemInfo")
    TbItem findById (@RequestParam("itemId") long itemId);


    @RequestMapping("/service/selectTbItemAllByPage")
     PageResult findPage(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows);
//根据父ID查询商品目录
     @RequestMapping("/service/itemCategory/selectItemCategoryByParentId")
    List<TbItemCat> selectItemCategoryByParentId(@RequestParam("id")Long id);
     
    @RequestMapping("/service/itemParam/selectItemParamByItemCatId")
    TbItemParam selectItemParamByItemCatId(@RequestParam("itemCatId")Long itemCatId);

    @RequestMapping("/service/item/insertTbItem")
    Integer insertTbItem(@RequestBody TbItem tbItem, @RequestParam("desc") String desc, @RequestParam("itemParams") String itemParams);
    @RequestMapping("/service/item/preUpdateItem")
    Map<String, Object> preUpdateItem(@RequestParam("itemId") Long itemId);
    @RequestMapping("/service/item/updateTbItem")
    Integer updateTbItem(@RequestBody TbItem tbItem, @RequestParam("desc") String desc, @RequestParam("itemParams") String itemParams);
    @RequestMapping("/service/itemParam/selectItemParamAll")
    PageResult selectItemParamAll(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows);
}
