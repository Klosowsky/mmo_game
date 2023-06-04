package com.to.backend;

import com.to.backend.factory.HeroFactory;
import com.to.backend.factory.MageFactory;
import com.to.backend.model.Hero;
import com.to.backend.services.HeroService;
import com.to.backend.utils.ScriptExecutor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) throws IOException {
		ApplicationContext applicationContext = SpringApplication.run(BackendApplication.class, args);
		ScriptExecutor scriptExecutor =applicationContext.getBean(ScriptExecutor.class);
		scriptExecutor.executeScript("/data.sql");
		System.out.println("start");
/*		HeroFactory heroFactory = new MageFactory();
		Hero hero = heroFactory.createHero();
		hero.setHeroStatistics();
		HeroService heroService = new HeroService();
		heroService.saveHero(hero);*/
	}

}
