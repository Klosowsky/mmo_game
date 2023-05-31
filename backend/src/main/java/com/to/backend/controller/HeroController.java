package com.to.backend.controller;

import com.to.backend.decorator.HeroEquipmentDecorator;
import com.to.backend.enums.HeroClassesEnum;
import com.to.backend.factory.ArcherFactory;
import com.to.backend.factory.HeroFactory;
import com.to.backend.factory.MageFactory;
import com.to.backend.factory.WarriorFactory;
import com.to.backend.model.*;
import com.to.backend.services.BagService;
import com.to.backend.services.EquipmentService;
import com.to.backend.services.HeroService;
import com.to.backend.services.ItemService;
import com.to.backend.utils.HeroRankingSingleton;
import com.to.backend.utils.ItemDrawer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hero")
public class HeroController {

    HeroService heroService;
    EquipmentService equipmentService;
    ItemService itemService;
    BagService bagService;

    @Autowired
    public HeroController(HeroService heroService, EquipmentService equipmentService, ItemService itemService, BagService bagService){
        this.heroService = heroService;
        this.equipmentService = equipmentService;
        this.itemService = itemService;
        this.bagService = bagService;
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
        Equipment equipment = new Equipment();
        try{
            hero.setEquipment(equipmentService.saveEquipment(equipment));
            return ResponseEntity.ok(heroService.saveHero(hero));

        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @RequestMapping("/gethero")
    public ResponseEntity<Hero> getHero(@RequestBody Hero heroRequest){
        HeroProxy heroProxy = new HeroProxy(heroService.findById(heroRequest.getHeroId()));
        Hero hero = heroProxy.toValidHero();
        try{
            return ResponseEntity.ok(hero);
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping("/getherofullstat")
    public ResponseEntity<HeroStatistics> getHeroFullStat(@RequestBody Hero heroRequest){
        try{
            HeroProxy heroProxy = new HeroProxy(heroService.findById(heroRequest.getHeroId()));
            Hero hero = heroProxy.toValidHero();
            System.out.println("e");
            HeroEquipmentDecorator heroEquipmentDecorator = new HeroEquipmentDecorator(hero);
            System.out.println("eeeeee");

            return ResponseEntity.ok(heroEquipmentDecorator.getHeroStatistics());
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

    @RequestMapping("/addexp")
    public ResponseEntity<Hero> heroAddExp(@RequestBody Hero heroRequest){
        try{
            return ResponseEntity.ok(heroService.saveHero(heroService.increaseExp(heroRequest.getHeroId())));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping("/levelup")
    public ResponseEntity<Hero> heroLevelUp(@RequestBody Hero heroRequest){
        try{
            return ResponseEntity.ok(heroService.saveHero(heroService.levelUp(heroRequest.getHeroId())));
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @RequestMapping("/ranking")
    public ResponseEntity<Map<Integer,Hero>> showHeroRanking(){
        try{
            HeroRankingSingleton heroRankingSingleton = HeroRankingSingleton.getInstance(heroService.getAllHeroes());
            return ResponseEntity.ok(heroRankingSingleton.getHeroRankingMap());
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping("/getrandomitem")
    public ResponseEntity<Item> getRandomItem(@RequestBody Hero heroRequest){
        try{
            HeroProxy heroProxy = new HeroProxy(heroService.findById(heroRequest.getHeroId()));
            Hero hero = heroProxy.toValidHero();
            System.out.println("e "+itemService.getAllItems());
            Item drawnItem = ItemDrawer.DrawItemForHero(itemService.getAllItems(),hero);
            System.out.println("ee " + drawnItem);
            HeroItemInBag heroItemInBag = new HeroItemInBag();
            System.out.println("eee");
            heroItemInBag.setItem(drawnItem);
            System.out.println("eeee");
            heroItemInBag.setHero(heroService.findById(heroRequest.getHeroId()));
            System.out.println("eeeee");
            bagService.assignToHero(heroItemInBag);
            System.out.println("eeeeee");
            return ResponseEntity.ok(drawnItem);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }


    }


}
