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

	//GamePostgres() methods to be tested
	//Set<Product> getByName(String name)
	//int create(Product dataToAdd)
	//Product getById(int id)
	//Set<Product> getAll()
	//void update(Product dataToUpdate)
	//void delete(Product dataToDelete)
	//Set<Game> getByPlatform(String platform) 
	//et<Game> getByPublisher(String publisher)
}
