package com.revature.services;

import java.util.Set;

import com.revature.beans.Game;
import com.revature.data.GameDAO;
import com.revature.data.postgres.GamePostgres;

public class UserServiceImpl implements UserService {
	private GameDAO gameDao = new GamePostgres();

	@Override
	public Set<Game> viewAllGames() {
		return gameDao.getAll();
	}

	@Override
	public Set<Game> searchGamesByName(String nameToSearch) {
		return gameDao.getByName(nameToSearch);
	}

	@Override
	public Set<Game> searchGamesByPlatform(String platformToSearch) {
		return gameDao.getByPlatform(platformToSearch);
	}

	@Override
	public Set<Game> searchGamesByPublisher(String publisherToSearch) {
		return gameDao.getByPublisher(publisherToSearch);
	}

	@Override
	public int addNewGame(Game newGame) {
		return gameDao.create(newGame);
	}

	@Override
	public Game getGameById(int gameId) {
		return gameDao.getById(gameId);
	}

	@Override
	public Game editGame(Game gameToEdit) {
		if (gameDao.getById(gameToEdit.getId()) != null) {
			gameDao.update(gameToEdit);
			gameToEdit = gameDao.getById(gameToEdit.getId());
			return gameToEdit;
		}
		return null;

	}
}
