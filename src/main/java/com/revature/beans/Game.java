package com.revature.beans;

public class Game extends Product {
	private String platform;
	private String publisher;
	
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
