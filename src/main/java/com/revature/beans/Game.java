package com.revature.beans;

import java.util.Objects;

public class Game extends Product {
	protected String platform;
	protected String publisher;
	
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
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(platform, publisher);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
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
