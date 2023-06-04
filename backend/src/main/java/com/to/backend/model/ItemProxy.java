package com.to.backend.model;

import com.to.backend.builder.ItemBuilder;

public class ItemProxy extends Item{


    public Item toValidItem(){
        Item item;
        System.out.println("clas = "+this.getItemType());
        if(this.getItemType().equals("armor")){
            item = new Armor();
        }
        else if(this.getItemType().equals("weapon")){
            item = new Weapon();
        }
        else if(this.getItemType().equals("helmet")){
            item = new Helmet();
        }
        else{
            System.out.println("nullik here");
            item = null;
        }

        ItemBuilder itemBuilder = new ItemBuilder(item);
        return itemBuilder.setItemName(this.getItemName()).setId(this.getId()).setItemType(this.getItemType()).setBonusAgility(this.getBonusAgility()).setBonusIntellect(this.getBonusIntellect()).setBonusStrength(this.getBonusStrength()).setRequiredLevel(this.getRequiredLevel()).setItemName(this.getItemName()).setRequiredClass(this.getRequiredClass()).build();
    }
}
