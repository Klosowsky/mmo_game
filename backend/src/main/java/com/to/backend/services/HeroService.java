package com.to.backend.services;

import com.to.backend.model.Hero;
import com.to.backend.repository.HeroRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public Hero removeHero(long id){
        Hero hero = findById(id);
        heroRepository.deleteById(id);
        return hero;
    }

    public Hero findById(long id){
        return heroRepository.findById(id).orElseThrow();
    }

    public List<Hero> getAllHeroes(){
        Iterable<Hero> heroes = heroRepository.findAll();
        List<Hero> heroesList = new ArrayList<>();
        heroes.forEach(hero -> heroesList.add(findById(hero.getHeroId())));
        return heroesList;
    }

    public Hero levelUp(long id){
        Hero hero = findById(id);
        hero.levelUp();
        return hero;
    }



}
