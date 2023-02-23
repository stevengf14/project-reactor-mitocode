package ec.com.learning.reactor.model;

import java.time.LocalDateTime;

public class Product {
	
	private Integer id;
	private String name;
	private LocalDateTime purchaseDate;
	
	public Product(Integer id, String name, LocalDateTime purchaseDate) {
		super();
		this.id = id;
		this.name = name;
		this.purchaseDate = purchaseDate;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDateTime purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", purchaseDate=" + purchaseDate + "]";
	}
	
}
