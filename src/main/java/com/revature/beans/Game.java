package com.revature.beans;

import java.util.Objects;

public class Game{
	protected int id;
	protected String name;
	protected String platform;
	protected String publisher;
	protected float price;
	protected int quantityOnHand;
	protected int quantityOrdered;
	
	
	public Game() {
		id = 0;
		name = "game";
		price = 0.0f;
		quantityOnHand = 0;
		quantityOrdered = 0;
		platform = "platform";
		publisher = "publisher";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name,platform,publisher, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return  id == other.id 
				&& Objects.equals(name, other.name)
				&& Float.floatToIntBits(price) == Float.floatToIntBits(other.price)
				&& Objects.equals(platform, other.platform) 
				&& Objects.equals(publisher, other.publisher);
	}


	@Override
	public String toString() {
		return "Game [id=" + this.getId() + ", name=" + this.getName() + ", price=" + this.getPrice() 
				+ ", platform=" + platform + ", publisher=" + publisher + ", quantityOnHand=" 
				+ this.getQuantityOnHand() + ", quantityOrdered=" + this.getQuantityOrdered() + "]";
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantityOnHand() {
		return quantityOnHand;
	}

	public void setQuantityOnHand(int quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}
