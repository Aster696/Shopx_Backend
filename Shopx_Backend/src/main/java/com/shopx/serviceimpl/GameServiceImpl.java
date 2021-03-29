package com.shopx.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopx.dao.GameDAO;
import com.shopx.mail.Email;
import com.shopx.model.Game;
import com.shopx.service.GameService;

@Service
public class GameServiceImpl implements GameService{

	@Autowired
	GameDAO gameDAO;

	public boolean addGame(Game game) {
			gameDAO.addGame(game);
//			Email email = new Email(game.getEmail(), "Game Added", "Thanks for adding your Game on Shopx web site");
//			email.Sendmail();
			return true;
	}

	public boolean updateGame(Game game) {
			gameDAO.updateGame(game);
//			Email email = new Email(game.getEmail(), "Game Updated", "Your game was updated successfully");
//			email.Sendmail();
			return true;
		
	}

	public boolean deleteGame(int id) {
		
			gameDAO.deleteGame(id);
//			Email email = new Email(game.getEmail(), "Game deleted", "Your game is deleted and removed from the Shopx web site");
//			email.Sendmail();
			return true;
		
	}

	public List<Game> displayGames() {
		
			return gameDAO.displayGames();		
		
	}

	public Game displayGameById(int id) {
		
			return gameDAO.displayGameById(id);
		
	}

	public Game displayGameByName(String game_name) {
		
			return gameDAO.displayGameByName(game_name);
	}

	public List<Game> search(String gaem_name) {
		return gameDAO.search(gaem_name);
	}

	public List<Game> displayHighToLow() {
		return gameDAO.displayHighToLow();
	}

	public List<Game> displayLowToHigh() {
		return gameDAO.displayLowToHigh();
	}

	public boolean advertiseGame(Game game) {
		gameDAO.addGame(game);
//		Email email = new Email(user.getEmail(), "Advertisement", "Your game will be advertised soon!!!");
//		email.Sendmail();
		return true;
	}

	public List<String> displayImage(String game_name) {
		
		return gameDAO.displayImage(game_name);
	}

	
}
