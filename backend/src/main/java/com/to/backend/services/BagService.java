package com.to.backend.services;

import com.to.backend.model.HeroItemInBag;
import com.to.backend.repository.BagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BagService {

    BagRepository bagRepository;

    @Autowired
    public BagService(BagRepository bagRepository) {
        this.bagRepository = bagRepository;
    }

    public HeroItemInBag assignToHero(HeroItemInBag heroItemInBag) {
        return bagRepository.save(heroItemInBag);
    }

}
