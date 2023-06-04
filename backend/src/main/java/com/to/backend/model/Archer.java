package com.to.backend.model;

import com.to.backend.model.Hero;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("archer")
public class Archer extends Hero {
    @Override
    public void heroDetails() {
        System.out.println("I am archer");
    }

    @Override
    public void setHeroStatistics() {
        strength=1;
        intellect=1;
        agility=5;
    }

    @Override
    public void printHeroStatistics() {

    }

    @Override
    public void levelUp() {
        level++;
        agility+=5;
        strength+=3;
        intellect+=1;
        exp=0;
    }
}
