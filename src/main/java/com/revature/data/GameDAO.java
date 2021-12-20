package com.revature.data;

import java.util.Set;

import com.revature.beans.Game;

public interface GameDAO extends GenericDAO<Game> {
	//Methods specific to Game objects
	public Set<Game> getByName(String name);
	public Set<Game> getByPlatform(String platform);
	public Set<Game> getByPublisher(String publisher);
}