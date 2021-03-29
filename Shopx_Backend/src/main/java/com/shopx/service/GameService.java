package com.shopx.service;

import java.util.List;

import com.shopx.model.Game;

public interface GameService {
	public boolean addGame(Game game);
	public boolean updateGame(Game game);
	public boolean deleteGame(int id);
	public List<Game> displayGames();
	public Game displayGameById(int id);
	public Game displayGameByName(String game_name);
	public List<Game> search(String gaem_name); 
	public List<Game> displayHighToLow();
	public List<Game> displayLowToHigh();
	public boolean advertiseGame(Game game);
	public List<String> displayImage(String game_name);
}
