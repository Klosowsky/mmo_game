package com.to.backend;

import com.to.backend.factory.HeroFactory;
import com.to.backend.factory.MageFactory;
import com.to.backend.model.Hero;
import com.to.backend.services.HeroService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		System.out.println("test");
/*		HeroFactory heroFactory = new MageFactory();
		Hero hero = heroFactory.createHero();
		hero.setHeroStatistics();
		HeroService heroService = new HeroService();
		heroService.saveHero(hero);*/
	}

}
