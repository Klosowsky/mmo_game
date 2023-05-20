package com.to.backend.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("warrior")
public class Warrior extends Hero {
    @Override
    public void heroDetails() {
        System.out.println("I am warior!");
    }

    @Override
    public void setHeroStatistics() {
        strength=5;
        intellect=1;
        agility=1;
    }

    @Override
    public void printHeroStatistics() {

    }
}
