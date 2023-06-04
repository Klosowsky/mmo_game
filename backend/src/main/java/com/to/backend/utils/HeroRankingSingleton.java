package com.to.backend.utils;

import com.to.backend.model.Hero;

import java.util.*;

public class HeroRankingSingleton {
    private static HeroRankingSingleton heroRanking;

    private Map<Integer, Hero> heroRankingMap;

    private HeroRankingSingleton(){

    }

    public static HeroRankingSingleton getInstance(){
        if( heroRanking== null ){
            synchronized (HeroRankingSingleton.class){
                if(heroRanking==null){
                    heroRanking=new HeroRankingSingleton();
                }
            }
        }
        return heroRanking;
    }

    public void refreshRanking(List<Hero> heroList){
        heroRankingMap = new HashMap<>();
        heroList.sort(Comparator.comparingInt(Hero::getLevel));
        Collections.reverse(heroList);
        int i=1;
        for (Hero  hero : heroList) {
            heroRankingMap.put(i,hero);
            i++;
        }
    }

    public Map<Integer,Hero> getHeroRankingMap(){

        return this.heroRankingMap;
    }

}
