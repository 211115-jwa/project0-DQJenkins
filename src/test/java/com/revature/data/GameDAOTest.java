package com.revature.data;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.revature.beans.Game;
import com.revature.beans.Product;
import com.revature.data.postgres.GamePostgres;

// this imports the static methods from Assertions so that
// we can type "assertEquals" rather than "Assertions.assertEquals"
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

//@TestMethodOrder(Alphanumeric.class)
//@TestMethodOrder(OrderAnnotation.class)
public class GameDAOTest {
	private GameDAO gameDao = new GamePostgres();

/*GamePostgres() methods to be tested*/
//Product getById(int id)
	@Test
	public void getByIdWhenIdExists() {
		int idInput = 1;
		Product gameOutput = gameDao.getById(idInput);
		assertEquals(1, gameOutput.getId());
	}

	@Test
	public void getByIdWhenIdDoesNotExists() {
		int idInput = -1;
		Product gameOutput = gameDao.getById(idInput);
		assertNull(gameOutput);
	}

//Set<Product> getAll()
	@Test
	public void getAll() {
		Set<Product> allOutput = gameDao.getAll();
		assertNotNull(allOutput);
	}

//Set<Product> getByName(String name)
	@Test
	public void getByNameWhenNameExists() {
		String name = "The";
		Set<Product> nameOutput = gameDao.getByName(name);
		nameOutput.forEach((Product item) -> {
                assertTrue(item.getName().contains(name));
        });
	}
	
	//This test relies on getByName() and getAll() to both work
	@Test
	public void getByNameWhenNameIsBlank() {
		String name = "";
		Set<Product> blankNameOutput = gameDao.getByName(name);
		assertEquals(gameDao.getAll(), blankNameOutput);
	}
	
	@Test
	public void getByNameWhenNameDoesNotExist() {
		String name = "This Name Totally Doesn't Exist";
		Set<Product> badNameOutput = gameDao.getByName(name);
		assertNull(badNameOutput);
	}
	
//int create(Product dataToAdd)
	@Test
	public void create() {
		Product newGame = new Game();
		int generatedId = gameDao.create(newGame);
		assertNotEquals(0, generatedId);
	}

//void update(Product dataToUpdate)
	@Test
	public void update() {
		Product gameToUpdate = gameDao.getById(1);
		gameToUpdate.setName("New Name");
		gameDao.update(gameToUpdate);
		assertTrue(gameDao.getById(1).getName().contains("New Name"));
	}
	
//void delete(Product dataToDelete)
	@Test
	public void delete() {
		int currentSize = gameDao.getAll().size();
		Product gameToDelete = gameDao.getById(1);
		gameDao.delete(gameToDelete);
		int newSize = gameDao.getAll().size();
		assertEquals(currentSize-1, newSize);
	}
	
//Set<Game> getByPlatform(String platform) 
	@Test
	public void getByPlatformWhenPlatformExists() {
		String platform = "Playstation";
		Set<Game> platformOutput = gameDao.getByPlatform(platform);
		platformOutput.forEach((Game item) -> {
                assertTrue(item.getPlatform().contains(platform));
        });
	}
	
	//This test relies on getByPlatform() and getAll() to both work
	@Test
	public void getByPlatformWhenPlatformIsBlank() {
		String platform = "";
		Set<Game> blankPlatformOutput = gameDao.getByPlatform(platform);
		assertEquals(gameDao.getAll(), blankPlatformOutput);
	}
	
	@Test
	public void getByPlatformWhenPlatformDoesNotExist() {
		String platform = "This Is Not a Real Platform";
		Set<Game> badPlatformOutput = gameDao.getByPlatform(platform);
		assertNull(badPlatformOutput);
	}
	
//Set<Game> getByPublisher(String publisher)
	@Test
	public void getByPublisherWhenPublisherExists() {
		String publisher = "Playstation";
		Set<Game> publisherOutput = gameDao.getByPublisher(publisher);
		publisherOutput.forEach((Game item) -> {
                assertTrue(item.getPublisher().contains(publisher));
        });
	}
	
	//This test relies on getByPublisher() and getAll() to both work
	@Test
	public void getByPublisherWhenPublisherIsBlank() {
		String publisher = "";
		Set<Game> blankPublisherOutput = gameDao.getByPublisher(publisher);
		assertEquals(gameDao.getAll(), blankPublisherOutput);
	}
	
	@Test
	public void getByPublisherWhenPublisherDoesNotExist() {
		String publisher = "This Is Not a Real Publisher";
		Set<Game> badPublisherOutput = gameDao.getByPublisher(publisher);
		assertNull(badPublisherOutput);
	}
}
