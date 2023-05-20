package com.to.backend.services;

import com.to.backend.model.Hero;
import com.to.backend.repository.HeroRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroService {

    private final HeroRepository heroRepository;
    @Autowired

    public HeroService(HeroRepository heroRepository){
        this.heroRepository = heroRepository;
    }

    public Hero saveHero(Hero hero){

        return heroRepository.save(hero);
    }



}
