package com.to.backend.strategy;

import com.to.backend.model.Item;

import java.util.List;

public interface ItemDrawStrategy {
    Item getRandomItem(List<Item> itemList);
}
