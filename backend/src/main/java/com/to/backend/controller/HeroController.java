package com.to.backend.controller;

import com.to.backend.enums.HeroClassesEnum;
import com.to.backend.factory.ArcherFactory;
import com.to.backend.factory.HeroFactory;
import com.to.backend.factory.MageFactory;
import com.to.backend.factory.WarriorFactory;
import com.to.backend.model.*;
import com.to.backend.services.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hero")
public class HeroController {


    HeroService heroService;

    @Autowired
    public HeroController(HeroService heroService){
        this.heroService = heroService;
    }

    @RequestMapping("/save")
    public ResponseEntity<Hero> saveOrUpdate(@RequestBody HeroProxy heroProxy){
        try{
            Hero hero = heroProxy.toValidHero();
            heroService.saveHero(hero);
            return ResponseEntity.ok(hero);
        }catch(Exception ex){
            System.out.println("ex" +ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping("/createhero")
    public ResponseEntity<Hero> createHero(@RequestBody CreateHeroRequestBody rqBody){
        HeroFactory heroFactory;
        if(rqBody.getClassId() == HeroClassesEnum.MAGE.getValue()){
            heroFactory=new MageFactory();
        }
        else if(rqBody.getClassId() == HeroClassesEnum.WARRIOR.getValue()){
            heroFactory=new WarriorFactory();
        }
        else if(rqBody.getClassId() == HeroClassesEnum.ARCHER.getValue()){
            heroFactory=new ArcherFactory();
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        Hero hero = heroFactory.createHero();
        hero.setHeroName(rqBody.getHeroName());
        try{
            heroService.saveHero(hero);
            return ResponseEntity.ok(hero);
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @RequestMapping("/gethero")
    public ResponseEntity<Hero> getHero(@RequestBody Hero heroRequest){
        try{
            return ResponseEntity.ok(heroService.findById(heroRequest.getHeroId()));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping("/removehero")
    public ResponseEntity<Hero> removeHero(@RequestBody Hero heroRequest){
        try{
            return ResponseEntity.ok(heroService.removeHero(heroRequest.getHeroId()));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping("/getallheroes")
    public ResponseEntity<List<Hero>> getAllHeroes(){
        try{
            return ResponseEntity.ok(heroService.getAllHeroes());
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



}
