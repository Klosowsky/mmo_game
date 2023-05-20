package com.to.backend.builder;

import com.to.backend.model.Hero;

public class HeroBuilder {
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

    public Hero build(){
        return hero;
    }


}
