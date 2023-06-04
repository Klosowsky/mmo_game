package com.to.backend.repository;

import com.to.backend.model.Hero;
import com.to.backend.model.HeroItemInBag;
import com.to.backend.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BagRepository extends JpaRepository<HeroItemInBag,Long> {
    List<HeroItemInBag> findHeroItemInBagsByHero(Hero hero);

    void removeHeroItemInBagsByHero(Hero hero);

}
