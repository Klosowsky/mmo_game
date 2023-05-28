package com.to.backend.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;

@Table(name="Heroes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="hero_class", discriminatorType = DiscriminatorType.STRING)
@JsonDeserialize(as = HeroProxy.class)
/*@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "heroClass")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Archer.class, name = "archer"),
        @JsonSubTypes.Type(value = Mage.class, name = "mage"),
        @JsonSubTypes.Type(value = Warrior.class, name = "warrior")
})*/

@Entity
public abstract class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long heroId;
    protected int level=1;
    protected int agility=1;
    protected int strength=1;
    protected int intellect=1;
    @Column(name = "heroName", unique = true, nullable = false)
    protected String heroName;
    @Column(name="hero_class", insertable = false, updatable = false)
    protected String heroClass;
    protected int exp=0;
    protected int neededExp=3;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipment_id")
    protected Equipment equipment;
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

    public int getExp() {
        return exp;
    }
    public void increaseExp(){
        exp++;
        if(exp>=neededExp){
            levelUp();
            neededExp+=3;
        }
    }
    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getNeededExp() {
        return neededExp;
    }

    public void setNeededExp(int neededExp) {
        this.neededExp = neededExp;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public HeroStatistics getHeroStatistics(){
        return new HeroStatistics(agility,strength,intellect);
    }

    public abstract void levelUp();

}
