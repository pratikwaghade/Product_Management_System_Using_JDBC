package model;

public class Product {

	private int id;
	private String name;
	private float price;
	private int quantity;
	private String category;
	
//	public Product(int id, String name, float price, int quantity, String category) {
//		
//		this.id = id;
//		this.name = name;
//		this.price = price;
//		this.quantity = quantity;
//		this.category = category;
//	}

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", category="
				+ category + "]";
	}
	
}
	
	