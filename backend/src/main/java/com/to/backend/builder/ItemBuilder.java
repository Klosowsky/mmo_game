package com.to.backend.builder;

import com.to.backend.model.Hero;
import com.to.backend.model.Item;

public class ItemBuilder implements builder<Item> {
    private Item item;

    public ItemBuilder(Item item){
        this.item=item;
    }

    public ItemBuilder setId(long id){
        item.setId(id);
        return this;
    }

    public ItemBuilder setRequiredLevel(int level){
        item.setRequiredLevel(level);
        return this;
    }

    public ItemBuilder setBonusAgility(int value){
        item.setBonusAgility(value);
        return this;
    }

    public ItemBuilder setBonusStrength(int value){
        item.setBonusStrength(value);
        return this;
    }

    public ItemBuilder setBonusIntellect(int value){
        item.setBonusIntellect(value);
        return this;
    }

    public ItemBuilder setRequiredClass(String requiredClass){
        item.setRequiredClass(requiredClass);
        return this;
    }

    public ItemBuilder setItemType(String itemType){
        item.setItemType(itemType);
        return this;
    }

    public ItemBuilder setItemName(String itemName){
        item.setItemName(itemName);
        return this;
    }

    public Item build(){
        return item;
    }


}
