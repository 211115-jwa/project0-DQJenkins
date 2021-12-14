package com.revature.data;

import java.util.Set;

import com.revature.beans.Product;

public interface ProductDAO extends GenericDAO<Product>{
	public Set<Product> getByName(String name);
}
