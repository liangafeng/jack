package com.usian.controller;

import com.usian.pojo.TbItem;
import com.usian.service.ItemService;
import com.usian.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class ItemController {
    @Autowired
    ItemService itemService;

    /**
     * 根据ID迷糊查询
     * @param itemId
     * @return
     */
    @RequestMapping("/service/item/selectItemInfo")
    public TbItem findById (@RequestParam("itemId")Long itemId){
        TbItem tbItem=this.itemService.findById(itemId);
        return tbItem;
    }

    /**
     * 分页自定义查询
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/service/selectTbItemAllByPage")
    public PageResult findPage(@RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "rows",defaultValue = "2") Integer rows){
        return this.itemService.findPage(page, rows);
    }
    @RequestMapping("/service/item/insertTbItem")
    public Integer insertTbItem(@RequestBody TbItem tbItem, @RequestParam("desc") String desc, @RequestParam("itemParams") String itemParams){
        return this.itemService.insertTbItem(tbItem, desc, itemParams);
    }
    @RequestMapping("/service/item/preUpdateItem")
   public Map<String, Object> preUpdateItem(@RequestParam("itemId") Long itemId){
        return this.itemService.preUpdateItem(itemId);
    }
    @RequestMapping("/service/item/updateTbItem")
    public Integer updateTbItem(@RequestBody TbItem tbItem, @RequestParam("desc") String desc, @RequestParam("itemParams") String itemParams){
        return this.itemService.updateTbItem(tbItem, desc, itemParams);
    };
}
