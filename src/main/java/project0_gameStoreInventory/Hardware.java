package project0_gameStoreInventory;

public class Hardware extends Product {
	private String manufacturer;

	@Override
	public String toString() {
		return "Hardware [id=" + this.getId() + ", name=" + this.getName() + ", price=" + this.getPrice() 
				+ ", manufacturer=" + manufacturer + ", quantityOnHand=" + this.getQuantityOnHand() 
				+ ", quantityOrdered=" + this.getQuantityOrdered() + "]";
	}
	
	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
}
