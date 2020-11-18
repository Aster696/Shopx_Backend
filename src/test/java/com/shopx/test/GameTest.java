package com.shopx.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopx.config.DbConfig;
import com.shopx.model.Game;
import com.shopx.serviceimpl.GameServiceImpl;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = DbConfig.class)
public class GameTest {

	@Autowired
	GameServiceImpl gameServiceImpl;
	
	@Test
//	@Ignore
	public void addGame() {
		Game ga = new Game();
		ga.setGame_name("Call of Duty");
		ga.setEmail("cod@gmail.com");
		ga.setBrand("COD Gaming");
		ga.setPlatform("PC");
		ga.setRating("16 +");
		ga.setCategory("Action");
		ga.setDescription("kjds jlkasdfjk  kasdjkasd");
		ga.setQuantity(55);
		ga.setPrice(1200);
		
		assertEquals(true, gameServiceImpl.addGame(ga));
	}
	
	@Test
	@Ignore
	public void updateGame() {
		Game ga = new Game();
		ga.setId(1);
		ga.setGame_name("Gta 5");
		ga.setEmail("rockstar@gmail.com");
		ga.setBrand("Rockstar");
		ga.setPlatform("PC");
		ga.setRating("18 +");
		ga.setDescription("kjds jlkasdfjk  kasdjkasd");
		ga.setQuantity(55);
		ga.setPrice(1200);
		
		assertEquals(true, gameServiceImpl.updateGame(ga));
		
	}
	
	@Test
	@Ignore
	public void deleteGame() {
		assertEquals(true, gameServiceImpl.deleteGame(2));
	}
	
	@Test
	@Ignore
	public void displayGame() {
		assertNotEquals(null, gameServiceImpl.displayGames());
	}
	@Test
	@Ignore
	public void displayGameById() {
		assertNotEquals(null, gameServiceImpl.displayGameById(1));
	}
	
	@Test
	@Ignore
	public void displayGameByName() {
		assertNotEquals(null, gameServiceImpl.displayGameByName("Gta 5"));
	}
}
