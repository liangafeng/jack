package com.usian.controller;

import com.usian.feign.ItemFeign;
import com.usian.pojo.TbItemCat;
import com.usian.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/backend/itemCategory")
public class ItemCatgoryController {
    @Autowired
    ItemFeign itemFeign;

    @RequestMapping("/selectItemCategoryByParentId")
     public Result selectItemCategoryByParentId (@RequestParam(
            defaultValue = "0") Long id){
        List<TbItemCat> list= this.itemFeign.selectItemCategoryByParentId(id);
        if (list == null ) {
            return Result.error("查无结果");
        }
        return Result.ok(list);
    }
}
