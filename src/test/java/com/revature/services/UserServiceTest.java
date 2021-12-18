package com.revature.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.beans.Game;
import com.revature.data.GameDAO;

// tell JUnit that we're using Mockito
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	// tell Mockito which classes/interfaces that we'll be mocking
	@Mock
	private GameDAO gameDao;

	// tell Mockito to override the regular DAOs with our mock DAOs
	@InjectMocks
	private UserService userServ = new UserServiceImpl();
	
	private static Set<Game> mockAllGames;

	@BeforeAll
	public static void mockAvailablePetsSetup() {
		mockAllGames = new HashSet<>();
//		Game fields
//		int id;
//		String name;
		String[] names = {"a","b","c","d","e"};
//		float price;
		float[] prices = {19.99f,20.00f,39.99f,59.99f,9.99f};
//		int quantityOnHand;
		int[] quantitiesOnHand = {5, 1, 9, 0, 3};
//		int quantityOrdered;
		int[] quantitiesOrdered = {10, 5, 7, 20, 8};
//		String platform;
		String[] platforms = {"a","b","c","d","e"};
//		String publisher;
		String[] publishers = {"a","b","c","d","e"};
		for (int i=0; i<5; i++) {
			Game game = new Game();
			game.setId(i+1);
			game.setName(names[i]);
			game.setPrice(prices[i]);
			game.setQuantityOnHand(quantitiesOnHand[i]);
			game.setQuantityOrdered(quantitiesOrdered[i]);
			game.setPlatform(platforms[i]);
			game.setPublisher(publishers[i]);
			mockAllGames.add(game);
		}
	}
	
//	UserService methods to be tested
//	public Set<Game> viewAllGames();
//	public Set<Game> searchGamesByName(String nameToSearch);
//	public Set<Game> searchGamesByPlatform(String platformToSearch);
//	public Set<Game> searchGamesByPublisher(String publisherToSearch);
//	public int addNewGame(Game newGame);
//	public Game getGameById(int gameId);
//	public Game editGame(Game gameToEdit);
	
}
