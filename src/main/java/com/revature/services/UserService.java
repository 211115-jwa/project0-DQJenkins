package com.revature.services;

import java.util.Set;

import com.revature.beans.Game;

public interface UserService {
	// services represent business logic - actual user activities.
	// what can a user do?
	
	public Set<Game> viewAllGames();
	public Set<Game> searchGamesByName(String nameToSearch);
	public Set<Game> searchGamesByPlatform(String platformToSearch);
	public Set<Game> searchGamesByPublisher(String publisherToSearch);
	public int addNewGame(Game newGame);
	public Game getGameById(int gameId);
	public Game editGame(Game gameToEdit);
}
