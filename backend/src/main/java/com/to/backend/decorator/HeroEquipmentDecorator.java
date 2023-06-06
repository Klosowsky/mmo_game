package com.to.backend.decorator;

import com.to.backend.model.Equipment;
import com.to.backend.model.Hero;
import com.to.backend.model.HeroStatistics;

public class HeroEquipmentDecorator extends HeroDecorator {

    //Hero hero;
    public HeroEquipmentDecorator(Hero hero){
        super(hero);
        //this.hero = hero;
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
        heroStatistics.setAgility(hero.getAgility()+
                (equipment.getArmor()==null ? 0 : equipment.getArmor().getBonusAgility())+
                (equipment.getHelmet()==null ? 0 : equipment.getHelmet().getBonusAgility())+
                (equipment.getWeapon()==null ? 0 : equipment.getWeapon().getBonusAgility()));

        heroStatistics.setIntellect(hero.getIntellect()+
                (equipment.getArmor()==null ? 0 : equipment.getArmor().getBonusIntellect())+
                (equipment.getHelmet()==null ? 0 : equipment.getHelmet().getBonusIntellect())+
                (equipment.getWeapon()==null ? 0 : equipment.getWeapon().getBonusIntellect()));

        heroStatistics.setStrength(hero.getStrength()+
                (equipment.getArmor()==null ? 0 : equipment.getArmor().getBonusStrength())+
                (equipment.getHelmet()==null ? 0 : equipment.getHelmet().getBonusStrength())+
                (equipment.getWeapon()==null ? 0 : equipment.getWeapon().getBonusStrength()));

        return heroStatistics;
    }


    @Override
    public void printHeroStatistics() {

    }

    @Override
    public void levelUp() {

    }
}
