package com.gyx.controller;

import com.alibaba.fastjson.JSON;
import com.gyx.entity.Item;
import com.gyx.repostory.ItemRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author Admin
 * @description Created by IntelliJ IDEA.
 * @date 2019/4/12
 */
@RestController
public class ItemController {

    @Autowired
    ItemRepostory itemRepostory;

    @RequestMapping(value = {"save"})
    public void save(){
        Item item = new Item(1L,"1","1","1",1.0,"1");
        itemRepostory.save(item);
    }

    @RequestMapping(value = {"get"})
    @ResponseBody
    public String get(){
        Optional<Item> item = itemRepostory.findById(1L);
        Item item1 = item.get();
        return JSON.toJSONString(item1);
    }

}
