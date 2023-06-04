package com.to.backend.utils;

import com.to.backend.model.Hero;

import java.util.*;

public class HeroRankingSingleton {
    private static HeroRankingSingleton heroRanking;

    private Map<Integer, Hero> heroRankingMap = new HashMap<>();

    private HeroRankingSingleton(List<Hero> heroList){
        heroList.sort(Comparator.comparingInt(Hero::getLevel));
        int i=1;
        for (Hero  hero : heroList) {
            heroRankingMap.put(i,hero);
            i++;
        }
    }

    public static HeroRankingSingleton getInstance(List<Hero> heroList){
        if( heroRanking== null ){
            synchronized (HeroRankingSingleton.class){
                if(heroRanking==null){
                    heroRanking=new HeroRankingSingleton(heroList);
                }
            }
        }
        return heroRanking;
    }

    public Map<Integer,Hero> getHeroRankingMap(){
        return this.heroRankingMap;
    }

}
