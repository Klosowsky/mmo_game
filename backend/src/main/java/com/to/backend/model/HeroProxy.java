package com.to.backend.model;

import com.to.backend.builder.HeroBuilder;

public class HeroProxy extends Hero {
    @Override
    public void heroDetails() {
        System.out.println("I am template");
    }

    @Override
    public void setHeroStatistics() {
        strength=1;
        intellect=1;
        agility=1;
    }

    @Override
    public void printHeroStatistics() {

    }

    @Override
    public void levelUp() {

    }

    Hero hero;
    public Hero toValidHero(){
        System.out.println("clas = "+this.getHeroClass());
        if(this.getHeroClass().equals("mage")){
            hero = new Mage();
        }
        else if(this.getHeroClass().equals("archer")){
            hero = new Archer();
        }
        else if(this.getHeroClass().equals("warrior")){
            hero = new Warrior();
        }
        else{
            System.out.println("nullik here");
            hero = null;
        }
        HeroBuilder heroBuilder = new HeroBuilder(hero);

        return heroBuilder.setHeroClass(this.getHeroClass()).setAgility(this.getAgility()).setIntellect(this.getIntellect()).setStrength(this.getStrength()).
        setName(this.getHeroName()).setId(this.getHeroId()).setLevel(this.getLevel()).build();
    }

}
