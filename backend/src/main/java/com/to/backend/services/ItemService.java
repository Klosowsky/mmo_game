package com.to.backend.services;

import com.to.backend.model.Hero;
import com.to.backend.model.Item;
import com.to.backend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Item getItemById(Long id){
        return itemRepository.findById(id).orElseThrow(NullPointerException::new);
    }
    public List<Item> getItemsByLevelAndClassAndType(int requiredLevel, String requiredClass, String itemType){
        return itemRepository.findAllByRequiredLevelLessThanAndRequiredClassAndItemType(requiredLevel,requiredClass,itemType);
    }

    public Item removeItem(long id){
        Item item = getItemById(id);
        itemRepository.deleteById(id);
        return item;
    }





}
