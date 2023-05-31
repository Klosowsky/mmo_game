package com.to.backend.strategy;

import com.to.backend.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawForArcher implements ItemDrawStrategy{
    @Override
    public Item getRandomItem(List<Item> itemList) {
        List<Item> archerItems = new ArrayList<>();
        for(Item item : itemList){
            if(item.getRequiredClass().equals("archer")){
                archerItems.add(item);
            }
        }
        if(archerItems.size()==0){
            throw new IllegalArgumentException();
        }
        Random random = new Random();
        int randomItemIndex = random.nextInt(archerItems.size());
        return archerItems.get(randomItemIndex);
    }
}
