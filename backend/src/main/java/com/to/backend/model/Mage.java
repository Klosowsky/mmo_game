package com.to.backend.model;

import com.to.backend.model.Hero;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("mage")
public class Mage  extends Hero {


    @Override
    public void heroDetails() {
        System.out.println("I am mage.");
    }

    @Override
    public void setHeroStatistics() {
        strength=1;
        intellect=5;
        agility=1;
    }

    @Override
    public void printHeroStatistics() {

    }

    @Override
    public void levelUp() {
        level++;
        agility+=2;
        strength+=2;
        intellect+=5;
    }
}
