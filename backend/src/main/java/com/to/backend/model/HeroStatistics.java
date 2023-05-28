package com.to.backend.model;

public class HeroStatistics {
    private int agility;
    private int strength;
    private int intellect;

    public HeroStatistics(){}

    public HeroStatistics(int agility, int strength, int intellect) {
        this.agility = agility;
        this.strength = strength;
        this.intellect = intellect;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }
}
