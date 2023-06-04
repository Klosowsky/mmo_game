package com.to.backend.model;

public class HeroWearItemRquest {
    private long HeroId;
    private long ItemId;

    public long getHeroId() {
        return HeroId;
    }

    public void setHeroId(long heroId) {
        HeroId = heroId;
    }

    public long getItemId() {
        return ItemId;
    }

    public void setItemId(long itemId) {
        ItemId = itemId;
    }
}
