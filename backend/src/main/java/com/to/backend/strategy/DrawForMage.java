package com.to.backend.strategy;

import com.to.backend.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawForMage implements ItemDrawStrategy{
    @Override
    public Item getRandomItem(List<Item> itemList) {
        List<Item> mageItems = new ArrayList<>();
        for(Item item : itemList){
            if(item.getRequiredClass().equals("mage")){
                mageItems.add(item);
            }
        }
        if(mageItems.size()==0){
            throw new IllegalArgumentException();
        }
        Random random = new Random();
        int randomItemIndex = random.nextInt(mageItems.size());
        return mageItems.get(randomItemIndex);
    }
}
