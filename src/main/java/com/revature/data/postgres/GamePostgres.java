package com.revature.data.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.revature.beans.Game;
import com.revature.beans.Product;
import com.revature.data.GameDAO;
import com.revature.utils.ConnectionUtil;

public class GamePostgres implements GameDAO {
	private ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();

	@Override
	public Set<Product> getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(Product dataToAdd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Product getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Product dataToUpdate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Product dataToDelete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<Game> getByPlatform(String platform) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Game> getByPublisher(String publisher) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
