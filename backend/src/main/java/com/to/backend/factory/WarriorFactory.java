package com.to.backend.factory;

import com.to.backend.model.Hero;
import com.to.backend.model.Warrior;

public class WarriorFactory implements HeroFactory{
    @Override
    public Hero createHero() {
        return new Warrior();
    }
}
