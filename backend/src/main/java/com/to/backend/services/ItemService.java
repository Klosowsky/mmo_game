package com.to.backend.services;

import com.to.backend.model.Hero;
import com.to.backend.model.Item;
import com.to.backend.repository.HeroRepository;
import com.to.backend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public Item saveItem(Item item){
        return itemRepository.save(item);
    }

    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    public List<Item> getItemsByClass(String itemClass){
        return itemRepository.findAllByRequiredClass(itemClass);
    }

    public List<Item> getItemsByLevelAndClassAndType(int requiredLevel, String requiredClass, String itemType){
        return itemRepository.findAllByRequiredLevelLessThanAndRequiredClassAndItemType(requiredLevel,requiredClass,itemType);
    }





}
