package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;


/*
 * exception klasa jest rozszerzona przez runtime exception klas 
 *  wszystkie wyjatki ktore dziedzicza klase runtime excp to typami unchecked (pilnowanie progrmaisty, nullpoitner etc)
 *  
 *  wszystkie klasy ktore dziedzicza z exception sa checked (one musza byc obsluzone za pomoca throws exception)
 * 
 * 
 */


public abstract class Product {
	private final String name;

	private final BigDecimal price;

	private final BigDecimal taxPercent;

	protected Product(String name, BigDecimal price, BigDecimal tax) {

	if (name == null) {
		throw new IllegalArgumentException("name cannot be null");
	}	
	
	// String b = ""; -- jav anam to zamieni na obiekt, jesli sa takie same instancje to java stworzy referencje do obiektu
	if (name.equals("")) {
		throw new IllegalArgumentException("name cannot be empty");
	}	
	if (price == null) {
		throw new IllegalArgumentException("price cannot be empty");
	}	
	if (price.signum() < 0) {
		throw new IllegalArgumentException("price cannot be below 0");
	}	
	
		this.name = name;
		this.price = price;
		this.taxPercent = tax;

	}
	public String getName() {
		return this.name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public BigDecimal getTaxPercent() {
		return this.taxPercent;
	}

	public BigDecimal getPriceWithTax() {
		return this.price.multiply(this.taxPercent).add(this.price);
	}
}
