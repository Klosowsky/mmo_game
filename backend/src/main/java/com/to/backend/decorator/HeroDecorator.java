package com.to.backend.decorator;

import com.to.backend.model.Hero;
import com.to.backend.model.HeroStatistics;

public abstract class HeroDecorator extends Hero {
    Hero hero;
    public HeroDecorator(Hero hero){
        this.hero = hero;
    }

    @Override
    public HeroStatistics getHeroStatistics(){
        return hero.getHeroStatistics();
    }
}
