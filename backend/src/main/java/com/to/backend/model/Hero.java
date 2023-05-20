package com.to.backend.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;

@Table(name="Heroes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonDeserialize(as = HeroProxy.class)
@DiscriminatorColumn(name="hero_class")
@Entity

public abstract class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long heroId;
    protected int level=1;
    int agility=1;
    int strength=1;
    int intellect=1;
    String heroName;
    @Column(name="hero_class", insertable = false, updatable = false)
    protected String heroClass;
    public Hero(){
        setHeroStatistics();
    }
    public abstract void heroDetails();

    public abstract void setHeroStatistics();
    public abstract void printHeroStatistics();

    public long getHeroId() {
        return heroId;
    }

    public void setHeroId(long heroId) {
        this.heroId = heroId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }
}
