package com.to.backend.controller;


import com.to.backend.model.Hero;
import com.to.backend.model.HeroProxy;
import com.to.backend.model.Item;
import com.to.backend.model.ItemProxy;
import com.to.backend.services.HeroService;
import com.to.backend.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @RequestMapping("/save")
    public ResponseEntity<Item> saveOrUpdate(@RequestBody ItemProxy itemProxy){
        try{
            Item item = itemProxy.toValidItem();
            return ResponseEntity.ok(itemService.saveItem(item));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping("/removeitem")
    public ResponseEntity<Item> removeItem(@RequestBody Item itemRequest){
        try{
            return ResponseEntity.ok(itemService.removeItem(itemRequest.getId()));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping("/getbyclass")
    public ResponseEntity<List<Item>> getItemsByClass(@RequestBody Item item){
        try{

            return ResponseEntity.ok(itemService.getItemsByClass(item.getRequiredClass()));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @RequestMapping("/getallowed")
    public ResponseEntity<List<Item>> getItemsByLevelAndClassAndType(@RequestBody Item item){
        try{
            return ResponseEntity.ok(itemService.getItemsByLevelAndClassAndType(item.getRequiredLevel()+1,item.getRequiredClass(),item.getItemType()));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
