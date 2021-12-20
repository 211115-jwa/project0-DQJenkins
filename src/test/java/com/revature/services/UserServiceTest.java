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
	public static void mockAllGamesSetup() {
		mockAllGames = new HashSet<>();
//		Game fields
//		int id;
//		String name;
		String[] names = {"Super Mario Bros.","The Legend of Zelda","Halo","Super Metroid","Half-Life 2"};
//		float price;
		float[] prices = {19.99f,20.00f,39.99f,59.99f,9.99f};
//		int quantityOnHand;
		int[] quantitiesOnHand = {5, 1, 9, 0, 3};
//		int quantityOrdered;
		int[] quantitiesOrdered = {10, 5, 7, 20, 8};
//		String platform;
		String[] platforms = {"NES","NES","Xbox","Super NES","PC"};
//		String publisher;
		String[] publishers = {"Nintendo","Nintendo","Microsoft","Nintendo","Valve"};
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
	@Test
	public void viewAllGames() {
		when(gameDao.getAll()).thenReturn(mockAllGames);
		
		Set<Game> actualGames = userServ.viewAllGames();
		
		assertEquals(mockAllGames, actualGames);
	}

//	public Set<Game> searchGamesByName(String nameToSearch);
	@Test
	public void searchGamesByNameExists() {
		String name = "Halo";
		Set<Game> mockNameMatch = new HashSet<Game>();
		Game newGame = new Game();
		newGame.setName("Halo");
		mockNameMatch.add(newGame);
		
		when(gameDao.getByName("Halo")).thenReturn(mockNameMatch);
		
		Set<Game> actualGames = userServ.searchGamesByName(name);
		boolean namesMatch = true;
		for (Game game : actualGames) {
			if (!game.getName().equals(name))
				namesMatch = false;
		}
		
		assertTrue(namesMatch);
	}
	
	@Test
	public void searchGamesByNameDoesNotExist() {
		String name = "The Legend of the Stinky Cheese";
		Set<Game> mockNameDoesNotExist = new HashSet<Game>();
		
		when(gameDao.getByName("The Legend of the Stinky Cheese")).thenReturn(mockNameDoesNotExist);
		Set<Game> actualGames = userServ.searchGamesByName(name);
		assertTrue(actualGames.isEmpty());
	}

//	public Set<Game> searchGamesByPlatform(String platformToSearch);
	@Test
	public void searchGamesByPlatformExists() {
		String platform = "NES";
		
		Set<Game> mockPlatformMatch = new HashSet<Game>();
		Game newGame = new Game();
		newGame.setPlatform("NES");
		mockPlatformMatch.add(newGame);
		when(gameDao.getByPlatform("NES")).thenReturn(mockPlatformMatch);
		
		Set<Game> actualGames = userServ.searchGamesByPlatform(platform);
		boolean platformsMatch = true;
		for (Game game : actualGames) {
			if (!game.getPlatform().equals(platform))
				platformsMatch = false;
		}
		
		assertTrue(platformsMatch);
	}
	
	@Test
	public void searchGamesByPlatformDoesNotExist() {
		String platform = "Super Mega Ultra Cube 9000";
		Set<Game> mockPlatformDoesNotExist = new HashSet<Game>();
		
		when(gameDao.getByPlatform("Super Mega Ultra Cube 9000")).thenReturn(mockPlatformDoesNotExist);
		
		Set<Game> actualGames = userServ.searchGamesByPlatform(platform);
		assertTrue(actualGames.isEmpty());
	}
	
//	public Set<Game> searchGamesByPublisher(String publisherToSearch);
	@Test
	public void searchGamesByPublisherExists() {
		String publisher = "Nintendo";
		
		Set<Game> mockPublisherMatch = new HashSet<Game>();
		Game newGame = new Game();
		newGame.setPublisher("Nintendo");
		mockPublisherMatch.add(newGame);
		when(gameDao.getByPublisher("Nintendo")).thenReturn(mockPublisherMatch);
		
		Set<Game> actualGames = userServ.searchGamesByPublisher(publisher);
		boolean publishersMatch = true;
		for (Game game : actualGames) {
			if (!game.getPublisher().equals(publisher))
				publishersMatch = false;
		}
		
		assertTrue(publishersMatch);
	}
	
	@Test
	public void searchGamesByPublisherDoesNotExist() {
		String publisher = "Evil Corp.";
		Set<Game> mockPublisherDoesNotExist = new HashSet<Game>();
		when(gameDao.getByPublisher("Evil Corp.")).thenReturn(mockPublisherDoesNotExist);
		
		Set<Game> actualGames = userServ.searchGamesByPublisher(publisher);
		assertTrue(actualGames.isEmpty());
	}
	
//	public int addNewGame(Game newGame);
	@Test
	public void addNewGameSuccesful() {
		Game game = new Game();
		
		when(gameDao.create(game)).thenReturn(6);
		
		int actualId = userServ.addNewGame(game);
		assertNotEquals(0, actualId);
	}
	
	@Test
	public void addNewGameSomethingWrong() {
		Game game = new Game();
		
		when(gameDao.create(game)).thenReturn(0);
		
		int actualId = userServ.addNewGame(game);
		
		assertEquals(0, actualId);
	}

	
//	public Game getGameById(int gameId);
	@Test
	public void getGameByIdExists() {
		Game game = new Game();
		game.setId(1);
		
		when(gameDao.getById(1)).thenReturn(game);
		
		Game actualGame = userServ.getGameById(1);
		assertEquals(game, actualGame);
	}
	
	@Test
	public void getGameByIdDoesNotExist() {
		when(gameDao.getById(5364)).thenReturn(null);
		
		Game actualGame = userServ.getGameById(5364);
		assertNull(actualGame);
	}

//	public Game editGame(Game gameToEdit);
	@Test
	public void editGameSuccessful() {
		Game editedGame = new Game();
		editedGame.setId(2);
		editedGame.setName("Brand New Game!");
		
		when(gameDao.getById(2)).thenReturn(editedGame);
		doNothing().when(gameDao).update(Mockito.any(Game.class));
		
		Game actualGame = userServ.editGame(editedGame);
		
		assertEquals(editedGame, actualGame);
	}
	
	@Test
	public void editGameSomethingWrong() {
		Game mockGame = new Game();
		mockGame.setId(2);
		
		when(gameDao.getById(2)).thenReturn(mockGame);
		doNothing().when(gameDao).update(Mockito.any(Game.class));
		
		Game editedGame = new Game();
		editedGame.setId(2);
		editedGame.setName("Brand New Game!");
		
		Game actualGame = userServ.editGame(editedGame);
		
		assertNotEquals(editedGame, actualGame);
	}

}
