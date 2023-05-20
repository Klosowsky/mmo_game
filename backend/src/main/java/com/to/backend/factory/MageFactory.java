package com.to.backend.factory;

import com.to.backend.model.Hero;
import com.to.backend.model.Mage;

public class MageFactory implements HeroFactory{
    @Override
    public Hero createHero() {
        return new Mage();
    }
}
