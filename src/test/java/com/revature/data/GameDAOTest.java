package com.revature.data;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import com.revature.beans.Game;
import com.revature.data.postgres.GamePostgres;

// this imports the static methods from Assertions so that
// we can type "assertEquals" rather than "Assertions.assertEquals"
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

//@TestMethodOrder(Alphanumeric.class)
@TestMethodOrder(OrderAnnotation.class)
public class GameDAOTest {
	private static GameDAO gameDao = new GamePostgres();
	static int generatedId;
/*GamePostgres() methods to be tested*/
//int create(Game dataToAdd)
	@Test
	@Order(value = 0)
	public void create() {
		Game newGame = new Game();
		generatedId = gameDao.create(newGame);
		assertNotEquals(0, generatedId);
	}
		
//Game getById(int id)
	@Test
	@Order(value = 1)
	public void getByIdWhenIdExists() {
		int idInput = 1;
		Game gameOutput = gameDao.getById(idInput);
		assertEquals(1, gameOutput.getId());
	}

	@Test
	public void getByIdWhenIdDoesNotExists() {
		int idInput = -1;
		Game gameOutput = gameDao.getById(idInput);
		assertNull(gameOutput);
	}

//Set<Game> getAll()
	@Test
	@Order(value = 1)
	public void getAll() {
		Set<Game> allOutput = gameDao.getAll();
		assertNotNull(allOutput);
	}

//Set<Game> getByName(String name)
	@Test
	@Order(value = 1)
	public void getByNameWhenNameExists() {
		String name = "Appaloosa";
		Set<Game> nameOutput = gameDao.getByName(name);
		nameOutput.forEach((Game item) -> {
                assertTrue(item.getName().contains(name));
        });
	}
	
	@Test
	@Order(value = 1)
	public void getByNameWhenNameDoesNotExist() {
		String name = "This Name Totally Doesn't Exist";
		Set<Game> badNameOutput = gameDao.getByName(name);
		//assertNull(badNameOutput);
		Set<Game> emptySet = new HashSet<Game>();
		assertEquals(emptySet, badNameOutput);
	}
	


//void update(Game dataToUpdate)
	@Test
	@Order(value = 1)
	public void update() {
		Game gameToUpdate = gameDao.getById(generatedId);
		gameToUpdate.setName("New Name");
		gameDao.update(gameToUpdate);
		assertTrue(gameDao.getById(generatedId).getName().contains("New Name"));
	}
	

	
//Set<Game> getByPlatform(String platform) 
	@Test
	@Order(value = 1)
	public void getByPlatformWhenPlatformExists() {
		String platform = "Playstation 5";
		Set<Game> platformOutput = gameDao.getByPlatform(platform);
		platformOutput.forEach((Game item) -> {
                assertTrue(item.getPlatform().contains(platform));
        });
	}
	
	@Test
	@Order(value = 1)
	public void getByPlatformWhenPlatformDoesNotExist() {
		String platform = "This Is Not a Real Platform";
		Set<Game> badPlatformOutput = gameDao.getByPlatform(platform);
		//assertNull(badPlatformOutput);
		Set<Game> emptySet = new HashSet<Game>();
		assertEquals(emptySet, badPlatformOutput);
	}
	
//Set<Game> getByPublisher(String publisher)
	@Test
	@Order(value = 1)
	public void getByPublisherWhenPublisherExists() {
		String publisher = "Realblab";
		Set<Game> publisherOutput = gameDao.getByPublisher(publisher);
		publisherOutput.forEach((Game item) -> {
                assertTrue(item.getPublisher().contains(publisher));
        });
	}
	
	@Test
	@Order(value = 1)
	public void getByPublisherWhenPublisherDoesNotExist() {
		String publisher = "This Is Not a Real Publisher";
		Set<Game> badPublisherOutput = gameDao.getByPublisher(publisher);
		//assertNull(badPublisherOutput);
		Set<Game> emptySet = new HashSet<Game>();
		assertEquals(emptySet, badPublisherOutput);
	}
//void delete(Game dataToDelete)
	@Test
	@Order(value = 100)
	public void delete() {
		int currentSize = gameDao.getAll().size();
		Game gameToDelete = gameDao.getById(generatedId);
		gameDao.delete(gameToDelete);
		int newSize = gameDao.getAll().size();
		assertEquals(currentSize-1, newSize);
	}
}
