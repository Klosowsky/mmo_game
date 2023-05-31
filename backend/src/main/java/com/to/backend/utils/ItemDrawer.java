package com.to.backend.utils;

import com.to.backend.model.Hero;
import com.to.backend.model.Item;
import com.to.backend.strategy.DrawForArcher;
import com.to.backend.strategy.DrawForMage;
import com.to.backend.strategy.DrawForWarrior;
import com.to.backend.strategy.ItemDrawStrategy;

import java.util.List;

public class ItemDrawer {
    public static Item DrawItemForHero(List<Item> itemList, Hero hero){
        ItemDrawStrategy itemDrawStrategy;
        if(hero.getHeroClass().equals("mage")){
            itemDrawStrategy = new DrawForMage();
        }
        else if(hero.getHeroClass().equals("archer")){
            itemDrawStrategy = new DrawForArcher();
        }
        else if(hero.getHeroClass().equals("warrior")){
            itemDrawStrategy = new DrawForWarrior();
        }
        else{
            throw new NullPointerException();
        }
        return itemDrawStrategy.getRandomItem(itemList);
    }
}
