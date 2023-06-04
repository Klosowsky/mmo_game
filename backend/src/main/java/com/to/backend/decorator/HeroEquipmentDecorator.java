package com.to.backend.decorator;

import com.to.backend.model.Equipment;
import com.to.backend.model.Hero;
import com.to.backend.model.HeroStatistics;

public class HeroEquipmentDecorator extends Hero {

    Hero hero;
    public HeroEquipmentDecorator(Hero hero){
        this.hero = hero;
    }


    @Override
    public void heroDetails() {

    }

    @Override
    public void setHeroStatistics() {

    }

    @Override
    public HeroStatistics getHeroStatistics(){
        Equipment equipment = hero.getEquipment();
        HeroStatistics heroStatistics = new HeroStatistics();
        System.out.println("eeee");
        heroStatistics.setAgility(hero.getAgility()+equipment.getArmor().getBonusAgility()+equipment.getHelmet().getBonusAgility()+equipment.getWeapon().getBonusAgility());
        heroStatistics.setIntellect(hero.getIntellect()+equipment.getArmor().getBonusIntellect()+equipment.getHelmet().getBonusIntellect()+equipment.getWeapon().getBonusIntellect());
        heroStatistics.setStrength(hero.getStrength()+equipment.getArmor().getBonusStrength()+equipment.getHelmet().getBonusStrength()+equipment.getWeapon().getBonusStrength());
        return heroStatistics;
    }


    @Override
    public void printHeroStatistics() {

    }

    @Override
    public void levelUp() {

    }
}
