package com.to.backend.strategy;

import com.to.backend.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawForWarrior implements ItemDrawStrategy{
    @Override
    public Item getRandomItem(List<Item> itemList) {
        List<Item> warriorItems = new ArrayList<>();
        for(Item item : itemList){
            if(item.getRequiredClass().equals("warrior")){
                warriorItems.add(item);
            }
        }
        if(warriorItems.size()==0){
            throw new IllegalArgumentException();
        }
        Random random = new Random();
        int randomItemIndex = random.nextInt(warriorItems.size());
        return warriorItems.get(randomItemIndex);
    }
}
