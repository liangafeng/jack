package com.usian.controller;

import com.usian.feign.ItemFeign;
import com.usian.pojo.TbItem;
import com.usian.utils.PageResult;
import com.usian.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/backend/item")
public class ItemController {
    @Autowired
    private ItemFeign itemServiceFeign;

    /**
     * 查询商品基本信息
     */
    @RequestMapping("/selectItemInfo")
    public Result selectItemInfo(Long itemId) {
        TbItem tbItem = itemServiceFeign.findById(itemId);
        if (tbItem != null) {
            return Result.ok(tbItem);
        }
        return Result.error("查无结果");
    }

    @RequestMapping("/selectTbItemAllByPage")
    public Result selectTbItemAllByPage(@RequestParam(value = "page",defaultValue = "1") Integer page, @RequestParam(value = "rows",defaultValue = "2") Integer rows) {
        PageResult pageResult = itemServiceFeign.findPage(page, rows);
        if (pageResult.getResult() != null && pageResult.getResult().size() > 0) {
            return Result.ok(pageResult);
        }
        return Result.error("查询失败");
    }
    @RequestMapping("/insertTbItem")
    public Result insertTbItem(TbItem tbItem, @RequestParam("desc") String desc,@RequestParam("itemParams") String itemParams){
       Integer result= itemServiceFeign.insertTbItem(tbItem,desc,itemParams);
        if(result==3){
            return Result.ok();
        }
        return Result.error("添加失败");
    }
    /**
     * 根据itemId回显商品信息
     * @param itemId
     * @return
     */
    @RequestMapping("/preUpdateItem")
    public Result preUpdateItem(Long itemId){
        Map<String,Object> map = itemServiceFeign.preUpdateItem(itemId);
        if(map.size()>0){
            return Result.ok(map);
        }
        return Result.error("查无结果");
    }
    @RequestMapping("/updateTbItem")
    public Result updateTbItem(TbItem tbItem, @RequestParam("desc") String desc,@RequestParam("itemParams") String itemParams){
        Integer result=  itemServiceFeign.updateTbItem(tbItem, desc, itemParams);
        if(result!=3){
            return Result.error("修改失败");
        }
        return Result.ok();
    }
}