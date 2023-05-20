package com.to.backend.factory;

import com.to.backend.model.Archer;
import com.to.backend.model.Hero;

public class ArcherFactory implements HeroFactory {

    @Override
    public Hero createHero() {
        return new Archer();
    }
}
