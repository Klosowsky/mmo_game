package com.to.backend.services;

import com.to.backend.model.Hero;
import com.to.backend.model.HeroItemInBag;
import com.to.backend.repository.BagRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BagService {

    BagRepository bagRepository;

    @Autowired
    public BagService(BagRepository bagRepository) {
        this.bagRepository = bagRepository;
    }

    public HeroItemInBag assignToHero(HeroItemInBag heroItemInBag) {
        return bagRepository.save(heroItemInBag);
    }

    public List<HeroItemInBag> getBagAssignForHero(Hero hero){
        return bagRepository.findHeroItemInBagsByHero(hero);
    }

    public void removeBag(Hero hero){
        bagRepository.removeHeroItemInBagsByHero(hero);
    }




}
