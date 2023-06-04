package com.to.backend.model;

import com.to.backend.builder.HeroBuilder;

public class HeroProxy extends Hero {

    Hero hero;
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
    public HeroProxy(){
        super();
    }

    public HeroProxy(Hero hero){
        super();
        this.hero = hero;
    }


    public Hero toValidHero(){
        Hero validHero;
        System.out.println("clas = "+hero.getHeroClass());
        if(hero.getHeroClass().equals("mage")){
            validHero = new Mage();
        }
        else if(hero.getHeroClass().equals("archer")){
            validHero = new Archer();
        }
        else if(hero.getHeroClass().equals("warrior")){
            validHero = new Warrior();
        }
        else{
            System.out.println("nullik here");
            validHero = null;
        }
        HeroBuilder heroBuilder = new HeroBuilder(validHero);

        return heroBuilder.setHeroClass(hero.getHeroClass()).setAgility(hero.getAgility()).setIntellect(hero.getIntellect()).setStrength(hero.getStrength()).
        setName(hero.getHeroName()).setId(hero.getHeroId()).setLevel(hero.getLevel()).setExp(hero.getExp()).setNeededExp(hero.getNeededExp()).setEquipment(hero.getEquipment()).build();
    }

}
