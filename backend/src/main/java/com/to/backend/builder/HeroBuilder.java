package com.to.backend.builder;

import com.to.backend.model.Equipment;
import com.to.backend.model.Hero;
import com.to.backend.model.Item;

public class HeroBuilder  implements builder<Hero> {
    Hero hero;
    public HeroBuilder(Hero hero){
        this.hero=hero;
    }
    public HeroBuilder setName(String name){
        hero.setHeroName(name);
        return this;
    }

    public HeroBuilder setAgility(int value){
        hero.setAgility(value);
        return this;
    }

    public HeroBuilder setStrength(int value){
        hero.setStrength(value);
        return this;
    }

    public HeroBuilder setIntellect(int value){
        hero.setIntellect(value);
        return this;
    }

    public HeroBuilder setHeroClass(String heroClass){
        hero.setHeroClass(heroClass);
        return this;
    }

    public HeroBuilder setLevel(int level){
        hero.setLevel(level);
        return this;
    }

    public HeroBuilder setId(long id){
        hero.setHeroId(id);
        return this;
    }

    public HeroBuilder setExp(int exp){
        hero.setExp(exp);
        return this;
    }

    public HeroBuilder setNeededExp(int neededExp){
        hero.setNeededExp(neededExp);
        return this;
    }

    public HeroBuilder setEquipment(Equipment equipment){
        hero.setEquipment(equipment);
        return this;
    }


    public Hero build(){
        return hero;
    }




}
